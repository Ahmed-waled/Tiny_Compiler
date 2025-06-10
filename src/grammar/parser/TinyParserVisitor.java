// Generated from C:/E-JUST/8th semester/Programming Languages and Compilers/Tiny_Compiler/src/grammar/parser/TinyParser.g4 by ANTLR 4.13.2

    package grammar.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TinyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TinyParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Prog}
	 * labeled alternative in {@link TinyParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(TinyParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MainFunction}
	 * labeled alternative in {@link TinyParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFunction(TinyParser.MainFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link TinyParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(TinyParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RetType}
	 * labeled alternative in {@link TinyParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetType(TinyParser.RetTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link TinyParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(TinyParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link TinyParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(TinyParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link TinyParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(TinyParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link TinyParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(TinyParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParameterList}
	 * labeled alternative in {@link TinyParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(TinyParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDeclaration}
	 * labeled alternative in {@link TinyParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(TinyParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RetStatement}
	 * labeled alternative in {@link TinyParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetStatement(TinyParser.RetStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BodyBlock}
	 * labeled alternative in {@link TinyParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyBlock(TinyParser.BodyBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStmt(TinyParser.ReadStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WriteStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStmt(TinyParser.WriteStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(TinyParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclStmt(TinyParser.DeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStmt(TinyParser.CallStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(TinyParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RepeatStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStmt(TinyParser.RepeatStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadStat}
	 * labeled alternative in {@link TinyParser#readStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStat(TinyParser.ReadStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WriteStat}
	 * labeled alternative in {@link TinyParser#writeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStat(TinyParser.WriteStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link TinyParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(TinyParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link TinyParser#declarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(TinyParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link TinyParser#functionCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(TinyParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Arguments}
	 * labeled alternative in {@link TinyParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(TinyParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TermExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermExpr(TinyParser.TermExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(TinyParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalANDExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalANDExpr(TinyParser.LogicalANDExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondRelExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondRelExpr(TinyParser.CondRelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondEQExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondEQExpr(TinyParser.CondEQExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(TinyParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(TinyParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(TinyParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalORExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalORExpr(TinyParser.LogicalORExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdTerm}
	 * labeled alternative in {@link TinyParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdTerm(TinyParser.IdTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralTerm}
	 * labeled alternative in {@link TinyParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralTerm(TinyParser.LiteralTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link TinyParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(TinyParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link TinyParser#literals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(TinyParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RealLiteral}
	 * labeled alternative in {@link TinyParser#literals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealLiteral(TinyParser.RealLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link TinyParser#literals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(TinyParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolLiteral}
	 * labeled alternative in {@link TinyParser#literals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(TinyParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElseStatement}
	 * labeled alternative in {@link TinyParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStatement(TinyParser.IfElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RepeatStat}
	 * labeled alternative in {@link TinyParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStat(TinyParser.RepeatStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Cond}
	 * labeled alternative in {@link TinyParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(TinyParser.CondContext ctx);
}