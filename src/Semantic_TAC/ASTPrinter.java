package Semantic_TAC;

public class ASTPrinter {

    public static StringBuilder AST = new StringBuilder();
    public static void print(ASTNode node) {
        print(node, 0);
    }

    private static void print(ASTNode node, int indent) {
        if (node == null) {
            printIndent(indent);
            AST.append("null").append("\n");
            return;
        }

//        printIndent(indent);
//        AST.append(node.getClass().getSimpleName());

        if (node instanceof ProgramNode program) {
            AST.append("Program: ").append("\n");
            for (FunctionNode fn : program.getFunctions()) {
                print(fn, indent + 1);
            }
            print(program.getMain(), indent + 1);

        } else if (node instanceof FunctionNode fn) {
            printIndent(indent + 1); AST.append("Function Name: " + fn.getName()).append("\n");
            printIndent(indent + 1); AST.append("returnType: " + fn.getReturnType()).append("\n");
            print(fn.getParams(), indent + 1);
            print(fn.getBody(), indent + 1);
            print(fn.getReturnStmt(), indent + 1);

        } else if (node instanceof MainFunctionNode main) {
            printIndent(indent + 1); AST.append("Main: ").append("\n");
            print(main.getBody(), indent + 1);

        } else if (node instanceof ParamListNode params) {
            printIndent(indent + 1); AST.append("Parameters: ").append("\n");
            for (VariableDeclarationNode p : params.getParams()) {
                print(p, indent + 1);
            }

        } else if (node instanceof VariableDeclarationNode v) {
            printIndent(indent + 1); AST.append("type: " + v.getType() + ", name: " + v.getName()).append("\n");

        } else if (node instanceof ReturnStatementNode ret) {
            printIndent(indent + 1); AST.append("Return: ").append("\n");
            print(ret.getExpr(), indent + 1);

        } else if (node instanceof BodyNode body) {
            printIndent(indent + 1); AST.append("Body: ").append("\n");
            for (ASTNode stmt : body.getStatements()) {
                print(stmt, indent + 1);
            }

        } else if (node instanceof ReadNode r) {
            printIndent(indent + 1); AST.append("read: " + r.getId()).append("\n");

        } else if (node instanceof WriteNode w) {
            printIndent(indent + 1); AST.append("write: ").append("\n");
            print(w.value, indent + 1);

        }else if(node instanceof  EndlNode){
            printIndent(indent + 1);
            AST.append("endl").append("\n");

        } else if (node instanceof AssignmentNode a) {
            printIndent(indent + 1); AST.append("assign: " + a.id).append("\n");
            print(a.expr, indent + 2);

        } else if (node instanceof DeclarationNode d) {
            printIndent(indent + 1); AST.append("type: " + d.type).append("\n");
            for (ASTNode decl : d.decls) {
                print(decl, indent + 2);
            }

        } else if (node instanceof FunctionCallNode f) {
            printIndent(indent + 1); AST.append("call: " + f.functionName).append("\n");
            print(f.args, indent + 2);

        } else if (node instanceof ArgListNode args) {
            printIndent(indent + 1); AST.append("Arguments: ").append("\n");
            for (ASTNode arg : args.funcArgs) {
                print(arg, indent + 1);
            }

        } else if (node instanceof BinaryExprNode b) {
            printIndent(indent + 1); AST.append("op: " + b.operator).append("\n");
            print(b.left, indent + 2);
            print(b.right, indent + 2);

        } else if (node instanceof UnaryExprNode u) {
            printIndent(indent + 1); AST.append("unary op: " + u.operator).append("\n");
            print(u.operand, indent + 2);

        } else if (node instanceof LiteralNode l) {
            printIndent(indent + 1); AST.append("literal: " + l.value).append("\n");

        } else if (node instanceof IdentifierNode i) {
            printIndent(indent + 1); AST.append("identifier: " + i.name).append("\n");

        } else if (node instanceof IfNode i) {
            printIndent(indent + 1); AST.append("IF").append("\n");
            print(i.condition, indent + 2);
            print(i.thenBlock, indent + 2);
            for (ElseIfNode elif : i.elifs) {
                printIndent(indent + 1); AST.append("ELIF").append("\n");
                print(elif.condition, indent + 2);
                print(elif.thenBlock, indent + 2);
            }
            if (i.elseBlock != null) {
                printIndent(indent + 1); AST.append("ELSE").append("\n");
                print(i.elseBlock, indent + 2);
            }

        } else if (node instanceof RepeatNode r) {
            printIndent(indent + 1); AST.append("REPEAT").append("\n");
            print(r.body, indent + 2);
            printIndent(indent + 1); AST.append("UNTIL").append("\n");
            print(r.untilCondition, indent + 2);
        }
    }

    private static void printIndent(int indent) {
        AST.append("  ".repeat(Math.max(0, indent)));
    }
}
