// Generated from C:/E-JUST/8th semester/Programming Languages and Compilers/Tiny_Compiler/src/grammar/parser/TinyParser.g4 by ANTLR 4.13.2

    package grammar.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TinyParser}.
 */
public interface TinyParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Prog}
	 * labeled alternative in {@link TinyParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProg(TinyParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Prog}
	 * labeled alternative in {@link TinyParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProg(TinyParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MainFunction}
	 * labeled alternative in {@link TinyParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMainFunction(TinyParser.MainFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MainFunction}
	 * labeled alternative in {@link TinyParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMainFunction(TinyParser.MainFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link TinyParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(TinyParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link TinyParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(TinyParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RetType}
	 * labeled alternative in {@link TinyParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterRetType(TinyParser.RetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RetType}
	 * labeled alternative in {@link TinyParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitRetType(TinyParser.RetTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link TinyParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(TinyParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link TinyParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(TinyParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link TinyParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterFloatType(TinyParser.FloatTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link TinyParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitFloatType(TinyParser.FloatTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link TinyParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(TinyParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link TinyParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(TinyParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link TinyParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterStringType(TinyParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link TinyParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitStringType(TinyParser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParameterList}
	 * labeled alternative in {@link TinyParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(TinyParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParameterList}
	 * labeled alternative in {@link TinyParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(TinyParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarDeclaration}
	 * labeled alternative in {@link TinyParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(TinyParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarDeclaration}
	 * labeled alternative in {@link TinyParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(TinyParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RetStatement}
	 * labeled alternative in {@link TinyParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterRetStatement(TinyParser.RetStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RetStatement}
	 * labeled alternative in {@link TinyParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitRetStatement(TinyParser.RetStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BodyBlock}
	 * labeled alternative in {@link TinyParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBodyBlock(TinyParser.BodyBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BodyBlock}
	 * labeled alternative in {@link TinyParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBodyBlock(TinyParser.BodyBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReadStmt(TinyParser.ReadStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReadStmt(TinyParser.ReadStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WriteStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmt(TinyParser.WriteStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WriteStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmt(TinyParser.WriteStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(TinyParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(TinyParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclStmt(TinyParser.DeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclStmt(TinyParser.DeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCallStmt(TinyParser.CallStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCallStmt(TinyParser.CallStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(TinyParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(TinyParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RepeatStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStmt(TinyParser.RepeatStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RepeatStmt}
	 * labeled alternative in {@link TinyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStmt(TinyParser.RepeatStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadStat}
	 * labeled alternative in {@link TinyParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStat(TinyParser.ReadStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadStat}
	 * labeled alternative in {@link TinyParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStat(TinyParser.ReadStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WriteStat}
	 * labeled alternative in {@link TinyParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStat(TinyParser.WriteStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WriteStat}
	 * labeled alternative in {@link TinyParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStat(TinyParser.WriteStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link TinyParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(TinyParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link TinyParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(TinyParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link TinyParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(TinyParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link TinyParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(TinyParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link TinyParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(TinyParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link TinyParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(TinyParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Arguments}
	 * labeled alternative in {@link TinyParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArguments(TinyParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Arguments}
	 * labeled alternative in {@link TinyParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArguments(TinyParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TermExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTermExpr(TinyParser.TermExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TermExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTermExpr(TinyParser.TermExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(TinyParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(TinyParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalANDExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalANDExpr(TinyParser.LogicalANDExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalANDExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalANDExpr(TinyParser.LogicalANDExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondRelExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCondRelExpr(TinyParser.CondRelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondRelExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCondRelExpr(TinyParser.CondRelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondEQExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCondEQExpr(TinyParser.CondEQExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondEQExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCondEQExpr(TinyParser.CondEQExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(TinyParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(TinyParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(TinyParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(TinyParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(TinyParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(TinyParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalORExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalORExpr(TinyParser.LogicalORExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalORExpr}
	 * labeled alternative in {@link TinyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalORExpr(TinyParser.LogicalORExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdTerm}
	 * labeled alternative in {@link TinyParser#term}.
	 * @param ctx the parse tree
	 */
	void enterIdTerm(TinyParser.IdTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdTerm}
	 * labeled alternative in {@link TinyParser#term}.
	 * @param ctx the parse tree
	 */
	void exitIdTerm(TinyParser.IdTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralTerm}
	 * labeled alternative in {@link TinyParser#term}.
	 * @param ctx the parse tree
	 */
	void enterLiteralTerm(TinyParser.LiteralTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralTerm}
	 * labeled alternative in {@link TinyParser#term}.
	 * @param ctx the parse tree
	 */
	void exitLiteralTerm(TinyParser.LiteralTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link TinyParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(TinyParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link TinyParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(TinyParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link TinyParser#literals}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(TinyParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link TinyParser#literals}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(TinyParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RealLiteral}
	 * labeled alternative in {@link TinyParser#literals}.
	 * @param ctx the parse tree
	 */
	void enterRealLiteral(TinyParser.RealLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealLiteral}
	 * labeled alternative in {@link TinyParser#literals}.
	 * @param ctx the parse tree
	 */
	void exitRealLiteral(TinyParser.RealLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link TinyParser#literals}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(TinyParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link TinyParser#literals}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(TinyParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolLiteral}
	 * labeled alternative in {@link TinyParser#literals}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(TinyParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolLiteral}
	 * labeled alternative in {@link TinyParser#literals}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(TinyParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElseStatement}
	 * labeled alternative in {@link TinyParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(TinyParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElseStatement}
	 * labeled alternative in {@link TinyParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(TinyParser.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RepeatStat}
	 * labeled alternative in {@link TinyParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStat(TinyParser.RepeatStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RepeatStat}
	 * labeled alternative in {@link TinyParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStat(TinyParser.RepeatStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Cond}
	 * labeled alternative in {@link TinyParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCond(TinyParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Cond}
	 * labeled alternative in {@link TinyParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCond(TinyParser.CondContext ctx);
}