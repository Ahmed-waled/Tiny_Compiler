package Semantic_TAC;

import java.util.*;

public interface ASTNode {}

class ProgramNode implements ASTNode {
    private final List<FunctionNode> functions = new ArrayList<>();
    private MainFunctionNode main;
    public void addFunction(FunctionNode fn) { functions.add(fn); }
    public void setMain(MainFunctionNode main) { this.main = main; }
    public List<FunctionNode> getFunctions() { return functions; }
    public MainFunctionNode getMain() { return main; }
}

class FunctionNode implements ASTNode {
    private String returnType;
    private String name;
    private ParamListNode params = new ParamListNode();
    private BodyNode body;
    private ReturnStatementNode returnStmt;
    private int line;

    FunctionNode(int line) {
        this.line = line;
    }

    public void setReturnType(String type) { this.returnType = type; }
    public void setName(String name) { this.name = name; }
    public void setParams(ParamListNode params) { this.params = params; }

    public void setBody(BodyNode body) { this.body = body; }
    public void setReturnStmt(ReturnStatementNode stmt) { this.returnStmt = stmt; }

    public String getReturnType() { return returnType; }
    public String getName() { return name; }
    public ParamListNode getParams() { return params; }
    public BodyNode getBody() { return body; }
    public ReturnStatementNode getReturnStmt() { return returnStmt; }

    public int getLine() {
        return line;
    }
}

class MainFunctionNode implements ASTNode {
    private BodyNode body;
    private String returnValue;
    private final int line;

    MainFunctionNode(int line){
        this.line = line;
    }

    public void setBody(BodyNode body) { this.body = body; }
    public void setReturnValue(String val) { this.returnValue = val; }

    public BodyNode getBody() { return body; }
    public String getReturnValue() { return returnValue; }

    public int getLine() {
        return line;
    }
}

class ReturnStatementNode implements ASTNode {
    private ASTNode expr;
    private int line;

    ReturnStatementNode(int line) {
        this.line = line;
    }

    public void setExpr(ASTNode expr) { this.expr = expr; }
    public ASTNode getExpr() { return expr; }

    public int getLine() {
        return line;
    }
}

class ParamListNode implements ASTNode {
    private final List<VariableDeclarationNode> params = new ArrayList<>();
    public void addParam(VariableDeclarationNode param) { params.add(param); }
    public List<VariableDeclarationNode> getParams() { return params; }
}

class VariableDeclarationNode implements ASTNode {
    private final String type;
    private final String name;
    private final int line;

    public VariableDeclarationNode(String type, String name, int line) {
        this.type = type;
        this.name = name;
        this.line = line;
    }

    public String getType() { return type; }
    public String getName() { return name; }

    public int getLine() {
        return line;
    }
}

class BodyNode implements ASTNode {
    private final List<ASTNode> statements = new ArrayList<>();
    public void addStatement(ASTNode stmt) { statements.add(stmt); }
    public List<ASTNode> getStatements() { return statements; }
}

class ReadNode implements ASTNode {
    private String id;
    private int line;
    public ReadNode(String id, int line) {
        this.id = id;
        this.line = line;
    }
    public String getId() { return id; }

    public int getLine() {
        return line;
    }
}

class WriteNode implements ASTNode {
    public ASTNode value;
    public WriteNode(ASTNode value) { this.value = value; }
    public ASTNode getValue() { return value; }
}

class EndlNode implements ASTNode {
    private final String name;

    public EndlNode(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class AssignmentNode implements ASTNode {
    public String id;
    public ASTNode expr;
    public int line;
    public AssignmentNode(String id, ASTNode expr, int line) {
        this.id = id;
        this.expr = expr;
        this.line = line;
    }
    public String getId() { return id; }
    public ASTNode getExpr() { return expr; }

    public int getLine() {
        return line;
    }
}

class DeclarationNode implements ASTNode {
    public String type;
    public List<ASTNode> decls = new ArrayList<>();
    public DeclarationNode(String type) { this.type = type; }
    public void addDeclaration(ASTNode d) { decls.add(d); }
    public String getType() { return type; }
    public List<ASTNode> getDeclarations() { return decls; }
}

class FunctionCallNode implements ASTNode {
    public String functionName;
    public ArgListNode args;

    private int line;
    public FunctionCallNode(String functionName, int line) {
        this.functionName = functionName;
        this.line = line;
    }
    public void setArgs(ArgListNode args) { this.args = args; }
    public String getFunctionName() { return functionName; }
    public ArgListNode getArguments() { return args; }

    public int getLine() {
        return line;
    }
}

class ArgListNode implements ASTNode {
    public List<ASTNode> funcArgs = new ArrayList<>();
    public void addArg(ASTNode arg){ funcArgs.add(arg); }
    public List<ASTNode> getArgs() { return funcArgs; }
}

class IfNode implements ASTNode {
    public ASTNode condition;
    public BodyNode thenBlock;
    public List<ElseIfNode> elifs = new ArrayList<>();
    public BodyNode elseBlock;

    public ASTNode getCondition() { return condition; }
    public BodyNode getThenBlock() { return thenBlock; }
    public List<ElseIfNode> getElifs() { return elifs; }
    public BodyNode getElseBlock() { return elseBlock; }
}

class ElseIfNode implements ASTNode {
    public ASTNode condition;
    public BodyNode thenBlock;

    public ASTNode getCondition() { return condition; }
    public BodyNode getThenBlock() { return thenBlock; }
}

class RepeatNode implements ASTNode {
    public BodyNode body;
    public ASTNode untilCondition;

    public BodyNode getBody() { return body; }
    public ASTNode getUntilCondition() { return untilCondition; }
}

class BinaryExprNode implements ASTNode {
    public ASTNode left, right;
    public String operator;
    private int line;
    public BinaryExprNode(ASTNode left, String op, ASTNode right, int line) {
        this.left = left;
        this.operator = op;
        this.right = right;
        this.line = line;
    }
    public ASTNode getLeft() { return left; }
    public ASTNode getRight() { return right; }
    public String getOperator() { return operator; }

    public int getLine() {
        return line;
    }
}

class CondOpNode implements ASTNode{
    public String operator;
    public CondOpNode(String op){
        operator = op;
    }

    public String getOperator() {
        return operator;
    }
}

class UnaryExprNode implements ASTNode {
    public String operator;
    public ASTNode operand;
    private int line;
    public UnaryExprNode(String operator, ASTNode operand, int line) {
        this.operator = operator;
        this.operand = operand;
        this.line = line;
    }
    public String getOperator() { return operator; }
    public ASTNode getOperand() { return operand; }

    public int getLine() {
        return line;
    }
}

class LiteralNode implements ASTNode {
    public String value;
    public String type;
    public LiteralNode(String value) {
        this.value = value;
        this.type = getType(value);
    }
    public String getValue() { return value; }

    public String getType() {
        return type;
    }

    public String getType(String value) {
        if(isInteger(value))
            return "int";
        if(isReal(value))
            return "float";
        if(isBool(value))
            return "bool";

        return "string";
    }

    private boolean isInteger(String value){
        try{
            Integer.parseInt(value);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private boolean isReal(String value){
        try{
            Double.parseDouble(value);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private boolean isBool(String value){
        return "true".equals(value) || "false".equals(value);
    }
}

class IdentifierNode implements ASTNode {
    public String name;
    public int line;
    public IdentifierNode(String name, int line) {
        this.name = name;
        this.line = line;
    }
    public String getName() { return name; }

    public int getLine() {
        return line;
    }
}
