package Semantic_TAC;

import SymbolTable.*;

import java.util.*;

public class Analyzer {
    private final SymbolTable symbolTable = new SymbolTable();
    private final List<String> errors = new ArrayList<>();

    public void analyze(ASTNode node) {
        if (node instanceof ProgramNode program) {
            for (FunctionNode fn : program.getFunctions()) {
                analyzeFunction(fn);
            }
            analyzeMain(program.getMain());
        }
    }

    private void analyzeFunction(FunctionNode fn) {
        List<String> paramTypes = new ArrayList<>();
        if (fn.getParams() != null) {
            for (VariableDeclarationNode param : fn.getParams().getParams()) {
                paramTypes.add(param.getType());
            }
        }

        FunctionSymbol funcSymbol = new FunctionSymbol(fn.getName(), fn.getReturnType(), paramTypes);
        boolean success = symbolTable.declareFunction(fn.getName(), funcSymbol);
        if (!success) {
            errors.add("Line: %d, Redeclaration of Function %s with the same parameter types".formatted(
                fn.getLine(), fn.getName()
            ));
            return;
        }

        symbolTable.enterScope();

        for (VariableDeclarationNode param : fn.getParams().getParams()) {
            declareVariable(param);
        }

        // check return type
        String retType = analyzeExpression(fn.getReturnStmt().getExpr());

        if(retType != null && !retType.equals(fn.getReturnType())){
            errors.add("Line: %d, return expr type: '%s' doesn't match with expected function return type: '%s'".formatted(
                    fn.getReturnStmt().getLine(), retType, fn.getReturnType()
            ));
        }

        analyzeBody(fn.getBody());
        symbolTable.exitScope();
    }


    private void analyzeMain(MainFunctionNode main) {
        symbolTable.enterScope();
        analyzeBody(main.getBody());
        symbolTable.exitScope();
    }

    private void analyzeBody(BodyNode body) {
        for (ASTNode stmt : body.getStatements()) {
            analyzeStatement(stmt);
        }
    }

    private void analyzeStatement(ASTNode stmt) {
        if (stmt instanceof DeclarationNode decl) {
            for (ASTNode d : decl.getDeclarations()) {
                if (d instanceof IdentifierNode id) {
                    declareVariable(decl.getType(), id.getName(), id.getLine());
                } else if (d instanceof AssignmentNode assign) {
                    declareVariable(decl.getType(), assign.getId(), assign.getLine());
                    analyzeStatement(assign);
                }
                else{
                    throw new RuntimeException("Undefined behavior\n");
                }
            }
        } else if (stmt instanceof AssignmentNode assign) {
            Symbol sym = symbolTable.resolveVariable(assign.getId());
            if (sym == null) {
                errors.add("Line: %d, Undeclared variable: '%s'".formatted(assign.getLine(), assign.getId())) ;
                return;
            }
            String type = analyzeExpression(assign.getExpr());
            if(type != null && !type.equals(sym.getType())){
                errors.add("Line: %d, Cannot assign '%s' to variable '%s' of type '%s'".formatted(
                        assign.getLine(), type, sym.getName(), sym.getType()));
            }
        } else if (stmt instanceof ReadNode read) {
            if (symbolTable.resolveVariable(read.getId()) == null) {
                errors.add("Line: %d, Undeclared variable: '%s'".formatted(read.getLine(), read.getId()));
            }
        } else if (stmt instanceof WriteNode write) {
            analyzeExpression(write.getValue());
        } else if (stmt instanceof IfNode ifNode) {
            analyzeExpression(ifNode.getCondition());
            analyzeBody(ifNode.getThenBlock());
            for (ElseIfNode elif : ifNode.getElifs()) {
                analyzeExpression(elif.getCondition());
                analyzeBody(elif.getThenBlock());
            }
            if (ifNode.getElseBlock() != null) {
                analyzeBody(ifNode.getElseBlock());
            }
        } else if (stmt instanceof RepeatNode repeat) {
            analyzeBody(repeat.getBody());
            analyzeExpression(repeat.getUntilCondition());
        } else if (stmt instanceof FunctionCallNode call) {
            if (symbolTable.resolveFunctionsByName(call.getFunctionName()) == null) {
                errors.add("Undeclared function: '" + call.getFunctionName() + "'");
            }
            if (call.getArguments() != null) {
                checkFunctionTypes(call);
            }
        }
    }

    private String analyzeExpression(ASTNode expr) {
        if(expr instanceof LiteralNode literalNode){
            return literalNode.getType();
        }

        if (expr instanceof IdentifierNode id) {
            Symbol s = symbolTable.resolveVariable(id.getName());
            if (s == null) {
                errors.add("Line %d, Undeclared variable: '%s'".formatted(id.getLine(), id.getName()));
                return null;
            }
            return s.getType();
        }

        if (expr instanceof BinaryExprNode binary) {
            String leftType = analyzeExpression(binary.getLeft());
            String rightType = analyzeExpression(binary.getRight());
            String op = binary.getOperator();

            return typeChecking(leftType, rightType, op, binary.getLine());
        }
        else if (expr instanceof UnaryExprNode unary) {
            String type = analyzeExpression(unary.getOperand());
            if(type != null && type.equals("string")){
                errors.add("Line: %d, Unary operator '%s' isn't supported for strings".formatted(unary.getLine(), unary.getOperator()));
            }
            return type;
        } else if (expr instanceof FunctionCallNode call) {

            // all this for the type of function, no function
            List<FunctionSymbol> functions = symbolTable.resolveFunctionsByName(call.getFunctionName());

            if (functions == null) {
                errors.add("Undeclared function: '" + call.getFunctionName() + "'");
                return "error";
            }
            int ind = checkFunctionTypes(call);
            if(ind == -1) {
//                errors.add("Unmatched type between function '%s' and arguments provided".formatted(call.getFunctionName()));
                return "error";
            }

            return functions.get(ind).getType();
//            return type;
        } else if(expr instanceof EndlNode){
            return "nothing";
        }
        throw new RuntimeException("Undefined Behaviour ");
    }

    private void declareVariable(VariableDeclarationNode var) {
        declareVariable(var.getType(), var.getName(), var.getLine());
//        boolean success = symbolTable.declareVariable(var.getName(), new Symbol(var.getName(), var.getType(), SymbolKind.VARIABLE));
//        if (!success) {
//            errors.add("Line: %d, Redeclaration of variable: '%s'".formatted(var.getLine(), var.getName()));
//        }
    }

    private void declareVariable(String type, String name, int errorLine) {
        boolean success = symbolTable.declareVariable(name, new Symbol(name, type, SymbolKind.VARIABLE));
        if (!success) {
            errors.add("Line: %d, Redeclaration of variable: '%s'".formatted(errorLine, name));
        }
    }

    public List<String> getErrors() {
        return errors;
    }

    private String typeChecking(String leftType, String rightType, String op, int errorLine){
        // Check for string operands
        if(leftType == null || rightType == null){
            return "error";
        }

        boolean integerFloatPair = (leftType.equals("int") && rightType.equals("float")) ||
                (leftType.equals("float") && rightType.equals("int"));

        if(List.of("+", "-", "*", "/", "%").contains(op)){
            if (leftType.equals("string") || rightType.equals("string")) {
                errors.add("Line: %d, Invalid operation: binary operator '%s' cannot be applied to types '%s' and '%s'"
                        .formatted(errorLine, op, leftType, rightType));
                return "error";
            }
            if (leftType.equals("bool") || rightType.equals("bool")) {
                errors.add("Line: %d, Arithmetic operations are not supported on 'bool' types".formatted(errorLine));
                return "error";
            }

            if (!leftType.equals(rightType)) {
                if (integerFloatPair) {
                    return "float"; // Implicit promotion
                } else {
                    errors.add("Line: %d, Type mismatch in arithmetic operation: '%s' %s '%s'"
                            .formatted(errorLine, leftType, op, rightType));
                    return "error";
                }
            }

            return leftType; // Same type arithmetic (int or float)
        }

        if(List.of(">", "<", ">=", "<=", "=", "!=").contains(op)){
            if(!leftType.equals(rightType)){
                if(!integerFloatPair){
                    errors.add("Line: %d, Type mismatch in relational expression: '%s' %s '%s'"
                            .formatted(errorLine, leftType, op, rightType));
                    return "error";
                }
            }
            return "bool";
        }

        // Boolean operators
        if (List.of("&&", "||").contains(op)) {
            if (!leftType.equals("bool") || !rightType.equals("bool")) {
                errors.add("Line: %d, Logical operator '%s' requires both operands to be bool, got '%s' and '%s'"
                        .formatted(errorLine, op, leftType, rightType));
                return "error";
            }
            return "bool";
        }


        errors.add("Line: %d, Unknown binary operator: '%s'".formatted(errorLine, op));
        return "error";
    }

    /**
     *
     * @param fn
     * @return the index of the matched function or -1 in case no matching function
     *
     */
    private int checkFunctionTypes(FunctionCallNode fn){
        List<String> argsType = new ArrayList<>();

//        int matchedInd = -1;

        for(ASTNode arg: fn.args.getArgs()){
            argsType.add(analyzeExpression(arg));
        }

        List<FunctionSymbol> functionsMatch = symbolTable.resolveFunctionsByName(fn.getFunctionName());

        if(functionsMatch == null)
            functionsMatch = new ArrayList<>();

        int p = 0;
        for(FunctionSymbol func : functionsMatch){

            if(funcMatch(func, argsType)){
                return p;
            }
            ++p;
        }
        StringBuilder errorMessage = new StringBuilder();

        errorMessage.append("Line: %d, no matching function named '%s' with types ".formatted(fn.getLine(), fn.getFunctionName()));
        int ind = 0;
        int sz = argsType.size();
        for(String type: argsType){
            errorMessage.append("'" + type + "'");
            if(++ind != sz){
                errorMessage.append(", ");
            }
        }

//        errorMessage.append("\n");
        if(!functionsMatch.isEmpty()) {
            errorMessage.append("\nAvailable functions named '%s' ".formatted(fn.getFunctionName()));
            errorMessage.append("\n");
            for (FunctionSymbol func : functionsMatch) {
                ind = 0;
                sz = func.getParamTypes().size();
                for(String type: func.getParamTypes()){
                    errorMessage.append("'" + type + "'");
                    if(++ind != sz){
                        errorMessage.append(", ");
                    }
                }
                if(sz == 0){
                    errorMessage.append("No args");
                }
                errorMessage.append("\n");
            }
        }
        errors.add(errorMessage.toString());
        return -1;

    }

    private boolean funcMatch(FunctionSymbol func, List<String> argsType){
        return func.getParamTypes().equals(argsType);
    }

}
