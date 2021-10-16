// Generated from D:/MineLang/MineCompiler/src/main/antlr\MineLang.g4 by ANTLR 4.9.1
package me.minelang.compiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MineLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MineLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MineLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MineLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineLangParser#pkgName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPkgName(MineLangParser.PkgNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineLangParser#funcArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncArgs(MineLangParser.FuncArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineLangParser#callArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallArgs(MineLangParser.CallArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MineLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallStat(MineLangParser.FuncCallStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcDeclareStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDeclareStat(MineLangParser.FuncDeclareStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(MineLangParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code usingStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingStat(MineLangParser.UsingStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varSetStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarSetStat(MineLangParser.VarSetStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifelseStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelseStat(MineLangParser.IfelseStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loopStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStat(MineLangParser.LoopStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStat(MineLangParser.ContinueStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MineLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStat(MineLangParser.BreakStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powerExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExpr(MineLangParser.PowerExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(MineLangParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mutiplyDevideExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMutiplyDevideExpr(MineLangParser.MutiplyDevideExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isEqExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsEqExpr(MineLangParser.IsEqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetExpr(MineLangParser.GetExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(MineLangParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varUseExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarUseExpr(MineLangParser.VarUseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusMinusExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinusExpr(MineLangParser.PlusMinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpr(MineLangParser.FuncCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(MineLangParser.CompareExprContext ctx);
}