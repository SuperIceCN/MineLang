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
		CONTINUE=10, COMMA=11, LB=12, RB=13, LA=14, RA=15, START=16, END=17, DOT=18, 
		EQ=19, NEQ=20, SET=21, PLUS=22, MINUS=23, MULTIPLY=24, DIVIDE=25, REMAIN=26, 
		NOT=27, AND=28, OR=29, GTR=30, GTREQ=31, LWR=32, LWREQ=33, STRING=34, 
		INT=35, DEC=36, BOOL=37, NONE=38, NAN=39, ID=40, WS=41, COMMENT=42, MUTICOMMENT=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FUNC", "RETURN", "USING", "IN", "IF", "ELIF", "ELSE", "LOOP", "BREAK", 
			"CONTINUE", "COMMA", "LB", "RB", "LA", "RA", "START", "END", "DOT", "EQ", 
			"NEQ", "SET", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "REMAIN", "NOT", 
			"AND", "OR", "GTR", "GTREQ", "LWR", "LWREQ", "STRCHAR", "INTEGER", "ESCAPECHAR", 
			"STRING", "INT", "DEC", "BOOL", "NONE", "NAN", "IDStart", "IDPart", "ID", 
			"WS", "COMMENT", "MUTICOMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'return'", "'using'", "'in'", "'if'", null, "'else'", 
			"'loop'", "'break'", "'continue'", "','", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'.'", "'=='", "'!='", "'='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'!'", "'&'", "'|'", "'>'", "'>='", "'<'", "'<='", null, null, 
			null, null, "'none'", "'nan'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUNC", "RETURN", "USING", "IN", "IF", "ELIF", "ELSE", "LOOP", 
			"BREAK", "CONTINUE", "COMMA", "LB", "RB", "LA", "RA", "START", "END", 
			"DOT", "EQ", "NEQ", "SET", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "REMAIN", 
			"NOT", "AND", "OR", "GTR", "GTREQ", "LWR", "LWREQ", "STRING", "INT", 
			"DEC", "BOOL", "NONE", "NAN", "ID", "WS", "COMMENT", "MUTICOMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u013c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0086\n\7\f\7\16\7\u0089\13"+
		"\7\3\7\3\7\5\7\u008d\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 "+
		"\3!\3!\3\"\3\"\3\"\3#\3#\3#\5#\u00dd\n#\3$\6$\u00e0\n$\r$\16$\u00e1\3"+
		"%\3%\3%\3&\3&\3&\7&\u00ea\n&\f&\16&\u00ed\13&\3&\3&\3&\3&\7&\u00f3\n&"+
		"\f&\16&\u00f6\13&\3&\5&\u00f9\n&\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\5)\u010a\n)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3-\3-\3.\3.\7"+
		".\u011b\n.\f.\16.\u011e\13.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\7\60\u0128"+
		"\n\60\f\60\16\60\u012b\13\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u0133"+
		"\n\61\f\61\16\61\u0136\13\61\3\61\3\61\3\61\3\61\3\61\3\u0134\2\62\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E\2G\2I\2K$M%O&Q\'S(U)W\2Y\2[*]+_,a-\3\2\n\3\2$$\3\2\62;\4\2$$^^"+
		"\4\2))^^\26\2\f\f\17\17\"%\'B]`bb}\u0080\u00b9\u00b9\u201a\u201b\u201e"+
		"\u201f\u2028\u2028\u3003\u3004\u300c\u300d\u3012\u3013\uff03\uff03\uff0a"+
		"\uff0b\uff0e\uff0e\uff1c\uff1d\uff21\uff21\uffe7\uffe7\27\2\f\f\17\17"+
		"\"%\'\61<B]`bb}\u0080\u00b9\u00b9\u201a\u201b\u201e\u201f\u2028\u2028"+
		"\u3003\u3004\u300c\u300d\u3012\u3013\uff03\uff03\uff0a\uff0b\uff0e\uff0e"+
		"\uff1c\uff1d\uff21\uff21\uffe7\uffe7\5\2\13\f\17\17\"\"\3\2\f\f\2\u0143"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\3c\3\2\2\2\5h\3\2\2\2\7o\3\2\2\2\tu\3\2\2\2\13x\3"+
		"\2\2\2\r\u008c\3\2\2\2\17\u008e\3\2\2\2\21\u0093\3\2\2\2\23\u0098\3\2"+
		"\2\2\25\u009e\3\2\2\2\27\u00a7\3\2\2\2\31\u00a9\3\2\2\2\33\u00ab\3\2\2"+
		"\2\35\u00ad\3\2\2\2\37\u00af\3\2\2\2!\u00b1\3\2\2\2#\u00b3\3\2\2\2%\u00b5"+
		"\3\2\2\2\'\u00b7\3\2\2\2)\u00ba\3\2\2\2+\u00bd\3\2\2\2-\u00bf\3\2\2\2"+
		"/\u00c1\3\2\2\2\61\u00c3\3\2\2\2\63\u00c5\3\2\2\2\65\u00c7\3\2\2\2\67"+
		"\u00c9\3\2\2\29\u00cb\3\2\2\2;\u00cd\3\2\2\2=\u00cf\3\2\2\2?\u00d1\3\2"+
		"\2\2A\u00d4\3\2\2\2C\u00d6\3\2\2\2E\u00dc\3\2\2\2G\u00df\3\2\2\2I\u00e3"+
		"\3\2\2\2K\u00f8\3\2\2\2M\u00fa\3\2\2\2O\u00fc\3\2\2\2Q\u0109\3\2\2\2S"+
		"\u010b\3\2\2\2U\u0110\3\2\2\2W\u0114\3\2\2\2Y\u0116\3\2\2\2[\u0118\3\2"+
		"\2\2]\u011f\3\2\2\2_\u0123\3\2\2\2a\u012e\3\2\2\2cd\7h\2\2de\7w\2\2ef"+
		"\7p\2\2fg\7e\2\2g\4\3\2\2\2hi\7t\2\2ij\7g\2\2jk\7v\2\2kl\7w\2\2lm\7t\2"+
		"\2mn\7p\2\2n\6\3\2\2\2op\7w\2\2pq\7u\2\2qr\7k\2\2rs\7p\2\2st\7i\2\2t\b"+
		"\3\2\2\2uv\7k\2\2vw\7p\2\2w\n\3\2\2\2xy\7k\2\2yz\7h\2\2z\f\3\2\2\2{|\7"+
		"g\2\2|}\7n\2\2}~\7k\2\2~\u008d\7h\2\2\177\u0080\7g\2\2\u0080\u0081\7n"+
		"\2\2\u0081\u0082\7u\2\2\u0082\u0083\7g\2\2\u0083\u0087\3\2\2\2\u0084\u0086"+
		"\7\"\2\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7k"+
		"\2\2\u008b\u008d\7h\2\2\u008c{\3\2\2\2\u008c\177\3\2\2\2\u008d\16\3\2"+
		"\2\2\u008e\u008f\7g\2\2\u008f\u0090\7n\2\2\u0090\u0091\7u\2\2\u0091\u0092"+
		"\7g\2\2\u0092\20\3\2\2\2\u0093\u0094\7n\2\2\u0094\u0095\7q\2\2\u0095\u0096"+
		"\7q\2\2\u0096\u0097\7r\2\2\u0097\22\3\2\2\2\u0098\u0099\7d\2\2\u0099\u009a"+
		"\7t\2\2\u009a\u009b\7g\2\2\u009b\u009c\7c\2\2\u009c\u009d\7m\2\2\u009d"+
		"\24\3\2\2\2\u009e\u009f\7e\2\2\u009f\u00a0\7q\2\2\u00a0\u00a1\7p\2\2\u00a1"+
		"\u00a2\7v\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7p\2\2\u00a4\u00a5\7w\2\2"+
		"\u00a5\u00a6\7g\2\2\u00a6\26\3\2\2\2\u00a7\u00a8\7.\2\2\u00a8\30\3\2\2"+
		"\2\u00a9\u00aa\7*\2\2\u00aa\32\3\2\2\2\u00ab\u00ac\7+\2\2\u00ac\34\3\2"+
		"\2\2\u00ad\u00ae\7]\2\2\u00ae\36\3\2\2\2\u00af\u00b0\7_\2\2\u00b0 \3\2"+
		"\2\2\u00b1\u00b2\7}\2\2\u00b2\"\3\2\2\2\u00b3\u00b4\7\177\2\2\u00b4$\3"+
		"\2\2\2\u00b5\u00b6\7\60\2\2\u00b6&\3\2\2\2\u00b7\u00b8\7?\2\2\u00b8\u00b9"+
		"\7?\2\2\u00b9(\3\2\2\2\u00ba\u00bb\7#\2\2\u00bb\u00bc\7?\2\2\u00bc*\3"+
		"\2\2\2\u00bd\u00be\7?\2\2\u00be,\3\2\2\2\u00bf\u00c0\7-\2\2\u00c0.\3\2"+
		"\2\2\u00c1\u00c2\7/\2\2\u00c2\60\3\2\2\2\u00c3\u00c4\7,\2\2\u00c4\62\3"+
		"\2\2\2\u00c5\u00c6\7\61\2\2\u00c6\64\3\2\2\2\u00c7\u00c8\7\'\2\2\u00c8"+
		"\66\3\2\2\2\u00c9\u00ca\7#\2\2\u00ca8\3\2\2\2\u00cb\u00cc\7(\2\2\u00cc"+
		":\3\2\2\2\u00cd\u00ce\7~\2\2\u00ce<\3\2\2\2\u00cf\u00d0\7@\2\2\u00d0>"+
		"\3\2\2\2\u00d1\u00d2\7@\2\2\u00d2\u00d3\7?\2\2\u00d3@\3\2\2\2\u00d4\u00d5"+
		"\7>\2\2\u00d5B\3\2\2\2\u00d6\u00d7\7>\2\2\u00d7\u00d8\7?\2\2\u00d8D\3"+
		"\2\2\2\u00d9\u00dd\n\2\2\2\u00da\u00db\7^\2\2\u00db\u00dd\7$\2\2\u00dc"+
		"\u00d9\3\2\2\2\u00dc\u00da\3\2\2\2\u00ddF\3\2\2\2\u00de\u00e0\t\3\2\2"+
		"\u00df\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2"+
		"\3\2\2\2\u00e2H\3\2\2\2\u00e3\u00e4\7^\2\2\u00e4\u00e5\13\2\2\2\u00e5"+
		"J\3\2\2\2\u00e6\u00eb\7$\2\2\u00e7\u00ea\5I%\2\u00e8\u00ea\n\4\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee"+
		"\u00f9\7$\2\2\u00ef\u00f4\7)\2\2\u00f0\u00f3\5I%\2\u00f1\u00f3\n\5\2\2"+
		"\u00f2\u00f0\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2"+
		"\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7"+
		"\u00f9\7)\2\2\u00f8\u00e6\3\2\2\2\u00f8\u00ef\3\2\2\2\u00f9L\3\2\2\2\u00fa"+
		"\u00fb\5G$\2\u00fbN\3\2\2\2\u00fc\u00fd\5G$\2\u00fd\u00fe\7\60\2\2\u00fe"+
		"\u00ff\5G$\2\u00ffP\3\2\2\2\u0100\u0101\7v\2\2\u0101\u0102\7t\2\2\u0102"+
		"\u0103\7w\2\2\u0103\u010a\7g\2\2\u0104\u0105\7h\2\2\u0105\u0106\7c\2\2"+
		"\u0106\u0107\7n\2\2\u0107\u0108\7u\2\2\u0108\u010a\7g\2\2\u0109\u0100"+
		"\3\2\2\2\u0109\u0104\3\2\2\2\u010aR\3\2\2\2\u010b\u010c\7p\2\2\u010c\u010d"+
		"\7q\2\2\u010d\u010e\7p\2\2\u010e\u010f\7g\2\2\u010fT\3\2\2\2\u0110\u0111"+
		"\7p\2\2\u0111\u0112\7c\2\2\u0112\u0113\7p\2\2\u0113V\3\2\2\2\u0114\u0115"+
		"\n\6\2\2\u0115X\3\2\2\2\u0116\u0117\n\7\2\2\u0117Z\3\2\2\2\u0118\u011c"+
		"\5W,\2\u0119\u011b\5Y-\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\\\3\2\2\2\u011e\u011c\3\2\2\2"+
		"\u011f\u0120\t\b\2\2\u0120\u0121\3\2\2\2\u0121\u0122\b/\2\2\u0122^\3\2"+
		"\2\2\u0123\u0124\7\61\2\2\u0124\u0125\7\61\2\2\u0125\u0129\3\2\2\2\u0126"+
		"\u0128\n\t\2\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2"+
		"\2\2\u0129\u012a\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c"+
		"\u012d\b\60\2\2\u012d`\3\2\2\2\u012e\u012f\7\61\2\2\u012f\u0130\7,\2\2"+
		"\u0130\u0134\3\2\2\2\u0131\u0133\13\2\2\2\u0132\u0131\3\2\2\2\u0133\u0136"+
		"\3\2\2\2\u0134\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0137\3\2\2\2\u0136"+
		"\u0134\3\2\2\2\u0137\u0138\7,\2\2\u0138\u0139\7\61\2\2\u0139\u013a\3\2"+
		"\2\2\u013a\u013b\b\61\2\2\u013bb\3\2\2\2\20\2\u0087\u008c\u00dc\u00e1"+
		"\u00e9\u00eb\u00f2\u00f4\u00f8\u0109\u011c\u0129\u0134\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}