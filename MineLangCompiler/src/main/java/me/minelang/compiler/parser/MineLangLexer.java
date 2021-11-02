// Generated from D:/MineLang/MineLangCompiler/src/main/antlr\MineLang.g4 by ANTLR 4.9.1
package me.minelang.compiler.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MineLangLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FUNC", "RETURN", "USING", "IN", "IF", "ELIF", "ELSE", "LOOP", "BREAK", 
			"CONTINUE", "GLOBAL", "COMMA", "SEMICOLON", "LB", "RB", "LA", "RA", "START", 
			"END", "DOT", "EQ", "NEQ", "SET", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", 
			"REMAIN", "NOT", "AND", "OR", "GTR", "GTREQ", "LWR", "LWREQ", "STRCHAR", 
			"INTEGER", "ESCAPECHAR", "STRING", "INT", "DEC", "BOOL", "NONE", "NAN", 
			"IDStart", "IDPart", "ID", "WS", "COMMENT", "MUTICOMMENT"
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


	public MineLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MineLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u014c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u008a\n"+
		"\7\f\7\16\7\u008d\13\7\3\7\3\7\5\7\u0091\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\6\16\u00b6\n\16"+
		"\r\16\16\16\u00b7\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3"+
		"\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3"+
		"!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%\5%\u00ed\n%\3&\6&\u00f0\n&\r&\16"+
		"&\u00f1\3\'\3\'\3\'\3(\3(\3(\7(\u00fa\n(\f(\16(\u00fd\13(\3(\3(\3(\3("+
		"\7(\u0103\n(\f(\16(\u0106\13(\3(\5(\u0109\n(\3)\3)\3*\3*\3*\3*\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\5+\u011a\n+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3/\3"+
		"/\3\60\3\60\7\60\u012b\n\60\f\60\16\60\u012e\13\60\3\61\3\61\3\61\3\61"+
		"\3\62\3\62\3\62\3\62\7\62\u0138\n\62\f\62\16\62\u013b\13\62\3\62\3\62"+
		"\3\63\3\63\3\63\3\63\7\63\u0143\n\63\f\63\16\63\u0146\13\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\u0144\2\64\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I\2K\2M\2O&Q\'S(U)W*Y+[\2]\2"+
		"_,a-c.e/\3\2\n\3\2$$\3\2\62;\4\2$$^^\4\2))^^\26\2\f\f\17\17\"%\'B]`bb"+
		"}\u0080\u00b9\u00b9\u201a\u201b\u201e\u201f\u2028\u2028\u3003\u3004\u300c"+
		"\u300d\u3012\u3013\uff03\uff03\uff0a\uff0b\uff0e\uff0e\uff1c\uff1d\uff21"+
		"\uff21\uffe7\uffe7\27\2\f\f\17\17\"%\'\61<B]`bb}\u0080\u00b9\u00b9\u201a"+
		"\u201b\u201e\u201f\u2028\u2028\u3003\u3004\u300c\u300d\u3012\u3013\uff03"+
		"\uff03\uff0a\uff0b\uff0e\uff0e\uff1c\uff1d\uff21\uff21\uffe7\uffe7\5\2"+
		"\13\f\17\17\"\"\3\2\f\f\2\u0154\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2"+
		"\2\2\3g\3\2\2\2\5l\3\2\2\2\7s\3\2\2\2\ty\3\2\2\2\13|\3\2\2\2\r\u0090\3"+
		"\2\2\2\17\u0092\3\2\2\2\21\u0097\3\2\2\2\23\u009c\3\2\2\2\25\u00a2\3\2"+
		"\2\2\27\u00ab\3\2\2\2\31\u00b2\3\2\2\2\33\u00b5\3\2\2\2\35\u00b9\3\2\2"+
		"\2\37\u00bb\3\2\2\2!\u00bd\3\2\2\2#\u00bf\3\2\2\2%\u00c1\3\2\2\2\'\u00c3"+
		"\3\2\2\2)\u00c5\3\2\2\2+\u00c7\3\2\2\2-\u00ca\3\2\2\2/\u00cd\3\2\2\2\61"+
		"\u00cf\3\2\2\2\63\u00d1\3\2\2\2\65\u00d3\3\2\2\2\67\u00d5\3\2\2\29\u00d7"+
		"\3\2\2\2;\u00d9\3\2\2\2=\u00db\3\2\2\2?\u00dd\3\2\2\2A\u00df\3\2\2\2C"+
		"\u00e1\3\2\2\2E\u00e4\3\2\2\2G\u00e6\3\2\2\2I\u00ec\3\2\2\2K\u00ef\3\2"+
		"\2\2M\u00f3\3\2\2\2O\u0108\3\2\2\2Q\u010a\3\2\2\2S\u010c\3\2\2\2U\u0119"+
		"\3\2\2\2W\u011b\3\2\2\2Y\u0120\3\2\2\2[\u0124\3\2\2\2]\u0126\3\2\2\2_"+
		"\u0128\3\2\2\2a\u012f\3\2\2\2c\u0133\3\2\2\2e\u013e\3\2\2\2gh\7h\2\2h"+
		"i\7w\2\2ij\7p\2\2jk\7e\2\2k\4\3\2\2\2lm\7t\2\2mn\7g\2\2no\7v\2\2op\7w"+
		"\2\2pq\7t\2\2qr\7p\2\2r\6\3\2\2\2st\7w\2\2tu\7u\2\2uv\7k\2\2vw\7p\2\2"+
		"wx\7i\2\2x\b\3\2\2\2yz\7k\2\2z{\7p\2\2{\n\3\2\2\2|}\7k\2\2}~\7h\2\2~\f"+
		"\3\2\2\2\177\u0080\7g\2\2\u0080\u0081\7n\2\2\u0081\u0082\7k\2\2\u0082"+
		"\u0091\7h\2\2\u0083\u0084\7g\2\2\u0084\u0085\7n\2\2\u0085\u0086\7u\2\2"+
		"\u0086\u0087\7g\2\2\u0087\u008b\3\2\2\2\u0088\u008a\7\"\2\2\u0089\u0088"+
		"\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\7k\2\2\u008f\u0091\7h\2"+
		"\2\u0090\177\3\2\2\2\u0090\u0083\3\2\2\2\u0091\16\3\2\2\2\u0092\u0093"+
		"\7g\2\2\u0093\u0094\7n\2\2\u0094\u0095\7u\2\2\u0095\u0096\7g\2\2\u0096"+
		"\20\3\2\2\2\u0097\u0098\7n\2\2\u0098\u0099\7q\2\2\u0099\u009a\7q\2\2\u009a"+
		"\u009b\7r\2\2\u009b\22\3\2\2\2\u009c\u009d\7d\2\2\u009d\u009e\7t\2\2\u009e"+
		"\u009f\7g\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7m\2\2\u00a1\24\3\2\2\2\u00a2"+
		"\u00a3\7e\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7v\2\2"+
		"\u00a6\u00a7\7k\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7w\2\2\u00a9\u00aa"+
		"\7g\2\2\u00aa\26\3\2\2\2\u00ab\u00ac\7i\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae"+
		"\7q\2\2\u00ae\u00af\7d\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7n\2\2\u00b1"+
		"\30\3\2\2\2\u00b2\u00b3\7.\2\2\u00b3\32\3\2\2\2\u00b4\u00b6\7=\2\2\u00b5"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2"+
		"\2\2\u00b8\34\3\2\2\2\u00b9\u00ba\7*\2\2\u00ba\36\3\2\2\2\u00bb\u00bc"+
		"\7+\2\2\u00bc \3\2\2\2\u00bd\u00be\7]\2\2\u00be\"\3\2\2\2\u00bf\u00c0"+
		"\7_\2\2\u00c0$\3\2\2\2\u00c1\u00c2\7}\2\2\u00c2&\3\2\2\2\u00c3\u00c4\7"+
		"\177\2\2\u00c4(\3\2\2\2\u00c5\u00c6\7\60\2\2\u00c6*\3\2\2\2\u00c7\u00c8"+
		"\7?\2\2\u00c8\u00c9\7?\2\2\u00c9,\3\2\2\2\u00ca\u00cb\7#\2\2\u00cb\u00cc"+
		"\7?\2\2\u00cc.\3\2\2\2\u00cd\u00ce\7?\2\2\u00ce\60\3\2\2\2\u00cf\u00d0"+
		"\7-\2\2\u00d0\62\3\2\2\2\u00d1\u00d2\7/\2\2\u00d2\64\3\2\2\2\u00d3\u00d4"+
		"\7,\2\2\u00d4\66\3\2\2\2\u00d5\u00d6\7\61\2\2\u00d68\3\2\2\2\u00d7\u00d8"+
		"\7\'\2\2\u00d8:\3\2\2\2\u00d9\u00da\7#\2\2\u00da<\3\2\2\2\u00db\u00dc"+
		"\7(\2\2\u00dc>\3\2\2\2\u00dd\u00de\7~\2\2\u00de@\3\2\2\2\u00df\u00e0\7"+
		"@\2\2\u00e0B\3\2\2\2\u00e1\u00e2\7@\2\2\u00e2\u00e3\7?\2\2\u00e3D\3\2"+
		"\2\2\u00e4\u00e5\7>\2\2\u00e5F\3\2\2\2\u00e6\u00e7\7>\2\2\u00e7\u00e8"+
		"\7?\2\2\u00e8H\3\2\2\2\u00e9\u00ed\n\2\2\2\u00ea\u00eb\7^\2\2\u00eb\u00ed"+
		"\7$\2\2\u00ec\u00e9\3\2\2\2\u00ec\u00ea\3\2\2\2\u00edJ\3\2\2\2\u00ee\u00f0"+
		"\t\3\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2L\3\2\2\2\u00f3\u00f4\7^\2\2\u00f4\u00f5\13\2\2\2"+
		"\u00f5N\3\2\2\2\u00f6\u00fb\7$\2\2\u00f7\u00fa\5M\'\2\u00f8\u00fa\n\4"+
		"\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2"+
		"\2\2\u00fe\u0109\7$\2\2\u00ff\u0104\7)\2\2\u0100\u0103\5M\'\2\u0101\u0103"+
		"\n\5\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2"+
		"\2\2\u0107\u0109\7)\2\2\u0108\u00f6\3\2\2\2\u0108\u00ff\3\2\2\2\u0109"+
		"P\3\2\2\2\u010a\u010b\5K&\2\u010bR\3\2\2\2\u010c\u010d\5K&\2\u010d\u010e"+
		"\7\60\2\2\u010e\u010f\5K&\2\u010fT\3\2\2\2\u0110\u0111\7v\2\2\u0111\u0112"+
		"\7t\2\2\u0112\u0113\7w\2\2\u0113\u011a\7g\2\2\u0114\u0115\7h\2\2\u0115"+
		"\u0116\7c\2\2\u0116\u0117\7n\2\2\u0117\u0118\7u\2\2\u0118\u011a\7g\2\2"+
		"\u0119\u0110\3\2\2\2\u0119\u0114\3\2\2\2\u011aV\3\2\2\2\u011b\u011c\7"+
		"p\2\2\u011c\u011d\7q\2\2\u011d\u011e\7p\2\2\u011e\u011f\7g\2\2\u011fX"+
		"\3\2\2\2\u0120\u0121\7p\2\2\u0121\u0122\7c\2\2\u0122\u0123\7p\2\2\u0123"+
		"Z\3\2\2\2\u0124\u0125\n\6\2\2\u0125\\\3\2\2\2\u0126\u0127\n\7\2\2\u0127"+
		"^\3\2\2\2\u0128\u012c\5[.\2\u0129\u012b\5]/\2\u012a\u0129\3\2\2\2\u012b"+
		"\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d`\3\2\2\2"+
		"\u012e\u012c\3\2\2\2\u012f\u0130\t\b\2\2\u0130\u0131\3\2\2\2\u0131\u0132"+
		"\b\61\2\2\u0132b\3\2\2\2\u0133\u0134\7\61\2\2\u0134\u0135\7\61\2\2\u0135"+
		"\u0139\3\2\2\2\u0136\u0138\n\t\2\2\u0137\u0136\3\2\2\2\u0138\u013b\3\2"+
		"\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013c\u013d\b\62\2\2\u013dd\3\2\2\2\u013e\u013f\7\61\2"+
		"\2\u013f\u0140\7,\2\2\u0140\u0144\3\2\2\2\u0141\u0143\13\2\2\2\u0142\u0141"+
		"\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145"+
		"\u0147\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\7,\2\2\u0148\u0149\7\61"+
		"\2\2\u0149\u014a\3\2\2\2\u014a\u014b\b\63\2\2\u014bf\3\2\2\2\21\2\u008b"+
		"\u0090\u00b7\u00ec\u00f1\u00f9\u00fb\u0102\u0104\u0108\u0119\u012c\u0139"+
		"\u0144\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}