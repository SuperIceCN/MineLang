// Generated from D:/MineLang/MineCompiler/src/main/antlr\MineLang.g4 by ANTLR 4.9.1
package me.minelang.compiler.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MineLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNC=1, RETURN=2, USING=3, IN=4, IF=5, ELIF=6, ELSE=7, LOOP=8, BREAK=9, 
		CONTINUE=10, COMMA=11, LB=12, RB=13, LA=14, RA=15, START=16, END=17, DOT=18, 
		EQ=19, NEQ=20, SET=21, PLUS=22, MINUS=23, MUTIPLY=24, DEVIDE=25, POWER=26, 
		NOT=27, GTR=28, GTREQ=29, LWR=30, LWREQ=31, STRING=32, INT=33, REAL=34, 
		BOOL=35, NONE=36, ID=37, WS=38, COMMENT=39, MUTICOMMENT=40;
	public static final int
		RULE_program = 0, RULE_pkgName = 1, RULE_funcArgs = 2, RULE_callArgs = 3, 
		RULE_block = 4, RULE_stat = 5, RULE_expr = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "pkgName", "funcArgs", "callArgs", "block", "stat", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'return'", "'using'", "'in'", "'if'", null, "'else'", 
			"'loop'", "'break'", "'continue'", "','", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'.'", "'=='", "'!='", "'='", "'+'", "'-'", "'*'", "'/'", 
			"'^'", "'!'", "'>'", "'>='", "'<'", "'<='", null, null, null, null, "'none'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUNC", "RETURN", "USING", "IN", "IF", "ELIF", "ELSE", "LOOP", 
			"BREAK", "CONTINUE", "COMMA", "LB", "RB", "LA", "RA", "START", "END", 
			"DOT", "EQ", "NEQ", "SET", "PLUS", "MINUS", "MUTIPLY", "DEVIDE", "POWER", 
			"NOT", "GTR", "GTREQ", "LWR", "LWREQ", "STRING", "INT", "REAL", "BOOL", 
			"NONE", "ID", "WS", "COMMENT", "MUTICOMMENT"
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
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
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
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUNC) | (1L << RETURN) | (1L << USING) | (1L << IF) | (1L << LOOP) | (1L << BREAK) | (1L << CONTINUE) | (1L << STRING) | (1L << INT) | (1L << REAL) | (1L << BOOL) | (1L << NONE) | (1L << ID))) != 0)) {
				{
				{
				setState(14);
				stat();
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
			match(Recognizer.EOF);
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

	public static class PkgNameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MineLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MineLangParser.ID, i);
		}
		public List<TerminalNode> DOT() { return getTokens(MineLangParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(MineLangParser.DOT, i);
		}
		public PkgNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pkgName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterPkgName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitPkgName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitPkgName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PkgNameContext pkgName() throws RecognitionException {
		PkgNameContext _localctx = new PkgNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pkgName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(ID);
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(23);
				match(DOT);
				setState(24);
				match(ID);
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class FuncArgsContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(MineLangParser.LB, 0); }
		public TerminalNode RB() { return getToken(MineLangParser.RB, 0); }
		public List<TerminalNode> ID() { return getTokens(MineLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MineLangParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MineLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MineLangParser.COMMA, i);
		}
		public FuncArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterFuncArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitFuncArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitFuncArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgsContext funcArgs() throws RecognitionException {
		FuncArgsContext _localctx = new FuncArgsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcArgs);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(LB);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(31);
				match(ID);
				}
			}

			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(34);
					match(COMMA);
					setState(35);
					match(ID);
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(41);
				match(COMMA);
				}
			}

			setState(44);
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
		enterRule(_localctx, 6, RULE_callArgs);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(LB);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << INT) | (1L << REAL) | (1L << BOOL) | (1L << NONE) | (1L << ID))) != 0)) {
				{
				setState(47);
				expr(0);
				}
			}

			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(50);
					match(COMMA);
					setState(51);
					expr(0);
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(57);
				match(COMMA);
				}
			}

			setState(60);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(MineLangParser.START, 0); }
		public TerminalNode END() { return getToken(MineLangParser.END, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(START);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUNC) | (1L << RETURN) | (1L << USING) | (1L << IF) | (1L << LOOP) | (1L << BREAK) | (1L << CONTINUE) | (1L << STRING) | (1L << INT) | (1L << REAL) | (1L << BOOL) | (1L << NONE) | (1L << ID))) != 0)) {
				{
				{
				setState(63);
				stat();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			match(END);
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncCallStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CallArgsContext callArgs() {
			return getRuleContext(CallArgsContext.class,0);
		}
		public FuncCallStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterFuncCallStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitFuncCallStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitFuncCallStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfelseStatContext extends StatContext {
		public TerminalNode IF() { return getToken(MineLangParser.IF, 0); }
		public List<TerminalNode> LB() { return getTokens(MineLangParser.LB); }
		public TerminalNode LB(int i) {
			return getToken(MineLangParser.LB, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RB() { return getTokens(MineLangParser.RB); }
		public TerminalNode RB(int i) {
			return getToken(MineLangParser.RB, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(MineLangParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(MineLangParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(MineLangParser.ELSE, 0); }
		public IfelseStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterIfelseStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitIfelseStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitIfelseStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoopStatContext extends StatContext {
		public TerminalNode LOOP() { return getToken(MineLangParser.LOOP, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LoopStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterLoopStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitLoopStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitLoopStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatContext extends StatContext {
		public TerminalNode RETURN() { return getToken(MineLangParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitReturnStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueStatContext extends StatContext {
		public TerminalNode CONTINUE() { return getToken(MineLangParser.CONTINUE, 0); }
		public ContinueStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterContinueStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitContinueStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitContinueStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncDeclareStatContext extends StatContext {
		public TerminalNode FUNC() { return getToken(MineLangParser.FUNC, 0); }
		public TerminalNode ID() { return getToken(MineLangParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<FuncArgsContext> funcArgs() {
			return getRuleContexts(FuncArgsContext.class);
		}
		public FuncArgsContext funcArgs(int i) {
			return getRuleContext(FuncArgsContext.class,i);
		}
		public FuncDeclareStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterFuncDeclareStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitFuncDeclareStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitFuncDeclareStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarSetStatContext extends StatContext {
		public TerminalNode ID() { return getToken(MineLangParser.ID, 0); }
		public TerminalNode SET() { return getToken(MineLangParser.SET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarSetStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterVarSetStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitVarSetStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitVarSetStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UsingStatContext extends StatContext {
		public TerminalNode USING() { return getToken(MineLangParser.USING, 0); }
		public TerminalNode ID() { return getToken(MineLangParser.ID, 0); }
		public TerminalNode IN() { return getToken(MineLangParser.IN, 0); }
		public PkgNameContext pkgName() {
			return getRuleContext(PkgNameContext.class,0);
		}
		public UsingStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterUsingStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitUsingStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitUsingStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStatContext extends StatContext {
		public TerminalNode BREAK() { return getToken(MineLangParser.BREAK, 0); }
		public BreakStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitBreakStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitBreakStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stat);
		int _la;
		try {
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new FuncCallStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				expr(0);
				setState(72);
				callArgs();
				}
				break;
			case 2:
				_localctx = new FuncDeclareStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(FUNC);
				setState(75);
				match(ID);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LB) {
					{
					{
					setState(76);
					funcArgs();
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(82);
				block();
				}
				break;
			case 3:
				_localctx = new ReturnStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				match(RETURN);
				setState(84);
				expr(0);
				}
				break;
			case 4:
				_localctx = new UsingStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				match(USING);
				setState(86);
				match(ID);
				setState(87);
				match(IN);
				setState(88);
				pkgName();
				}
				break;
			case 5:
				_localctx = new VarSetStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(89);
				match(ID);
				setState(90);
				match(SET);
				setState(91);
				expr(0);
				}
				break;
			case 6:
				_localctx = new IfelseStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(92);
				match(IF);
				setState(93);
				match(LB);
				setState(94);
				expr(0);
				setState(95);
				match(RB);
				setState(96);
				block();
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ELIF) {
					{
					{
					setState(97);
					match(ELIF);
					setState(98);
					match(LB);
					setState(99);
					expr(0);
					setState(100);
					match(RB);
					setState(101);
					block();
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(108);
					match(ELSE);
					setState(109);
					block();
					}
				}

				}
				break;
			case 7:
				_localctx = new LoopStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(112);
				match(LOOP);
				setState(113);
				block();
				}
				break;
			case 8:
				_localctx = new ContinueStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(114);
				match(CONTINUE);
				}
				break;
			case 9:
				_localctx = new BreakStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(115);
				match(BREAK);
				}
				break;
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
	public static class PowerExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode POWER() { return getToken(MineLangParser.POWER, 0); }
		public PowerExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterPowerExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitPowerExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitPowerExpr(this);
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
	public static class MutiplyDevideExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUTIPLY() { return getToken(MineLangParser.MUTIPLY, 0); }
		public TerminalNode DEVIDE() { return getToken(MineLangParser.DEVIDE, 0); }
		public MutiplyDevideExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).enterMutiplyDevideExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MineLangListener ) ((MineLangListener)listener).exitMutiplyDevideExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineLangVisitor ) return ((MineLangVisitor<? extends T>)visitor).visitMutiplyDevideExpr(this);
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
		public TerminalNode REAL() { return getToken(MineLangParser.REAL, 0); }
		public TerminalNode STRING() { return getToken(MineLangParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(MineLangParser.BOOL, 0); }
		public TerminalNode NONE() { return getToken(MineLangParser.NONE, 0); }
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case INT:
			case REAL:
			case BOOL:
			case NONE:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(119);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << INT) | (1L << REAL) | (1L << BOOL) | (1L << NONE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case ID:
				{
				_localctx = new VarUseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(145);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(123);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(124);
						match(POWER);
						setState(125);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new MutiplyDevideExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(126);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(127);
						_la = _input.LA(1);
						if ( !(_la==MUTIPLY || _la==DEVIDE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(128);
						expr(5);
						}
						break;
					case 3:
						{
						_localctx = new PlusMinusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(129);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(130);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(131);
						expr(4);
						}
						break;
					case 4:
						{
						_localctx = new IsEqExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(132);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(133);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(134);
						expr(3);
						}
						break;
					case 5:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(136);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GTR) | (1L << GTREQ) | (1L << LWR) | (1L << LWREQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(137);
						expr(2);
						}
						break;
					case 6:
						{
						_localctx = new GetExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(138);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(139);
						match(DOT);
						setState(140);
						match(ID);
						}
						break;
					case 7:
						{
						_localctx = new FuncCallExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(141);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(142);
						callArgs();
						}
						break;
					case 8:
						{
						_localctx = new NotExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(144);
						match(NOT);
						}
						break;
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u0099\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\7\2\22\n\2\f\2\16\2"+
		"\25\13\2\3\2\3\2\3\3\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\4\3\4\5\4#"+
		"\n\4\3\4\3\4\7\4\'\n\4\f\4\16\4*\13\4\3\4\5\4-\n\4\3\4\3\4\3\5\3\5\5\5"+
		"\63\n\5\3\5\3\5\7\5\67\n\5\f\5\16\5:\13\5\3\5\5\5=\n\5\3\5\3\5\3\6\3\6"+
		"\7\6C\n\6\f\6\16\6F\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7P\n\7\f\7"+
		"\16\7S\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7j\n\7\f\7\16\7m\13\7\3\7\3\7\5\7q\n\7\3"+
		"\7\3\7\3\7\3\7\5\7w\n\7\3\b\3\b\3\b\5\b|\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0094"+
		"\n\b\f\b\16\b\u0097\13\b\3\b\2\3\16\t\2\4\6\b\n\f\16\2\7\3\2\"&\3\2\32"+
		"\33\3\2\30\31\3\2\25\26\3\2\36!\2\u00ae\2\23\3\2\2\2\4\30\3\2\2\2\6 \3"+
		"\2\2\2\b\60\3\2\2\2\n@\3\2\2\2\fv\3\2\2\2\16{\3\2\2\2\20\22\5\f\7\2\21"+
		"\20\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\26\3\2\2\2\25"+
		"\23\3\2\2\2\26\27\7\2\2\3\27\3\3\2\2\2\30\35\7\'\2\2\31\32\7\24\2\2\32"+
		"\34\7\'\2\2\33\31\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36"+
		"\5\3\2\2\2\37\35\3\2\2\2 \"\7\16\2\2!#\7\'\2\2\"!\3\2\2\2\"#\3\2\2\2#"+
		"(\3\2\2\2$%\7\r\2\2%\'\7\'\2\2&$\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2"+
		"\2),\3\2\2\2*(\3\2\2\2+-\7\r\2\2,+\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\7\17"+
		"\2\2/\7\3\2\2\2\60\62\7\16\2\2\61\63\5\16\b\2\62\61\3\2\2\2\62\63\3\2"+
		"\2\2\638\3\2\2\2\64\65\7\r\2\2\65\67\5\16\b\2\66\64\3\2\2\2\67:\3\2\2"+
		"\28\66\3\2\2\289\3\2\2\29<\3\2\2\2:8\3\2\2\2;=\7\r\2\2<;\3\2\2\2<=\3\2"+
		"\2\2=>\3\2\2\2>?\7\17\2\2?\t\3\2\2\2@D\7\22\2\2AC\5\f\7\2BA\3\2\2\2CF"+
		"\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\23\2\2H\13\3\2\2"+
		"\2IJ\5\16\b\2JK\5\b\5\2Kw\3\2\2\2LM\7\3\2\2MQ\7\'\2\2NP\5\6\4\2ON\3\2"+
		"\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2Tw\5\n\6\2UV\7\4"+
		"\2\2Vw\5\16\b\2WX\7\5\2\2XY\7\'\2\2YZ\7\6\2\2Zw\5\4\3\2[\\\7\'\2\2\\]"+
		"\7\27\2\2]w\5\16\b\2^_\7\7\2\2_`\7\16\2\2`a\5\16\b\2ab\7\17\2\2bk\5\n"+
		"\6\2cd\7\b\2\2de\7\16\2\2ef\5\16\b\2fg\7\17\2\2gh\5\n\6\2hj\3\2\2\2ic"+
		"\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2lp\3\2\2\2mk\3\2\2\2no\7\t\2\2o"+
		"q\5\n\6\2pn\3\2\2\2pq\3\2\2\2qw\3\2\2\2rs\7\n\2\2sw\5\n\6\2tw\7\f\2\2"+
		"uw\7\13\2\2vI\3\2\2\2vL\3\2\2\2vU\3\2\2\2vW\3\2\2\2v[\3\2\2\2v^\3\2\2"+
		"\2vr\3\2\2\2vt\3\2\2\2vu\3\2\2\2w\r\3\2\2\2xy\b\b\1\2y|\t\2\2\2z|\7\'"+
		"\2\2{x\3\2\2\2{z\3\2\2\2|\u0095\3\2\2\2}~\f\7\2\2~\177\7\34\2\2\177\u0094"+
		"\5\16\b\7\u0080\u0081\f\6\2\2\u0081\u0082\t\3\2\2\u0082\u0094\5\16\b\7"+
		"\u0083\u0084\f\5\2\2\u0084\u0085\t\4\2\2\u0085\u0094\5\16\b\6\u0086\u0087"+
		"\f\4\2\2\u0087\u0088\t\5\2\2\u0088\u0094\5\16\b\5\u0089\u008a\f\3\2\2"+
		"\u008a\u008b\t\6\2\2\u008b\u0094\5\16\b\4\u008c\u008d\f\n\2\2\u008d\u008e"+
		"\7\24\2\2\u008e\u0094\7\'\2\2\u008f\u0090\f\t\2\2\u0090\u0094\5\b\5\2"+
		"\u0091\u0092\f\b\2\2\u0092\u0094\7\35\2\2\u0093}\3\2\2\2\u0093\u0080\3"+
		"\2\2\2\u0093\u0083\3\2\2\2\u0093\u0086\3\2\2\2\u0093\u0089\3\2\2\2\u0093"+
		"\u008c\3\2\2\2\u0093\u008f\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0097\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\17\3\2\2\2\u0097\u0095"+
		"\3\2\2\2\22\23\35\"(,\628<DQkpv{\u0093\u0095";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}