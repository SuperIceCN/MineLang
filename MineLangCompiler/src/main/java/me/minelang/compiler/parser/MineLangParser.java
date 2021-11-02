// Generated from D:/MineLang/MineLangCompiler/src/main/antlr\MineLang.g4 by ANTLR 4.9.1
package me.minelang.compiler.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MineLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNC=1, RETURN=2, USING=3, IN=4, IF=5, ELIF=6, ELSE=7, LOOP=8, BREAK=9, 
		CONTINUE=10, GLOBAL=11, COMMA=12, SEMICOLON=13, LB=14, RB=15, LA=16, RA=17, 
		START=18, END=19, DOT=20, EQ=21, NEQ=22, SET=23, PLUS=24, MINUS=25, MULTIPLY=26, 
		DIVIDE=27, REMAIN=28, NOT=29, AND=30, OR=31, GTR=32, GTREQ=33, LWR=34, 
		LWREQ=35, STRING=36, INT=37, DEC=38, BOOL=39, NONE=40, NAN=41, ID=42, 
		WS=43, COMMENT=44, MUTICOMMENT=45;
	public static final int
		RULE_program = 0, RULE_callArgs = 1, RULE_expr = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "callArgs", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'return'", "'using'", "'in'", "'if'", null, "'else'", 
			"'loop'", "'break'", "'continue'", "'global'", "','", null, "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'.'", "'=='", "'!='", "'='", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'!'", "'&'", "'|'", "'>'", "'>='", "'<'", "'<='", 
			null, null, null, null, "'none'", "'nan'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUNC", "RETURN", "USING", "IN", "IF", "ELIF", "ELSE", "LOOP", 
			"BREAK", "CONTINUE", "GLOBAL", "COMMA", "SEMICOLON", "LB", "RB", "LA", 
			"RA", "START", "END", "DOT", "EQ", "NEQ", "SET", "PLUS", "MINUS", "MULTIPLY", 
			"DIVIDE", "REMAIN", "NOT", "AND", "OR", "GTR", "GTREQ", "LWR", "LWREQ", 
			"STRING", "INT", "DEC", "BOOL", "NONE", "NAN", "ID", "WS", "COMMENT", 
			"MUTICOMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MineLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MineLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MineLangParser.EOF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << LOOP) | (1L << BREAK) | (1L << CONTINUE) | (1L << GLOBAL) | (1L << SEMICOLON) | (1L << LB) | (1L << START) | (1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << STRING) | (1L << INT) | (1L << DEC) | (1L << BOOL) | (1L << NONE) | (1L << NAN) | (1L << ID))) != 0)) {
				{
				{
				setState(6);
				expr(0);
				}
				}
				setState(11);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(12);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallArgsContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(MineLangParser.LB, 0); }
		public TerminalNode RB() { return getToken(MineLangParser.RB, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MineLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MineLangParser.COMMA, i);
		}
		public CallArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterCallArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitCallArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitCallArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallArgsContext callArgs() throws RecognitionException {
		CallArgsContext _localctx = new CallArgsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_callArgs);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(LB);
			setState(16);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << LOOP) | (1L << BREAK) | (1L << CONTINUE) | (1L << GLOBAL) | (1L << SEMICOLON) | (1L << LB) | (1L << START) | (1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << STRING) | (1L << INT) | (1L << DEC) | (1L << BOOL) | (1L << NONE) | (1L << NAN) | (1L << ID))) != 0)) {
				{
				setState(15);
				expr(0);
				}
			}

			setState(22);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(18);
					match(COMMA);
					setState(19);
					expr(0);
					}
					} 
				}
				setState(24);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(25);
				match(COMMA);
				}
			}

			setState(28);
			match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarSetExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(MineLangParser.ID, 0); }
		public TerminalNode SET() { return getToken(MineLangParser.SET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarSetExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterVarSetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitVarSetExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitVarSetExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfelseExprContext extends ExprContext {
		public TerminalNode IF() { return getToken(MineLangParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(MineLangParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(MineLangParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(MineLangParser.ELSE, 0); }
		public IfelseExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterIfelseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitIfelseExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitIfelseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketExprContext extends ExprContext {
		public TerminalNode LB() { return getToken(MineLangParser.LB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RB() { return getToken(MineLangParser.RB, 0); }
		public BracketExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterBracketExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitBracketExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitBracketExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusMinusExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(MineLangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MineLangParser.MINUS, 0); }
		public PlusMinusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterPlusMinusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitPlusMinusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitPlusMinusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CallArgsContext callArgs() {
			return getRuleContext(CallArgsContext.class,0);
		}
		public FuncCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterFuncCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitFuncCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitFuncCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakExprContext extends ExprContext {
		public TerminalNode BREAK() { return getToken(MineLangParser.BREAK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BreakExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterBreakExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitBreakExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitBreakExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueExprContext extends ExprContext {
		public TerminalNode CONTINUE() { return getToken(MineLangParser.CONTINUE, 0); }
		public ContinueExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterContinueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitContinueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitContinueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GlobalExprContext extends ExprContext {
		public TerminalNode GLOBAL() { return getToken(MineLangParser.GLOBAL, 0); }
		public List<TerminalNode> ID() { return getTokens(MineLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MineLangParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MineLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MineLangParser.COMMA, i);
		}
		public GlobalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterGlobalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitGlobalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitGlobalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SplitContext extends ExprContext {
		public TerminalNode SEMICOLON() { return getToken(MineLangParser.SEMICOLON, 0); }
		public SplitContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterSplit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitSplit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitSplit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(MineLangParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsEqExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(MineLangParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MineLangParser.NEQ, 0); }
		public IsEqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterIsEqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitIsEqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitIsEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MineLangParser.DOT, 0); }
		public TerminalNode ID() { return getToken(MineLangParser.ID, 0); }
		public GetExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterGetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitGetExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitGetExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralExprContext extends ExprContext {
		public TerminalNode INT() { return getToken(MineLangParser.INT, 0); }
		public TerminalNode DEC() { return getToken(MineLangParser.DEC, 0); }
		public TerminalNode STRING() { return getToken(MineLangParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(MineLangParser.BOOL, 0); }
		public TerminalNode NONE() { return getToken(MineLangParser.NONE, 0); }
		public TerminalNode NAN() { return getToken(MineLangParser.NAN, 0); }
		public LiteralExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(MineLangParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(MineLangParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(MineLangParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(MineLangParser.OR, i);
		}
		public LogicExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterLogicExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitLogicExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarUseExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(MineLangParser.ID, 0); }
		public VarUseExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterVarUseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitVarUseExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitVarUseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EndlessLoopExprContext extends ExprContext {
		public TerminalNode LOOP() { return getToken(MineLangParser.LOOP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EndlessLoopExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterEndlessLoopExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitEndlessLoopExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitEndlessLoopExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockExprContext extends ExprContext {
		public TerminalNode START() { return getToken(MineLangParser.START, 0); }
		public TerminalNode END() { return getToken(MineLangParser.END, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlockExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterBlockExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitBlockExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitBlockExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PositiveNegativeExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(MineLangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MineLangParser.MINUS, 0); }
		public PositiveNegativeExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterPositiveNegativeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitPositiveNegativeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitPositiveNegativeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplyDivideRemainExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULTIPLY() { return getToken(MineLangParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(MineLangParser.DIVIDE, 0); }
		public TerminalNode REMAIN() { return getToken(MineLangParser.REMAIN, 0); }
		public MultiplyDivideRemainExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterMultiplyDivideRemainExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitMultiplyDivideRemainExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitMultiplyDivideRemainExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GTR() { return getToken(MineLangParser.GTR, 0); }
		public TerminalNode GTREQ() { return getToken(MineLangParser.GTREQ, 0); }
		public TerminalNode LWR() { return getToken(MineLangParser.LWR, 0); }
		public TerminalNode LWREQ() { return getToken(MineLangParser.LWREQ, 0); }
		public CompareExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterCompareExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitCompareExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new SplitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(31);
				match(SEMICOLON);
				}
				break;
			case 2:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(32);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << INT) | (1L << DEC) | (1L << BOOL) | (1L << NONE) | (1L << NAN))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				{
				_localctx = new VarUseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				match(ID);
				}
				break;
			case 4:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				match(NOT);
				setState(35);
				expr(15);
				}
				break;
			case 5:
				{
				_localctx = new PositiveNegativeExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(37);
				expr(12);
				}
				break;
			case 6:
				{
				_localctx = new VarSetExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				match(ID);
				setState(39);
				match(SET);
				setState(40);
				expr(8);
				}
				break;
			case 7:
				{
				_localctx = new BreakExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				match(BREAK);
				setState(43);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(42);
					expr(0);
					}
					break;
				}
				}
				break;
			case 8:
				{
				_localctx = new ContinueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				match(CONTINUE);
				}
				break;
			case 9:
				{
				_localctx = new BracketExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				match(LB);
				setState(47);
				expr(0);
				setState(48);
				match(RB);
				}
				break;
			case 10:
				{
				_localctx = new IfelseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
				match(IF);
				setState(51);
				expr(0);
				setState(52);
				expr(0);
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(53);
						match(ELIF);
						setState(54);
						expr(0);
						setState(55);
						expr(0);
						}
						} 
					}
					setState(61);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(64);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(62);
					match(ELSE);
					setState(63);
					expr(0);
					}
					break;
				}
				}
				break;
			case 11:
				{
				_localctx = new EndlessLoopExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				match(LOOP);
				setState(67);
				expr(3);
				}
				break;
			case 12:
				{
				_localctx = new BlockExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(START);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << LOOP) | (1L << BREAK) | (1L << CONTINUE) | (1L << GLOBAL) | (1L << SEMICOLON) | (1L << LB) | (1L << START) | (1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << STRING) | (1L << INT) | (1L << DEC) | (1L << BOOL) | (1L << NONE) | (1L << NAN) | (1L << ID))) != 0)) {
					{
					{
					setState(69);
					expr(0);
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(75);
				match(END);
				}
				break;
			case 13:
				{
				_localctx = new GlobalExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				match(GLOBAL);
				setState(78);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(77);
					match(ID);
					}
					break;
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(80);
						match(COMMA);
						setState(81);
						match(ID);
						}
						} 
					}
					setState(86);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(114);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplyDivideRemainExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(90);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLY) | (1L << DIVIDE) | (1L << REMAIN))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(91);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new PlusMinusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(93);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new IsEqExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(96);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(97);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(99);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GTR) | (1L << GTREQ) | (1L << LWR) | (1L << LWREQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(100);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new LogicExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(106);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case AND:
							{
							{
							setState(102);
							match(AND);
							setState(103);
							match(AND);
							}
							}
							break;
						case OR:
							{
							{
							setState(104);
							match(OR);
							setState(105);
							match(OR);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(108);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new GetExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(110);
						match(DOT);
						setState(111);
						match(ID);
						}
						break;
					case 7:
						{
						_localctx = new FuncCallExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(113);
						callArgs();
						}
						break;
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 17);
		case 6:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/z\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\3\2\7\2\n\n\2\f\2\16\2\r\13\2\3\2\3\2\3\3\3\3\5\3\23\n\3\3\3"+
		"\3\3\7\3\27\n\3\f\3\16\3\32\13\3\3\3\5\3\35\n\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4.\n\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\3\4\5\4C\n\4\3"+
		"\4\3\4\3\4\3\4\7\4I\n\4\f\4\16\4L\13\4\3\4\3\4\3\4\5\4Q\n\4\3\4\3\4\7"+
		"\4U\n\4\f\4\16\4X\13\4\5\4Z\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4m\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4u\n"+
		"\4\f\4\16\4x\13\4\3\4\2\3\6\5\2\4\6\2\7\3\2&+\3\2\32\33\3\2\34\36\3\2"+
		"\27\30\3\2\"%\2\u0094\2\13\3\2\2\2\4\20\3\2\2\2\6Y\3\2\2\2\b\n\5\6\4\2"+
		"\t\b\3\2\2\2\n\r\3\2\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\16\3\2\2\2\r\13\3"+
		"\2\2\2\16\17\7\2\2\3\17\3\3\2\2\2\20\22\7\20\2\2\21\23\5\6\4\2\22\21\3"+
		"\2\2\2\22\23\3\2\2\2\23\30\3\2\2\2\24\25\7\16\2\2\25\27\5\6\4\2\26\24"+
		"\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\34\3\2\2\2\32\30"+
		"\3\2\2\2\33\35\7\16\2\2\34\33\3\2\2\2\34\35\3\2\2\2\35\36\3\2\2\2\36\37"+
		"\7\21\2\2\37\5\3\2\2\2 !\b\4\1\2!Z\7\17\2\2\"Z\t\2\2\2#Z\7,\2\2$%\7\37"+
		"\2\2%Z\5\6\4\21&\'\t\3\2\2\'Z\5\6\4\16()\7,\2\2)*\7\31\2\2*Z\5\6\4\n+"+
		"-\7\13\2\2,.\5\6\4\2-,\3\2\2\2-.\3\2\2\2.Z\3\2\2\2/Z\7\f\2\2\60\61\7\20"+
		"\2\2\61\62\5\6\4\2\62\63\7\21\2\2\63Z\3\2\2\2\64\65\7\7\2\2\65\66\5\6"+
		"\4\2\66=\5\6\4\2\678\7\b\2\289\5\6\4\29:\5\6\4\2:<\3\2\2\2;\67\3\2\2\2"+
		"<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>B\3\2\2\2?=\3\2\2\2@A\7\t\2\2AC\5\6\4\2"+
		"B@\3\2\2\2BC\3\2\2\2CZ\3\2\2\2DE\7\n\2\2EZ\5\6\4\5FJ\7\24\2\2GI\5\6\4"+
		"\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MZ\7\25"+
		"\2\2NP\7\r\2\2OQ\7,\2\2PO\3\2\2\2PQ\3\2\2\2QV\3\2\2\2RS\7\16\2\2SU\7,"+
		"\2\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WZ\3\2\2\2XV\3\2\2\2Y \3\2"+
		"\2\2Y\"\3\2\2\2Y#\3\2\2\2Y$\3\2\2\2Y&\3\2\2\2Y(\3\2\2\2Y+\3\2\2\2Y/\3"+
		"\2\2\2Y\60\3\2\2\2Y\64\3\2\2\2YD\3\2\2\2YF\3\2\2\2YN\3\2\2\2Zv\3\2\2\2"+
		"[\\\f\20\2\2\\]\t\4\2\2]u\5\6\4\21^_\f\17\2\2_`\t\3\2\2`u\5\6\4\20ab\f"+
		"\r\2\2bc\t\5\2\2cu\5\6\4\16de\f\f\2\2ef\t\6\2\2fu\5\6\4\rgl\f\13\2\2h"+
		"i\7 \2\2im\7 \2\2jk\7!\2\2km\7!\2\2lh\3\2\2\2lj\3\2\2\2mn\3\2\2\2nu\5"+
		"\6\4\fop\f\23\2\2pq\7\26\2\2qu\7,\2\2rs\f\22\2\2su\5\4\3\2t[\3\2\2\2t"+
		"^\3\2\2\2ta\3\2\2\2td\3\2\2\2tg\3\2\2\2to\3\2\2\2tr\3\2\2\2ux\3\2\2\2"+
		"vt\3\2\2\2vw\3\2\2\2w\7\3\2\2\2xv\3\2\2\2\20\13\22\30\34-=BJPVYltv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}