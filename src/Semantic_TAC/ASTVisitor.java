package Semantic_TAC;

import grammar.parser.*;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ASTVisitor extends TinyParserBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProg(TinyParser.ProgContext ctx) {
        ProgramNode program = new ProgramNode();
        ctx.function().forEach(f -> program.addFunction((FunctionNode) visit(f)));
        program.setMain((MainFunctionNode) visit(ctx.main()));
        return program;
    }

    @Override
    public ASTNode visitMainFunction(TinyParser.MainFunctionContext ctx) {
        MainFunctionNode main = new MainFunctionNode(ctx.MAIN().getSymbol().getLine());
        main.setBody((BodyNode) visit(ctx.body()));
        if (ctx.RETURN() != null) {
            main.setReturnValue(ctx.INTEGER().getText());
        }
        return main;
    }

    @Override
    public ASTNode visitFunctionDeclaration(TinyParser.FunctionDeclarationContext ctx) {
        FunctionNode function = new FunctionNode(ctx.ID().getSymbol().getLine());
        function.setReturnType(ctx.returnType().getText());
        function.setName(ctx.ID().getText());
        if (ctx.paramList() != null) {
            function.setParams((ParamListNode) visit(ctx.paramList()));
        }
        function.setBody((BodyNode) visit(ctx.body()));
        function.setReturnStmt((ReturnStatementNode) visit(ctx.returnStatement()));
        return function;
    }

    @Override
    public ASTNode visitRetStatement(TinyParser.RetStatementContext ctx) {
        ReturnStatementNode ret = new ReturnStatementNode(ctx.RETURN().getSymbol().getLine());
        ret.setExpr(visit(ctx.expr()));
//        ret.setLine(ctx.RETURN().getSymbol().getLine());
        return ret;
    }

    @Override
    public ASTNode visitParameterList(TinyParser.ParameterListContext ctx) {
        ParamListNode paramList = new ParamListNode();
        ctx.variableDeclaration().forEach(vd -> paramList.addParam((VariableDeclarationNode) visit(vd)));
        return paramList;
    }

    @Override
    public ASTNode visitVarDeclaration(TinyParser.VarDeclarationContext ctx) {
        return new VariableDeclarationNode(ctx.dataType().getText(), ctx.ID().getText(), ctx.ID().getSymbol().getLine());
    }

    @Override
    public ASTNode visitBodyBlock(TinyParser.BodyBlockContext ctx) {
        BodyNode body = new BodyNode();
        ctx.statement().forEach(stmt -> body.addStatement(visit(stmt)));
        return body;
    }

    @Override
    public ASTNode visitReadStmt(TinyParser.ReadStmtContext ctx) {
        return visit(ctx.readStatement());
    }
    @Override
    public ASTNode visitWriteStmt(TinyParser.WriteStmtContext ctx) {
        return visit(ctx.writeStatement());
    }
    @Override
    public ASTNode visitAssignStmt(TinyParser.AssignStmtContext ctx) {
        return visit(ctx.assignmentStatement());
    }
    @Override
    public ASTNode visitDeclStmt(TinyParser.DeclStmtContext ctx) {
        return visit(ctx.declarationStatement());
    }
    @Override
    public ASTNode visitCallStmt(TinyParser.CallStmtContext ctx) {
        return visit(ctx.functionCallStatement());
    }
    @Override
    public ASTNode visitIfStmt(TinyParser.IfStmtContext ctx) {
        return visit(ctx.ifStatement());
    }
    @Override
    public ASTNode visitRepeatStmt(TinyParser.RepeatStmtContext ctx) {
        return visit(ctx.repeatStatement());
    }

    @Override
    public ASTNode visitReadStat(TinyParser.ReadStatContext ctx) {
        return new ReadNode(ctx.ID().getText(), ctx.ID().getSymbol().getLine());
    }

    @Override
    public ASTNode visitWriteStat(TinyParser.WriteStatContext ctx) {
        ASTNode node;
        if(ctx.ENDL() != null){
            node = new EndlNode(ctx.ENDL().getText());
        }
        else{
            node = visit(ctx.expr());
        }
        return new WriteNode(node);
    }
    @Override
    public ASTNode visitAssignment(TinyParser.AssignmentContext ctx) {
        return new AssignmentNode(ctx.ID().getText(), visit(ctx.expr()), ctx.ID().getSymbol().getLine());
    }
    @Override
    public ASTNode visitDeclaration(TinyParser.DeclarationContext ctx) {
        DeclarationNode decNode = new DeclarationNode(ctx.dataType().getText());
        for(TerminalNode id : ctx.ID()){
            IdentifierNode identifierNode = new IdentifierNode(id.getText(), id.getSymbol().getLine());
            decNode.addDeclaration(identifierNode);
        }
        for(TinyParser.AssignmentStatementContext assignmentStatementContext: ctx.assignmentStatement()){
            decNode.addDeclaration(visit(assignmentStatementContext));
        }
        return decNode;
    }
    @Override
    public ASTNode visitFunctionCall(TinyParser.FunctionCallContext ctx) {
        FunctionCallNode functionCallNode = new FunctionCallNode(ctx.ID().getText(), ctx.ID().getSymbol().getLine());

        if (ctx.argList() != null) {
            ArgListNode argListNode = (ArgListNode) visit(ctx.argList());
            functionCallNode.setArgs(argListNode);
        }

        return functionCallNode;
    }

    @Override
    public ASTNode visitArguments(TinyParser.ArgumentsContext ctx) {
        ArgListNode argListNode = new ArgListNode();
        for (TinyParser.ExprContext arg : ctx.expr()) {
            ASTNode argument = visit(arg);
            argListNode.addArg(argument);
        }
        return argListNode;

    }

    @Override
    public ASTNode visitLogicalORExpr(TinyParser.LogicalORExprContext ctx) {
        ASTNode left = visit(ctx.expr(0));
        ASTNode right = visit(ctx.expr(1));
        String op = null;
        try {
            op = ctx.OR().getText();
        }catch(RuntimeException e){
            System.err.println("Error in logical OR");
        }

        return new BinaryExprNode(left, op, right, ctx.OR().getSymbol().getLine());
    }

    @Override
    public ASTNode visitLogicalANDExpr(TinyParser.LogicalANDExprContext ctx) {
        ASTNode left = visit(ctx.expr(0));
        ASTNode right = visit(ctx.expr(1));
        String op = null;
        try {
            op = ctx.AND().getText();
        }catch(RuntimeException e){
            System.err.println("Error in logical AND");
        }

        return new BinaryExprNode(left, op, right, ctx.AND().getSymbol().getLine());
    }

    @Override
    public ASTNode visitCondEQExpr(TinyParser.CondEQExprContext ctx) {
        ASTNode left = visit(ctx.expr(0));
        ASTNode right = visit(ctx.expr(1));
        String op = null;
        try {
            if(ctx.EQ() != null)
                op = ctx.EQ().getText();
            else
                op = ctx.NEQ().getText();
        }catch(RuntimeException e){
            System.err.println("Error in Cond EQ");
        }

        return new BinaryExprNode(left, op, right, ctx.EQ().getSymbol().getLine());
    }

    @Override
    public ASTNode visitCondRelExpr(TinyParser.CondRelExprContext ctx) {
        ASTNode left = visit(ctx.expr(0));
        ASTNode right = visit(ctx.expr(1));
        String op = null;
        int line = -1;
        try {
            if(ctx.GEQ() != null) {
                op = ctx.GEQ().getText();
                line = ctx.GEQ().getSymbol().getLine();
            }
            else if(ctx.GT() != null) {
                op = ctx.GT().getText();
                line = ctx.GT().getSymbol().getLine();
            }
            else if(ctx.LEQ() != null) {
                op = ctx.LEQ().getText();
                line = ctx.LEQ().getSymbol().getLine();
            }
            else {
                op = ctx.LT().getText();
                line = ctx.LT().getSymbol().getLine();
            }
        }catch(RuntimeException e){
            System.err.println("Error in Relation expr");
        }

        return new BinaryExprNode(left, op, right, line);
    }

    @Override
    public ASTNode visitAddExpr(TinyParser.AddExprContext ctx) {
        ASTNode left = visit(ctx.expr(0));
        ASTNode right = visit(ctx.expr(1));
        String op = null;
        try {
            if(ctx.PLUS() != null)
                op = ctx.PLUS().getText();
            else
                op = ctx.MINUS().getText();
        }catch(RuntimeException e){
            System.err.println("Error in Add expr");
        }

        return new BinaryExprNode(left, op, right, ctx.PLUS() != null ?
                ctx.PLUS().getSymbol().getLine():
                ctx.MINUS().getSymbol().getLine());
    }

    @Override
    public ASTNode visitMulExpr(TinyParser.MulExprContext ctx) {
        ASTNode left = visit(ctx.expr(0));
        ASTNode right = visit(ctx.expr(1));
        String op = null;
        int line = -1;
        try {
            if(ctx.MUL() != null) {
                op = ctx.MUL().getText();
                line = ctx.MUL().getSymbol().getLine();
            }
            else if(ctx.MOD() != null){
                op = ctx.MOD().getText();
                line = ctx.MOD().getSymbol().getLine();
            }
            else {
                op = ctx.DIV().getText();
                line = ctx.DIV().getSymbol().getLine();
            }
        }catch(RuntimeException e){
            System.err.println("Error in Mul Expr");
        }

        return new BinaryExprNode(left, op, right, line);
    }
    @Override
    public ASTNode visitNotExpr(TinyParser.NotExprContext ctx) {
        ASTNode expr = visit(ctx.expr());

        String not = null;
        if(ctx.NOT() != null)
            not = "!";

        return new UnaryExprNode(not, expr, ctx.NOT().getSymbol().getLine());
    }

    @Override
    public ASTNode visitParenExpr(TinyParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }
    @Override
    public ASTNode visitFunctionCallExpr(TinyParser.FunctionCallExprContext ctx) {
        return visit(ctx.functionCallStatement());
    }
    @Override
    public ASTNode visitTermExpr(TinyParser.TermExprContext ctx) {
        return visit(ctx.term());
    }
    @Override
    public ASTNode visitIdTerm(TinyParser.IdTermContext ctx) {
        return new IdentifierNode(ctx.ID().getText(), ctx.ID().getSymbol().getLine());
    }
    @Override
    public ASTNode visitLiteralTerm(TinyParser.LiteralTermContext ctx) {
        return visit(ctx.literals());
    }

    @Override
    public ASTNode visitIntLiteral(TinyParser.IntLiteralContext ctx) {
        return new LiteralNode(ctx.INTEGER().getText());
    }

    @Override
    public ASTNode visitRealLiteral(TinyParser.RealLiteralContext ctx) {
        return new LiteralNode(ctx.REALNUMBER().getText());
    }
    @Override
    public ASTNode visitStringLiteral(TinyParser.StringLiteralContext ctx) {
        return new LiteralNode(ctx.STR().getText());
    }

    @Override
    public ASTNode visitBoolLiteral(TinyParser.BoolLiteralContext ctx) {
        return new LiteralNode(ctx.BOOL().getText());
    }

    @Override
    public ASTNode visitIfElseStatement(TinyParser.IfElseStatementContext ctx) {
        IfNode ifNode = new IfNode();
        ifNode.condition = visit(ctx.condition(0));
        ifNode.thenBlock = (BodyNode) visit(ctx.body(0));


        // Handle optional `elif` branches
        int elifCount = ctx.ELIF().size();
        for (int i = 0; i < elifCount; i++) {
            ElseIfNode elif = new ElseIfNode();
            elif.condition = visit(ctx.condition(i + 1)); // First condition is the `if` condition
            elif.thenBlock = (BodyNode) visit(ctx.body(i + 1));
            ifNode.elifs.add(elif);
        }

        // Handle optional `else` branch
        if (ctx.ELSE() != null) {
            int elseIndex = ctx.body().size() - 1;
            ifNode.elseBlock = (BodyNode) visit(ctx.body(elseIndex));
        }

        return ifNode;
    }
    @Override
    public ASTNode visitRepeatStat(TinyParser.RepeatStatContext ctx) {
        RepeatNode repeat = new RepeatNode();
        repeat.body = (BodyNode) visit(ctx.body());
        repeat.untilCondition = visit(ctx.condition());
        return repeat;
    }

    @Override
    public ASTNode visitCond(TinyParser.CondContext ctx) {
        return visit(ctx.expr());
    }
    @Override
    public ASTNode visitBoolType(TinyParser.BoolTypeContext ctx) {
        return super.visitBoolType(ctx);
    }

    @Override
    public ASTNode visitFloatType(TinyParser.FloatTypeContext ctx) {
        return super.visitFloatType(ctx);
    }

    @Override
    public ASTNode visitIntType(TinyParser.IntTypeContext ctx) {
        return super.visitIntType(ctx);
    }

    @Override
    public ASTNode visitStringType(TinyParser.StringTypeContext ctx) {
        return super.visitStringType(ctx);
    }

    @Override
    public ASTNode visitRetType(TinyParser.RetTypeContext ctx) {
        return visit(ctx.dataType());
    }



}