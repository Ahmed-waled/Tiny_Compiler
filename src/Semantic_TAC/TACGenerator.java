package Semantic_TAC;

import java.util.ArrayList;
import java.util.List;

public class TACGenerator {
    private int tempCounter = 0;
    private int labelCounter = 0;

    public static class CodeObject {
        public List<String> code = new ArrayList<>();
        public String resultName;
    }

    private String freshTemp() {
        return "$T" + (tempCounter++);
    }

    private String freshLabel() {
        return "L" + (labelCounter++);
    }

    public CodeObject generate(ASTNode node) {
        if (node instanceof LiteralNode lit) {
            CodeObject co = new CodeObject();
            co.resultName = lit.getValue();
            return co;

        } else if (node instanceof IdentifierNode id) {
            CodeObject co = new CodeObject();
            co.resultName = id.getName();
            return co;

        } else if (node instanceof BinaryExprNode bin) {
            CodeObject left = generate(bin.getLeft());
            CodeObject right = generate(bin.getRight());
            String temp = freshTemp();
            CodeObject co = new CodeObject();

            co.code.addAll(left.code);
            co.code.addAll(right.code);

            String op = switch (bin.getOperator()) {
                case "+" -> "ADDI";
                case "-" -> "SUBI";
                case "*" -> "MULTI";
                case "/" -> "DIVI";
                case "%" -> "MODI";
                case ">" -> "GT";
                case "<" -> "LT";
                case ">=" -> "GE";
                case "<=" -> "LE";
                case "=" -> "EQ";
                case "!=" -> "NE";
                case "&&" -> "AND";
                case "||" -> "OR";
                default -> throw new RuntimeException("Unknown operator: " + bin.getOperator());
            };

            co.code.add(op + " " + left.resultName + " " + right.resultName + " " + temp);
            co.resultName = temp;
            return co;

        } else if (node instanceof UnaryExprNode unary) {
            CodeObject expr = generate(unary.getOperand());
            CodeObject co = new CodeObject();
            co.code.addAll(expr.code);
            String temp = freshTemp();
            co.code.add("NOT " + expr.resultName + " " + temp);
            co.resultName = temp;
            return co;

        } else if (node instanceof AssignmentNode assign) {
            CodeObject expr = generate(assign.getExpr());
            CodeObject co = new CodeObject();
            co.code.addAll(expr.code);
            co.code.add("STORE " + expr.resultName + " " + assign.getId());
            return co;

        } else if (node instanceof DeclarationNode decl) {
            CodeObject co = new CodeObject();
            for (ASTNode d : decl.getDeclarations()) {
                if (d instanceof IdentifierNode id) {
                    co.code.add("DECL " + id.getName());
                } else if (d instanceof AssignmentNode assign) {
                    co.code.addAll(generate(assign).code);
                }
            }
            return co;

        } else if (node instanceof ReadNode read) {
            CodeObject co = new CodeObject();
            co.code.add("READ " + read.getId());
            return co;

        } else if (node instanceof WriteNode write) {
            CodeObject expr = generate(write.getValue());
            CodeObject co = new CodeObject();
            co.code.addAll(expr.code);
            co.code.add("WRITE " + expr.resultName);
            return co;

        } else if (node instanceof IfNode ifNode) {
            CodeObject co = new CodeObject();

            // ---------- Handle IF ----------
            CodeObject cond = generate(ifNode.getCondition());
            String nextLabel = freshLabel(); // Label for next elseif or else
            String endLabel = freshLabel();  // Final exit label after if-else

            co.code.addAll(cond.code);
            co.code.add("JUMPZ " + cond.resultName + " " + nextLabel);
            co.code.addAll(generate(ifNode.getThenBlock()).code);
            co.code.add("JUMP " + endLabel);
            co.code.add("LABEL " + nextLabel);

            // ---------- Handle ELSEIF ----------
            List<ElseIfNode> elifs = ifNode.getElifs();
            for (ElseIfNode elif : elifs) {
                //                boolean isLastElif = (i == elifs.size() - 1);
                String nextElifLabel = freshLabel();

                CodeObject elifCond = generate(elif.getCondition());
                co.code.addAll(elifCond.code);
                co.code.add("JUMPZ " + elifCond.resultName + " " + nextElifLabel);
                co.code.addAll(generate(elif.getThenBlock()).code);
                co.code.add("JUMP " + endLabel);
                co.code.add("LABEL " + nextElifLabel);
            }

            // ---------- Handle ELSE ----------
            if (ifNode.getElseBlock() != null) {
                co.code.addAll(generate(ifNode.getElseBlock()).code);
            }

            co.code.add("LABEL " + endLabel);
            return co;
        }
        else if (node instanceof RepeatNode repeat) {
            String startLabel = freshLabel();
            CodeObject body = generate(repeat.getBody());
            CodeObject cond = generate(repeat.getUntilCondition());
            CodeObject co = new CodeObject();

            co.code.add("LABEL " + startLabel);
            co.code.addAll(body.code);
            co.code.addAll(cond.code);
            co.code.add("JUMPZ " + cond.resultName + " " + startLabel);
            return co;

        } else if (node instanceof BodyNode body) {
            CodeObject co = new CodeObject();
            for (ASTNode stmt : body.getStatements()) {
                co.code.addAll(generate(stmt).code);
            }
            return co;

        } else if (node instanceof FunctionCallNode call) {
            CodeObject co = new CodeObject();
            for (ASTNode arg : call.getArguments().getArgs()) {
                CodeObject argCo = generate(arg);
                co.code.addAll(argCo.code);
                co.code.add("PARAM " + argCo.resultName);
            }
            String result = freshTemp();
            co.code.add("CALL " + call.getFunctionName() + " " + result);
            co.resultName = result;
            return co;
        }
        else if (node instanceof FunctionNode functionNode) {
            CodeObject bodyCode = generate(functionNode.getBody());
            CodeObject co = new CodeObject();

            co.code.add("LABEL " + functionNode.getName());

            // Declare parameters
            if (functionNode.getParams() != null) {
                for (VariableDeclarationNode param : functionNode.getParams().getParams()) {
                    co.code.add("PARAM " + param.getName());
                }
            }

            co.code.addAll(bodyCode.code);

            if (functionNode.getReturnStmt() != null && functionNode.getReturnStmt().getExpr() != null) {
                CodeObject retExpr = generate(functionNode.getReturnStmt().getExpr());
                co.code.addAll(retExpr.code);
                co.code.add("RET " + retExpr.resultName);
            } else {
                co.code.add("RET");
            }

            return co;
        }

        else if (node instanceof MainFunctionNode mainFunctionNode) {
            CodeObject bodyCode = generate(mainFunctionNode.getBody());

            CodeObject co = new CodeObject();
            co.code.add("LABEL main");
            co.code.addAll(bodyCode.code);

            if (mainFunctionNode.getReturnValue() != null) {
                co.code.add("RET " + mainFunctionNode.getReturnValue());
            } else {
                co.code.add("RET");
            }

            return co;
        }
        else if (node instanceof ProgramNode programNode) {
            CodeObject co = new CodeObject();

            // Generate code for all user-defined functions first
            for (FunctionNode fn : programNode.getFunctions()) {
                co.code.addAll(generate(fn).code);
            }

            // Then generate main
            co.code.addAll(generate(programNode.getMain()).code);

            return co;
        }


        return new CodeObject(); // Default fallback
    }
}
