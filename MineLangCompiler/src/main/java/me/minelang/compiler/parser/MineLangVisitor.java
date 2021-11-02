// Generated from D:/MineLang/MineLangCompiler/src/main/antlr\MineLang.g4 by ANTLR 4.9.1
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
	 * Visit a parse tree produced by {@link MineLangParser#callArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallArgs(MineLangParser.CallArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varSetExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarSetExpr(MineLangParser.VarSetExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifelseExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelseExpr(MineLangParser.IfelseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketExpr(MineLangParser.BracketExprContext ctx);
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
	 * Visit a parse tree produced by the {@code breakExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakExpr(MineLangParser.BreakExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueExpr(MineLangParser.ContinueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalExpr(MineLangParser.GlobalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code split}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSplit(MineLangParser.SplitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(MineLangParser.NotExprContext ctx);
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
	 * Visit a parse tree produced by the {@code logicExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr(MineLangParser.LogicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varUseExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarUseExpr(MineLangParser.VarUseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code endlessLoopExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndlessLoopExpr(MineLangParser.EndlessLoopExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockExpr(MineLangParser.BlockExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code positiveNegativeExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositiveNegativeExpr(MineLangParser.PositiveNegativeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplyDivideRemainExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyDivideRemainExpr(MineLangParser.MultiplyDivideRemainExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link MineLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(MineLangParser.CompareExprContext ctx);
}