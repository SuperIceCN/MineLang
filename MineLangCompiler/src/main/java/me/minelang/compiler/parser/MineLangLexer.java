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
		CONTINUE=10, GLOBAL=11, COMMA=12, LB=13, RB=14, LA=15, RA=16, START=17, 
		END=18, DOT=19, EQ=20, NEQ=21, SET=22, PLUS=23, MINUS=24, MULTIPLY=25, 
		DIVIDE=26, REMAIN=27, NOT=28, AND=29, OR=30, GTR=31, GTREQ=32, LWR=33, 
		LWREQ=34, STRING=35, INT=36, DEC=37, BOOL=38, NONE=39, NAN=40, ID=41, 
		WS=42, COMMENT=43, MUTICOMMENT=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FUNC", "RETURN", "USING", "IN", "IF", "ELIF", "ELSE", "LOOP", "BREAK", 
			"CONTINUE", "GLOBAL", "COMMA", "LB", "RB", "LA", "RA", "START", "END", 
			"DOT", "EQ", "NEQ", "SET", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "REMAIN", 
			"NOT", "AND", "OR", "GTR", "GTREQ", "LWR", "LWREQ", "STRCHAR", "INTEGER", 
			"ESCAPECHAR", "STRING", "INT", "DEC", "BOOL", "NONE", "NAN", "IDStart", 
			"IDPart", "ID", "WS", "COMMENT", "MUTICOMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'return'", "'using'", "'in'", "'if'", null, "'else'", 
			"'loop'", "'break'", "'continue'", "'global'", "','", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'.'", "'=='", "'!='", "'='", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'!'", "'&'", "'|'", "'>'", "'>='", "'<'", "'<='", null, 
			null, null, null, "'none'", "'nan'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUNC", "RETURN", "USING", "IN", "IF", "ELIF", "ELSE", "LOOP", 
			"BREAK", "CONTINUE", "GLOBAL", "COMMA", "LB", "RB", "LA", "RA", "START", 
			"END", "DOT", "EQ", "NEQ", "SET", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", 
			"REMAIN", "NOT", "AND", "OR", "GTR", "GTREQ", "LWR", "LWREQ", "STRING", 
			"INT", "DEC", "BOOL", "NONE", "NAN", "ID", "WS", "COMMENT", "MUTICOMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0145\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0088\n\7\f\7\16"+
		"\7\u008b\13\7\3\7\3\7\5\7\u008f\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\5$\u00e6"+
		"\n$\3%\6%\u00e9\n%\r%\16%\u00ea\3&\3&\3&\3\'\3\'\3\'\7\'\u00f3\n\'\f\'"+
		"\16\'\u00f6\13\'\3\'\3\'\3\'\3\'\7\'\u00fc\n\'\f\'\16\'\u00ff\13\'\3\'"+
		"\5\'\u0102\n\'\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u0113\n"+
		"*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3.\3.\3/\3/\7/\u0124\n/\f/\16/\u0127"+
		"\13/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u0131\n\61\f\61\16\61"+
		"\u0134\13\61\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u013c\n\62\f\62\16\62"+
		"\u013f\13\62\3\62\3\62\3\62\3\62\3\62\3\u013d\2\63\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G\2I\2K"+
		"\2M%O&Q\'S(U)W*Y\2[\2]+_,a-c.\3\2\n\3\2$$\3\2\62;\4\2$$^^\4\2))^^\26\2"+
		"\f\f\17\17\"%\'B]`bb}\u0080\u00b9\u00b9\u201a\u201b\u201e\u201f\u2028"+
		"\u2028\u3003\u3004\u300c\u300d\u3012\u3013\uff03\uff03\uff0a\uff0b\uff0e"+
		"\uff0e\uff1c\uff1d\uff21\uff21\uffe7\uffe7\27\2\f\f\17\17\"%\'\61<B]`"+
		"bb}\u0080\u00b9\u00b9\u201a\u201b\u201e\u201f\u2028\u2028\u3003\u3004"+
		"\u300c\u300d\u3012\u3013\uff03\uff03\uff0a\uff0b\uff0e\uff0e\uff1c\uff1d"+
		"\uff21\uff21\uffe7\uffe7\5\2\13\f\17\17\"\"\3\2\f\f\2\u014c\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2M\3\2\2\2\2O\3\2\2"+
		"\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2"+
		"a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5j\3\2\2\2\7q\3\2\2\2\tw\3\2\2\2\13z\3"+
		"\2\2\2\r\u008e\3\2\2\2\17\u0090\3\2\2\2\21\u0095\3\2\2\2\23\u009a\3\2"+
		"\2\2\25\u00a0\3\2\2\2\27\u00a9\3\2\2\2\31\u00b0\3\2\2\2\33\u00b2\3\2\2"+
		"\2\35\u00b4\3\2\2\2\37\u00b6\3\2\2\2!\u00b8\3\2\2\2#\u00ba\3\2\2\2%\u00bc"+
		"\3\2\2\2\'\u00be\3\2\2\2)\u00c0\3\2\2\2+\u00c3\3\2\2\2-\u00c6\3\2\2\2"+
		"/\u00c8\3\2\2\2\61\u00ca\3\2\2\2\63\u00cc\3\2\2\2\65\u00ce\3\2\2\2\67"+
		"\u00d0\3\2\2\29\u00d2\3\2\2\2;\u00d4\3\2\2\2=\u00d6\3\2\2\2?\u00d8\3\2"+
		"\2\2A\u00da\3\2\2\2C\u00dd\3\2\2\2E\u00df\3\2\2\2G\u00e5\3\2\2\2I\u00e8"+
		"\3\2\2\2K\u00ec\3\2\2\2M\u0101\3\2\2\2O\u0103\3\2\2\2Q\u0105\3\2\2\2S"+
		"\u0112\3\2\2\2U\u0114\3\2\2\2W\u0119\3\2\2\2Y\u011d\3\2\2\2[\u011f\3\2"+
		"\2\2]\u0121\3\2\2\2_\u0128\3\2\2\2a\u012c\3\2\2\2c\u0137\3\2\2\2ef\7h"+
		"\2\2fg\7w\2\2gh\7p\2\2hi\7e\2\2i\4\3\2\2\2jk\7t\2\2kl\7g\2\2lm\7v\2\2"+
		"mn\7w\2\2no\7t\2\2op\7p\2\2p\6\3\2\2\2qr\7w\2\2rs\7u\2\2st\7k\2\2tu\7"+
		"p\2\2uv\7i\2\2v\b\3\2\2\2wx\7k\2\2xy\7p\2\2y\n\3\2\2\2z{\7k\2\2{|\7h\2"+
		"\2|\f\3\2\2\2}~\7g\2\2~\177\7n\2\2\177\u0080\7k\2\2\u0080\u008f\7h\2\2"+
		"\u0081\u0082\7g\2\2\u0082\u0083\7n\2\2\u0083\u0084\7u\2\2\u0084\u0085"+
		"\7g\2\2\u0085\u0089\3\2\2\2\u0086\u0088\7\"\2\2\u0087\u0086\3\2\2\2\u0088"+
		"\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2"+
		"\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7k\2\2\u008d\u008f\7h\2\2\u008e}"+
		"\3\2\2\2\u008e\u0081\3\2\2\2\u008f\16\3\2\2\2\u0090\u0091\7g\2\2\u0091"+
		"\u0092\7n\2\2\u0092\u0093\7u\2\2\u0093\u0094\7g\2\2\u0094\20\3\2\2\2\u0095"+
		"\u0096\7n\2\2\u0096\u0097\7q\2\2\u0097\u0098\7q\2\2\u0098\u0099\7r\2\2"+
		"\u0099\22\3\2\2\2\u009a\u009b\7d\2\2\u009b\u009c\7t\2\2\u009c\u009d\7"+
		"g\2\2\u009d\u009e\7c\2\2\u009e\u009f\7m\2\2\u009f\24\3\2\2\2\u00a0\u00a1"+
		"\7e\2\2\u00a1\u00a2\7q\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7v\2\2\u00a4"+
		"\u00a5\7k\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7w\2\2\u00a7\u00a8\7g\2\2"+
		"\u00a8\26\3\2\2\2\u00a9\u00aa\7i\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7"+
		"q\2\2\u00ac\u00ad\7d\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af\7n\2\2\u00af\30"+
		"\3\2\2\2\u00b0\u00b1\7.\2\2\u00b1\32\3\2\2\2\u00b2\u00b3\7*\2\2\u00b3"+
		"\34\3\2\2\2\u00b4\u00b5\7+\2\2\u00b5\36\3\2\2\2\u00b6\u00b7\7]\2\2\u00b7"+
		" \3\2\2\2\u00b8\u00b9\7_\2\2\u00b9\"\3\2\2\2\u00ba\u00bb\7}\2\2\u00bb"+
		"$\3\2\2\2\u00bc\u00bd\7\177\2\2\u00bd&\3\2\2\2\u00be\u00bf\7\60\2\2\u00bf"+
		"(\3\2\2\2\u00c0\u00c1\7?\2\2\u00c1\u00c2\7?\2\2\u00c2*\3\2\2\2\u00c3\u00c4"+
		"\7#\2\2\u00c4\u00c5\7?\2\2\u00c5,\3\2\2\2\u00c6\u00c7\7?\2\2\u00c7.\3"+
		"\2\2\2\u00c8\u00c9\7-\2\2\u00c9\60\3\2\2\2\u00ca\u00cb\7/\2\2\u00cb\62"+
		"\3\2\2\2\u00cc\u00cd\7,\2\2\u00cd\64\3\2\2\2\u00ce\u00cf\7\61\2\2\u00cf"+
		"\66\3\2\2\2\u00d0\u00d1\7\'\2\2\u00d18\3\2\2\2\u00d2\u00d3\7#\2\2\u00d3"+
		":\3\2\2\2\u00d4\u00d5\7(\2\2\u00d5<\3\2\2\2\u00d6\u00d7\7~\2\2\u00d7>"+
		"\3\2\2\2\u00d8\u00d9\7@\2\2\u00d9@\3\2\2\2\u00da\u00db\7@\2\2\u00db\u00dc"+
		"\7?\2\2\u00dcB\3\2\2\2\u00dd\u00de\7>\2\2\u00deD\3\2\2\2\u00df\u00e0\7"+
		">\2\2\u00e0\u00e1\7?\2\2\u00e1F\3\2\2\2\u00e2\u00e6\n\2\2\2\u00e3\u00e4"+
		"\7^\2\2\u00e4\u00e6\7$\2\2\u00e5\u00e2\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"H\3\2\2\2\u00e7\u00e9\t\3\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2"+
		"\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00ebJ\3\2\2\2\u00ec\u00ed\7"+
		"^\2\2\u00ed\u00ee\13\2\2\2\u00eeL\3\2\2\2\u00ef\u00f4\7$\2\2\u00f0\u00f3"+
		"\5K&\2\u00f1\u00f3\n\4\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3"+
		"\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2"+
		"\2\2\u00f6\u00f4\3\2\2\2\u00f7\u0102\7$\2\2\u00f8\u00fd\7)\2\2\u00f9\u00fc"+
		"\5K&\2\u00fa\u00fc\n\5\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc"+
		"\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\3\2"+
		"\2\2\u00ff\u00fd\3\2\2\2\u0100\u0102\7)\2\2\u0101\u00ef\3\2\2\2\u0101"+
		"\u00f8\3\2\2\2\u0102N\3\2\2\2\u0103\u0104\5I%\2\u0104P\3\2\2\2\u0105\u0106"+
		"\5I%\2\u0106\u0107\7\60\2\2\u0107\u0108\5I%\2\u0108R\3\2\2\2\u0109\u010a"+
		"\7v\2\2\u010a\u010b\7t\2\2\u010b\u010c\7w\2\2\u010c\u0113\7g\2\2\u010d"+
		"\u010e\7h\2\2\u010e\u010f\7c\2\2\u010f\u0110\7n\2\2\u0110\u0111\7u\2\2"+
		"\u0111\u0113\7g\2\2\u0112\u0109\3\2\2\2\u0112\u010d\3\2\2\2\u0113T\3\2"+
		"\2\2\u0114\u0115\7p\2\2\u0115\u0116\7q\2\2\u0116\u0117\7p\2\2\u0117\u0118"+
		"\7g\2\2\u0118V\3\2\2\2\u0119\u011a\7p\2\2\u011a\u011b\7c\2\2\u011b\u011c"+
		"\7p\2\2\u011cX\3\2\2\2\u011d\u011e\n\6\2\2\u011eZ\3\2\2\2\u011f\u0120"+
		"\n\7\2\2\u0120\\\3\2\2\2\u0121\u0125\5Y-\2\u0122\u0124\5[.\2\u0123\u0122"+
		"\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126"+
		"^\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129\t\b\2\2\u0129\u012a\3\2\2\2"+
		"\u012a\u012b\b\60\2\2\u012b`\3\2\2\2\u012c\u012d\7\61\2\2\u012d\u012e"+
		"\7\61\2\2\u012e\u0132\3\2\2\2\u012f\u0131\n\t\2\2\u0130\u012f\3\2\2\2"+
		"\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135"+
		"\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\b\61\2\2\u0136b\3\2\2\2\u0137"+
		"\u0138\7\61\2\2\u0138\u0139\7,\2\2\u0139\u013d\3\2\2\2\u013a\u013c\13"+
		"\2\2\2\u013b\u013a\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013e\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013e\u0140\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141\7,"+
		"\2\2\u0141\u0142\7\61\2\2\u0142\u0143\3\2\2\2\u0143\u0144\b\62\2\2\u0144"+
		"d\3\2\2\2\20\2\u0089\u008e\u00e5\u00ea\u00f2\u00f4\u00fb\u00fd\u0101\u0112"+
		"\u0125\u0132\u013d\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}