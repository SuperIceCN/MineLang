// Generated from D:/MineLang/MineCompiler/src/main/antlr\MineLang.g4 by ANTLR 4.9.1
package me.minelang.compiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MineLangParser}.
 */
public interface MineLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MineLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MineLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MineLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MineLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MineLangParser#pkgName}.
	 * @param ctx the parse tree
	 */
	void enterPkgName(MineLangParser.PkgNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MineLangParser#pkgName}.
	 * @param ctx the parse tree
	 */
	void exitPkgName(MineLangParser.PkgNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MineLangParser#funcArgs}.
	 * @param ctx the parse tree
	 */
	void enterFuncArgs(MineLangParser.FuncArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MineLangParser#funcArgs}.
	 * @param ctx the parse tree
	 */
	void exitFuncArgs(MineLangParser.FuncArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MineLangParser#callArgs}.
	 * @param ctx the parse tree
	 */
	void enterCallArgs(MineLangParser.CallArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MineLangParser#callArgs}.
	 * @param ctx the parse tree
	 */
	void exitCallArgs(MineLangParser.CallArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MineLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MineLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MineLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MineLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallStat(MineLangParser.FuncCallStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallStat(MineLangParser.FuncCallStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcDeclareStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterFuncDeclareStat(MineLangParser.FuncDeclareStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcDeclareStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitFuncDeclareStat(MineLangParser.FuncDeclareStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(MineLangParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(MineLangParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code usingStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterUsingStat(MineLangParser.UsingStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code usingStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitUsingStat(MineLangParser.UsingStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varSetStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterVarSetStat(MineLangParser.VarSetStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varSetStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitVarSetStat(MineLangParser.VarSetStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifelseStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfelseStat(MineLangParser.IfelseStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifelseStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfelseStat(MineLangParser.IfelseStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loopStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterLoopStat(MineLangParser.LoopStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loopStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitLoopStat(MineLangParser.LoopStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterContinueStat(MineLangParser.ContinueStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitContinueStat(MineLangParser.ContinueStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(MineLangParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(MineLangParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpr(MineLangParser.PowerExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpr(MineLangParser.PowerExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(MineLangParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(MineLangParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mutiplyDevideExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMutiplyDevideExpr(MineLangParser.MutiplyDevideExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mutiplyDevideExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMutiplyDevideExpr(MineLangParser.MutiplyDevideExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isEqExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIsEqExpr(MineLangParser.IsEqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isEqExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIsEqExpr(MineLangParser.IsEqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGetExpr(MineLangParser.GetExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGetExpr(MineLangParser.GetExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(MineLangParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(MineLangParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varUseExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarUseExpr(MineLangParser.VarUseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varUseExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarUseExpr(MineLangParser.VarUseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusMinusExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusMinusExpr(MineLangParser.PlusMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusMinusExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusMinusExpr(MineLangParser.PlusMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(MineLangParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(MineLangParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(MineLangParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(MineLangParser.CompareExprContext ctx);
}