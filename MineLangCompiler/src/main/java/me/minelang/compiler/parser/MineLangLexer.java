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
		WS=1, COMMENT=2, MUTICOMMENT=3, FUNC=4, RETURN=5, USING=6, IN=7, IF=8, 
		ELIF=9, ELSE=10, LOOP=11, BREAK=12, CONTINUE=13, GLOBAL=14, COMMA=15, 
		SEMICOLON=16, LB=17, RB=18, LA=19, RA=20, START=21, END=22, DOT=23, EQ=24, 
		NEQ=25, SET=26, PLUS=27, MINUS=28, MULTIPLY=29, DIVIDE=30, REMAIN=31, 
		NOT=32, AND=33, OR=34, GTR=35, GTREQ=36, LWR=37, LWREQ=38, STRING=39, 
		INT=40, DEC=41, BOOL=42, NONE=43, NAN=44, ID=45;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "COMMENT", "MUTICOMMENT", "FUNC", "RETURN", "USING", "IN", "IF", 
			"ELIF", "ELSE", "LOOP", "BREAK", "CONTINUE", "GLOBAL", "COMMA", "SEMICOLON", 
			"LB", "RB", "LA", "RA", "START", "END", "DOT", "EQ", "NEQ", "SET", "PLUS", 
			"MINUS", "MULTIPLY", "DIVIDE", "REMAIN", "NOT", "AND", "OR", "GTR", "GTREQ", 
			"LWR", "LWREQ", "STRCHAR", "INTEGER", "ESCAPECHAR", "STRING", "INT", 
			"DEC", "BOOL", "NONE", "NAN", "IDStart", "IDPart", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'func'", "'return'", "'using'", "'in'", "'if'", 
			null, "'else'", "'loop'", "'break'", "'continue'", "'global'", "','", 
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'.'", "'=='", "'!='", 
			"'='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'&'", "'|'", "'>'", 
			"'>='", "'<'", "'<='", null, null, null, null, "'none'", "'nan'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "COMMENT", "MUTICOMMENT", "FUNC", "RETURN", "USING", "IN", 
			"IF", "ELIF", "ELSE", "LOOP", "BREAK", "CONTINUE", "GLOBAL", "COMMA", 
			"SEMICOLON", "LB", "RB", "LA", "RA", "START", "END", "DOT", "EQ", "NEQ", 
			"SET", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "REMAIN", "NOT", "AND", 
			"OR", "GTR", "GTREQ", "LWR", "LWREQ", "STRING", "INT", "DEC", "BOOL", 
			"NONE", "NAN", "ID"
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
		"\3\2\3\2\3\3\3\3\3\3\3\3\7\3p\n\3\f\3\16\3s\13\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\7\4{\n\4\f\4\16\4~\13\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00a7\n\n\f\n\16\n\u00aa"+
		"\13\n\3\n\3\n\5\n\u00ae\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\6\21\u00d3\n\21\r\21"+
		"\16\21\u00d4\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3"+
		"\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3"+
		"&\3\'\3\'\3\'\3(\3(\3(\5(\u010a\n(\3)\6)\u010d\n)\r)\16)\u010e\3*\3*\3"+
		"*\3+\3+\3+\7+\u0117\n+\f+\16+\u011a\13+\3+\3+\3+\3+\7+\u0120\n+\f+\16"+
		"+\u0123\13+\3+\5+\u0126\n+\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\5.\u0137\n.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3"+
		"\63\3\63\7\63\u0148\n\63\f\63\16\63\u014b\13\63\3|\2\64\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O\2Q\2S\2U)W*Y+[,]-_.a\2c\2e/\3\2\n\5\2\13\f\17\17\"\"\3\2\f\f"+
		"\3\2$$\3\2\62;\4\2$$^^\4\2))^^\26\2\13\f\17\17\"%\'B]`bb}\u0080\u00b9"+
		"\u00b9\u201a\u201b\u201e\u201f\u2028\u2028\u3003\u3004\u300c\u300d\u3012"+
		"\u3013\uff03\uff03\uff0a\uff0b\uff0e\uff0e\uff1c\uff1d\uff21\uff21\uffe7"+
		"\uffe7\27\2\13\f\17\17\"%\'\61<B]`bb}\u0080\u00b9\u00b9\u201a\u201b\u201e"+
		"\u201f\u2028\u2028\u3003\u3004\u300c\u300d\u3012\u3013\uff03\uff03\uff0a"+
		"\uff0b\uff0e\uff0e\uff1c\uff1d\uff21\uff21\uffe7\uffe7\2\u0154\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2e\3\2\2\2\3g\3\2\2\2\5k\3\2\2\2\7v\3\2\2\2\t"+
		"\u0084\3\2\2\2\13\u0089\3\2\2\2\r\u0090\3\2\2\2\17\u0096\3\2\2\2\21\u0099"+
		"\3\2\2\2\23\u00ad\3\2\2\2\25\u00af\3\2\2\2\27\u00b4\3\2\2\2\31\u00b9\3"+
		"\2\2\2\33\u00bf\3\2\2\2\35\u00c8\3\2\2\2\37\u00cf\3\2\2\2!\u00d2\3\2\2"+
		"\2#\u00d6\3\2\2\2%\u00d8\3\2\2\2\'\u00da\3\2\2\2)\u00dc\3\2\2\2+\u00de"+
		"\3\2\2\2-\u00e0\3\2\2\2/\u00e2\3\2\2\2\61\u00e4\3\2\2\2\63\u00e7\3\2\2"+
		"\2\65\u00ea\3\2\2\2\67\u00ec\3\2\2\29\u00ee\3\2\2\2;\u00f0\3\2\2\2=\u00f2"+
		"\3\2\2\2?\u00f4\3\2\2\2A\u00f6\3\2\2\2C\u00f8\3\2\2\2E\u00fa\3\2\2\2G"+
		"\u00fc\3\2\2\2I\u00fe\3\2\2\2K\u0101\3\2\2\2M\u0103\3\2\2\2O\u0109\3\2"+
		"\2\2Q\u010c\3\2\2\2S\u0110\3\2\2\2U\u0125\3\2\2\2W\u0127\3\2\2\2Y\u0129"+
		"\3\2\2\2[\u0136\3\2\2\2]\u0138\3\2\2\2_\u013d\3\2\2\2a\u0141\3\2\2\2c"+
		"\u0143\3\2\2\2e\u0145\3\2\2\2gh\t\2\2\2hi\3\2\2\2ij\b\2\2\2j\4\3\2\2\2"+
		"kl\7\61\2\2lm\7\61\2\2mq\3\2\2\2np\n\3\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2"+
		"\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\b\3\2\2u\6\3\2\2\2vw\7\61\2\2wx\7,"+
		"\2\2x|\3\2\2\2y{\13\2\2\2zy\3\2\2\2{~\3\2\2\2|}\3\2\2\2|z\3\2\2\2}\177"+
		"\3\2\2\2~|\3\2\2\2\177\u0080\7,\2\2\u0080\u0081\7\61\2\2\u0081\u0082\3"+
		"\2\2\2\u0082\u0083\b\4\2\2\u0083\b\3\2\2\2\u0084\u0085\7h\2\2\u0085\u0086"+
		"\7w\2\2\u0086\u0087\7p\2\2\u0087\u0088\7e\2\2\u0088\n\3\2\2\2\u0089\u008a"+
		"\7t\2\2\u008a\u008b\7g\2\2\u008b\u008c\7v\2\2\u008c\u008d\7w\2\2\u008d"+
		"\u008e\7t\2\2\u008e\u008f\7p\2\2\u008f\f\3\2\2\2\u0090\u0091\7w\2\2\u0091"+
		"\u0092\7u\2\2\u0092\u0093\7k\2\2\u0093\u0094\7p\2\2\u0094\u0095\7i\2\2"+
		"\u0095\16\3\2\2\2\u0096\u0097\7k\2\2\u0097\u0098\7p\2\2\u0098\20\3\2\2"+
		"\2\u0099\u009a\7k\2\2\u009a\u009b\7h\2\2\u009b\22\3\2\2\2\u009c\u009d"+
		"\7g\2\2\u009d\u009e\7n\2\2\u009e\u009f\7k\2\2\u009f\u00ae\7h\2\2\u00a0"+
		"\u00a1\7g\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7g\2\2"+
		"\u00a4\u00a8\3\2\2\2\u00a5\u00a7\7\"\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ae\7h\2\2\u00ad\u009c\3\2\2"+
		"\2\u00ad\u00a0\3\2\2\2\u00ae\24\3\2\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1"+
		"\7n\2\2\u00b1\u00b2\7u\2\2\u00b2\u00b3\7g\2\2\u00b3\26\3\2\2\2\u00b4\u00b5"+
		"\7n\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7q\2\2\u00b7\u00b8\7r\2\2\u00b8"+
		"\30\3\2\2\2\u00b9\u00ba\7d\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7g\2\2\u00bc"+
		"\u00bd\7c\2\2\u00bd\u00be\7m\2\2\u00be\32\3\2\2\2\u00bf\u00c0\7e\2\2\u00c0"+
		"\u00c1\7q\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4\7k\2\2"+
		"\u00c4\u00c5\7p\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7\7g\2\2\u00c7\34\3\2"+
		"\2\2\u00c8\u00c9\7i\2\2\u00c9\u00ca\7n\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc"+
		"\7d\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7n\2\2\u00ce\36\3\2\2\2\u00cf\u00d0"+
		"\7.\2\2\u00d0 \3\2\2\2\u00d1\u00d3\7=\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\"\3\2\2\2\u00d6"+
		"\u00d7\7*\2\2\u00d7$\3\2\2\2\u00d8\u00d9\7+\2\2\u00d9&\3\2\2\2\u00da\u00db"+
		"\7]\2\2\u00db(\3\2\2\2\u00dc\u00dd\7_\2\2\u00dd*\3\2\2\2\u00de\u00df\7"+
		"}\2\2\u00df,\3\2\2\2\u00e0\u00e1\7\177\2\2\u00e1.\3\2\2\2\u00e2\u00e3"+
		"\7\60\2\2\u00e3\60\3\2\2\2\u00e4\u00e5\7?\2\2\u00e5\u00e6\7?\2\2\u00e6"+
		"\62\3\2\2\2\u00e7\u00e8\7#\2\2\u00e8\u00e9\7?\2\2\u00e9\64\3\2\2\2\u00ea"+
		"\u00eb\7?\2\2\u00eb\66\3\2\2\2\u00ec\u00ed\7-\2\2\u00ed8\3\2\2\2\u00ee"+
		"\u00ef\7/\2\2\u00ef:\3\2\2\2\u00f0\u00f1\7,\2\2\u00f1<\3\2\2\2\u00f2\u00f3"+
		"\7\61\2\2\u00f3>\3\2\2\2\u00f4\u00f5\7\'\2\2\u00f5@\3\2\2\2\u00f6\u00f7"+
		"\7#\2\2\u00f7B\3\2\2\2\u00f8\u00f9\7(\2\2\u00f9D\3\2\2\2\u00fa\u00fb\7"+
		"~\2\2\u00fbF\3\2\2\2\u00fc\u00fd\7@\2\2\u00fdH\3\2\2\2\u00fe\u00ff\7@"+
		"\2\2\u00ff\u0100\7?\2\2\u0100J\3\2\2\2\u0101\u0102\7>\2\2\u0102L\3\2\2"+
		"\2\u0103\u0104\7>\2\2\u0104\u0105\7?\2\2\u0105N\3\2\2\2\u0106\u010a\n"+
		"\4\2\2\u0107\u0108\7^\2\2\u0108\u010a\7$\2\2\u0109\u0106\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u010aP\3\2\2\2\u010b\u010d\t\5\2\2\u010c\u010b\3\2\2\2"+
		"\u010d\u010e\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010fR\3"+
		"\2\2\2\u0110\u0111\7^\2\2\u0111\u0112\13\2\2\2\u0112T\3\2\2\2\u0113\u0118"+
		"\7$\2\2\u0114\u0117\5S*\2\u0115\u0117\n\6\2\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2"+
		"\2\2\u0119\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u0126\7$\2\2\u011c"+
		"\u0121\7)\2\2\u011d\u0120\5S*\2\u011e\u0120\n\7\2\2\u011f\u011d\3\2\2"+
		"\2\u011f\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122"+
		"\3\2\2\2\u0122\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0126\7)\2\2\u0125"+
		"\u0113\3\2\2\2\u0125\u011c\3\2\2\2\u0126V\3\2\2\2\u0127\u0128\5Q)\2\u0128"+
		"X\3\2\2\2\u0129\u012a\5Q)\2\u012a\u012b\7\60\2\2\u012b\u012c\5Q)\2\u012c"+
		"Z\3\2\2\2\u012d\u012e\7v\2\2\u012e\u012f\7t\2\2\u012f\u0130\7w\2\2\u0130"+
		"\u0137\7g\2\2\u0131\u0132\7h\2\2\u0132\u0133\7c\2\2\u0133\u0134\7n\2\2"+
		"\u0134\u0135\7u\2\2\u0135\u0137\7g\2\2\u0136\u012d\3\2\2\2\u0136\u0131"+
		"\3\2\2\2\u0137\\\3\2\2\2\u0138\u0139\7p\2\2\u0139\u013a\7q\2\2\u013a\u013b"+
		"\7p\2\2\u013b\u013c\7g\2\2\u013c^\3\2\2\2\u013d\u013e\7p\2\2\u013e\u013f"+
		"\7c\2\2\u013f\u0140\7p\2\2\u0140`\3\2\2\2\u0141\u0142\n\b\2\2\u0142b\3"+
		"\2\2\2\u0143\u0144\n\t\2\2\u0144d\3\2\2\2\u0145\u0149\5a\61\2\u0146\u0148"+
		"\5c\62\2\u0147\u0146\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014af\3\2\2\2\u014b\u0149\3\2\2\2\21\2q|\u00a8\u00ad\u00d4"+
		"\u0109\u010e\u0116\u0118\u011f\u0121\u0125\u0136\u0149\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}