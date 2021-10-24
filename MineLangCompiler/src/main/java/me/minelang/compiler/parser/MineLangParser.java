// Generated from D:/MineLang/MineLangCompiler/src/main/antlr\MineLang.g4 by ANTLR 4.9.1
package me.minelang.compiler.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MineLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNC=1, RETURN=2, USING=3, IN=4, IF=5, ELIF=6, ELSE=7, LOOP=8, BREAK=9, 
		CONTINUE=10, COMMA=11, LB=12, RB=13, LA=14, RA=15, START=16, END=17, DOT=18, 
		EQ=19, NEQ=20, SET=21, PLUS=22, MINUS=23, MUTIPLY=24, DEVIDE=25, REMAIN=26, 
		NOT=27, GTR=28, GTREQ=29, LWR=30, LWREQ=31, STRING=32, INT=33, DEC=34, 
		BOOL=35, NONE=36, NAN=37, ID=38, WS=39, COMMENT=40, MUTICOMMENT=41;
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
			"'loop'", "'break'", "'continue'", "','", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'.'", "'=='", "'!='", "'='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'!'", "'>'", "'>='", "'<'", "'<='", null, null, null, null, "'none'", 
			"'nan'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUNC", "RETURN", "USING", "IN", "IF", "ELIF", "ELSE", "LOOP", 
			"BREAK", "CONTINUE", "COMMA", "LB", "RB", "LA", "RA", "START", "END", 
			"DOT", "EQ", "NEQ", "SET", "PLUS", "MINUS", "MUTIPLY", "DEVIDE", "REMAIN", 
			"NOT", "GTR", "GTREQ", "LWR", "LWREQ", "STRING", "INT", "DEC", "BOOL", 
			"NONE", "NAN", "ID", "WS", "COMMENT", "MUTICOMMENT"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << LOOP) | (1L << BREAK) | (1L << LB) | (1L << START) | (1L << STRING) | (1L << INT) | (1L << DEC) | (1L << BOOL) | (1L << NONE) | (1L << NAN) | (1L << ID))) != 0)) {
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << LOOP) | (1L << BREAK) | (1L << LB) | (1L << START) | (1L << STRING) | (1L << INT) | (1L << DEC) | (1L << BOOL) | (1L << NONE) | (1L << NAN) | (1L << ID))) != 0)) {
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
	public static class MutiplyDevideRemainExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUTIPLY() { return getToken(MineLangParser.MUTIPLY, 0); }
		public TerminalNode DEVIDE() { return getToken(MineLangParser.DEVIDE, 0); }
		public TerminalNode REMAIN() { return getToken(MineLangParser.REMAIN, 0); }
		public MutiplyDevideRemainExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterMutiplyDevideRemainExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitMutiplyDevideRemainExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitMutiplyDevideRemainExpr(this);
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
	public static class NotExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(MineLangParser.NOT, 0); }
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
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(31);
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
			case 2:
				{
				_localctx = new VarSetExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(32);
				match(ID);
				setState(33);
				match(SET);
				setState(34);
				expr(14);
				}
				break;
			case 3:
				{
				_localctx = new VarUseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				match(ID);
				}
				break;
			case 4:
				{
				_localctx = new BreakExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				match(BREAK);
				setState(37);
				expr(5);
				}
				break;
			case 5:
				{
				_localctx = new BracketExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				match(LB);
				setState(39);
				expr(0);
				setState(40);
				match(RB);
				}
				break;
			case 6:
				{
				_localctx = new IfelseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				match(IF);
				setState(43);
				expr(0);
				setState(44);
				expr(0);
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(45);
						match(ELIF);
						setState(46);
						expr(0);
						setState(47);
						expr(0);
						}
						} 
					}
					setState(53);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(56);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(54);
					match(ELSE);
					setState(55);
					expr(0);
					}
					break;
				}
				}
				break;
			case 7:
				{
				_localctx = new EndlessLoopExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				match(LOOP);
				setState(59);
				expr(2);
				}
				break;
			case 8:
				{
				_localctx = new BlockExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60);
				match(START);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << LOOP) | (1L << BREAK) | (1L << LB) | (1L << START) | (1L << STRING) | (1L << INT) | (1L << DEC) | (1L << BOOL) | (1L << NONE) | (1L << NAN) | (1L << ID))) != 0)) {
					{
					{
					setState(61);
					expr(0);
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(67);
				match(END);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(89);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MutiplyDevideRemainExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(71);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUTIPLY) | (1L << DEVIDE) | (1L << REMAIN))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(72);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new PlusMinusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(74);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(75);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new IsEqExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(77);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(78);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(79);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(80);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GTR) | (1L << GTREQ) | (1L << LWR) | (1L << LWREQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(81);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new GetExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(83);
						match(DOT);
						setState(84);
						match(ID);
						}
						break;
					case 6:
						{
						_localctx = new FuncCallExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(85);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(86);
						callArgs();
						}
						break;
					case 7:
						{
						_localctx = new NotExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(87);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(88);
						match(NOT);
						}
						break;
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+a\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\3\2\7\2\n\n\2\f\2\16\2\r\13\2\3\2\3\2\3\3\3\3\5\3\23\n\3\3\3"+
		"\3\3\7\3\27\n\3\f\3\16\3\32\13\3\3\3\5\3\35\n\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\64"+
		"\n\4\f\4\16\4\67\13\4\3\4\3\4\5\4;\n\4\3\4\3\4\3\4\3\4\7\4A\n\4\f\4\16"+
		"\4D\13\4\3\4\5\4G\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\\\n\4\f\4\16\4_\13\4\3\4\2\3\6\5\2\4"+
		"\6\2\7\3\2\"\'\3\2\32\34\3\2\30\31\3\2\25\26\3\2\36!\2r\2\13\3\2\2\2\4"+
		"\20\3\2\2\2\6F\3\2\2\2\b\n\5\6\4\2\t\b\3\2\2\2\n\r\3\2\2\2\13\t\3\2\2"+
		"\2\13\f\3\2\2\2\f\16\3\2\2\2\r\13\3\2\2\2\16\17\7\2\2\3\17\3\3\2\2\2\20"+
		"\22\7\16\2\2\21\23\5\6\4\2\22\21\3\2\2\2\22\23\3\2\2\2\23\30\3\2\2\2\24"+
		"\25\7\r\2\2\25\27\5\6\4\2\26\24\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30"+
		"\31\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\33\35\7\r\2\2\34\33\3\2\2\2\34"+
		"\35\3\2\2\2\35\36\3\2\2\2\36\37\7\17\2\2\37\5\3\2\2\2 !\b\4\1\2!G\t\2"+
		"\2\2\"#\7(\2\2#$\7\27\2\2$G\5\6\4\20%G\7(\2\2&\'\7\13\2\2\'G\5\6\4\7("+
		")\7\16\2\2)*\5\6\4\2*+\7\17\2\2+G\3\2\2\2,-\7\7\2\2-.\5\6\4\2.\65\5\6"+
		"\4\2/\60\7\b\2\2\60\61\5\6\4\2\61\62\5\6\4\2\62\64\3\2\2\2\63/\3\2\2\2"+
		"\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66:\3\2\2\2\67\65\3\2\2\28"+
		"9\7\t\2\29;\5\6\4\2:8\3\2\2\2:;\3\2\2\2;G\3\2\2\2<=\7\n\2\2=G\5\6\4\4"+
		">B\7\22\2\2?A\5\6\4\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2"+
		"\2DB\3\2\2\2EG\7\23\2\2F \3\2\2\2F\"\3\2\2\2F%\3\2\2\2F&\3\2\2\2F(\3\2"+
		"\2\2F,\3\2\2\2F<\3\2\2\2F>\3\2\2\2G]\3\2\2\2HI\f\13\2\2IJ\t\3\2\2J\\\5"+
		"\6\4\fKL\f\n\2\2LM\t\4\2\2M\\\5\6\4\13NO\f\t\2\2OP\t\5\2\2P\\\5\6\4\n"+
		"QR\f\b\2\2RS\t\6\2\2S\\\5\6\4\tTU\f\16\2\2UV\7\24\2\2V\\\7(\2\2WX\f\r"+
		"\2\2X\\\5\4\3\2YZ\f\f\2\2Z\\\7\35\2\2[H\3\2\2\2[K\3\2\2\2[N\3\2\2\2[Q"+
		"\3\2\2\2[T\3\2\2\2[W\3\2\2\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2"+
		"^\7\3\2\2\2_]\3\2\2\2\f\13\22\30\34\65:BF[]";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}