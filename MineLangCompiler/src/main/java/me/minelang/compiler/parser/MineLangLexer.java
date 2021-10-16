// Generated from D:/MineLang/MineCompiler/src/main/antlr\MineLang.g4 by ANTLR 4.9.1
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
		EQ=19, NEQ=20, SET=21, PLUS=22, MINUS=23, MUTIPLY=24, DEVIDE=25, POWER=26, 
		NOT=27, GTR=28, GTREQ=29, LWR=30, LWREQ=31, STRING=32, INT=33, REAL=34, 
		BOOL=35, NONE=36, ID=37, WS=38, COMMENT=39, MUTICOMMENT=40;
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
			"NEQ", "SET", "PLUS", "MINUS", "MUTIPLY", "DEVIDE", "POWER", "NOT", "GTR", 
			"GTREQ", "LWR", "LWREQ", "STRCHAR", "INTEGER", "ESCAPECHAR", "STRING", 
			"INT", "REAL", "BOOL", "NONE", "IDStart", "IDPart", "ID", "WS", "COMMENT", 
			"MUTICOMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u0129\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7"+
		"|\n\7\f\7\16\7\177\13\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37"+
		"\3\37\3 \3 \3 \3!\3!\3!\5!\u00ce\n!\3\"\6\"\u00d1\n\"\r\"\16\"\u00d2\3"+
		"#\3#\3#\3$\3$\3$\7$\u00db\n$\f$\16$\u00de\13$\3$\3$\3$\3$\7$\u00e4\n$"+
		"\f$\16$\u00e7\13$\3$\5$\u00ea\n$\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\5\'\u00fb\n\'\3(\3(\3(\3(\3(\3)\3)\3*\3*\3+\3+\7+\u0108"+
		"\n+\f+\16+\u010b\13+\3,\3,\3,\3,\3-\3-\3-\3-\7-\u0115\n-\f-\16-\u0118"+
		"\13-\3-\3-\3.\3.\3.\3.\7.\u0120\n.\f.\16.\u0123\13.\3.\3.\3.\3.\3.\3\u0121"+
		"\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\2C\2E\2G\"I#K$M%O&Q\2S\2U\'W(Y)[*\3\2\n\3\2$$\3\2\62;\4\2$$"+
		"^^\4\2))^^\26\2\f\f\17\17\"%\'B]`bb}\u0080\u00b9\u00b9\u201a\u201b\u201e"+
		"\u201f\u2028\u2028\u3003\u3004\u300c\u300d\u3012\u3013\uff03\uff03\uff0a"+
		"\uff0b\uff0e\uff0e\uff1c\uff1d\uff21\uff21\uffe7\uffe7\27\2\f\f\17\17"+
		"\"%\'\61<B]`bb}\u0080\u00b9\u00b9\u201a\u201b\u201e\u201f\u2028\u2028"+
		"\u3003\u3004\u300c\u300d\u3012\u3013\uff03\uff03\uff0a\uff0b\uff0e\uff0e"+
		"\uff1c\uff1d\uff21\uff21\uffe7\uffe7\5\2\13\f\17\17\"\"\3\2\f\f\2\u012f"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\3]\3\2\2\2\5"+
		"b\3\2\2\2\7i\3\2\2\2\to\3\2\2\2\13r\3\2\2\2\ru\3\2\2\2\17\u0083\3\2\2"+
		"\2\21\u0088\3\2\2\2\23\u008d\3\2\2\2\25\u0093\3\2\2\2\27\u009c\3\2\2\2"+
		"\31\u009e\3\2\2\2\33\u00a0\3\2\2\2\35\u00a2\3\2\2\2\37\u00a4\3\2\2\2!"+
		"\u00a6\3\2\2\2#\u00a8\3\2\2\2%\u00aa\3\2\2\2\'\u00ac\3\2\2\2)\u00af\3"+
		"\2\2\2+\u00b2\3\2\2\2-\u00b4\3\2\2\2/\u00b6\3\2\2\2\61\u00b8\3\2\2\2\63"+
		"\u00ba\3\2\2\2\65\u00bc\3\2\2\2\67\u00be\3\2\2\29\u00c0\3\2\2\2;\u00c2"+
		"\3\2\2\2=\u00c5\3\2\2\2?\u00c7\3\2\2\2A\u00cd\3\2\2\2C\u00d0\3\2\2\2E"+
		"\u00d4\3\2\2\2G\u00e9\3\2\2\2I\u00eb\3\2\2\2K\u00ed\3\2\2\2M\u00fa\3\2"+
		"\2\2O\u00fc\3\2\2\2Q\u0101\3\2\2\2S\u0103\3\2\2\2U\u0105\3\2\2\2W\u010c"+
		"\3\2\2\2Y\u0110\3\2\2\2[\u011b\3\2\2\2]^\7h\2\2^_\7w\2\2_`\7p\2\2`a\7"+
		"e\2\2a\4\3\2\2\2bc\7t\2\2cd\7g\2\2de\7v\2\2ef\7w\2\2fg\7t\2\2gh\7p\2\2"+
		"h\6\3\2\2\2ij\7w\2\2jk\7u\2\2kl\7k\2\2lm\7p\2\2mn\7i\2\2n\b\3\2\2\2op"+
		"\7k\2\2pq\7p\2\2q\n\3\2\2\2rs\7k\2\2st\7h\2\2t\f\3\2\2\2uv\7g\2\2vw\7"+
		"n\2\2wx\7u\2\2xy\7g\2\2y}\3\2\2\2z|\7\"\2\2{z\3\2\2\2|\177\3\2\2\2}{\3"+
		"\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7k\2\2\u0081"+
		"\u0082\7h\2\2\u0082\16\3\2\2\2\u0083\u0084\7g\2\2\u0084\u0085\7n\2\2\u0085"+
		"\u0086\7u\2\2\u0086\u0087\7g\2\2\u0087\20\3\2\2\2\u0088\u0089\7n\2\2\u0089"+
		"\u008a\7q\2\2\u008a\u008b\7q\2\2\u008b\u008c\7r\2\2\u008c\22\3\2\2\2\u008d"+
		"\u008e\7d\2\2\u008e\u008f\7t\2\2\u008f\u0090\7g\2\2\u0090\u0091\7c\2\2"+
		"\u0091\u0092\7m\2\2\u0092\24\3\2\2\2\u0093\u0094\7e\2\2\u0094\u0095\7"+
		"q\2\2\u0095\u0096\7p\2\2\u0096\u0097\7v\2\2\u0097\u0098\7k\2\2\u0098\u0099"+
		"\7p\2\2\u0099\u009a\7w\2\2\u009a\u009b\7g\2\2\u009b\26\3\2\2\2\u009c\u009d"+
		"\7.\2\2\u009d\30\3\2\2\2\u009e\u009f\7*\2\2\u009f\32\3\2\2\2\u00a0\u00a1"+
		"\7+\2\2\u00a1\34\3\2\2\2\u00a2\u00a3\7]\2\2\u00a3\36\3\2\2\2\u00a4\u00a5"+
		"\7_\2\2\u00a5 \3\2\2\2\u00a6\u00a7\7}\2\2\u00a7\"\3\2\2\2\u00a8\u00a9"+
		"\7\177\2\2\u00a9$\3\2\2\2\u00aa\u00ab\7\60\2\2\u00ab&\3\2\2\2\u00ac\u00ad"+
		"\7?\2\2\u00ad\u00ae\7?\2\2\u00ae(\3\2\2\2\u00af\u00b0\7#\2\2\u00b0\u00b1"+
		"\7?\2\2\u00b1*\3\2\2\2\u00b2\u00b3\7?\2\2\u00b3,\3\2\2\2\u00b4\u00b5\7"+
		"-\2\2\u00b5.\3\2\2\2\u00b6\u00b7\7/\2\2\u00b7\60\3\2\2\2\u00b8\u00b9\7"+
		",\2\2\u00b9\62\3\2\2\2\u00ba\u00bb\7\61\2\2\u00bb\64\3\2\2\2\u00bc\u00bd"+
		"\7`\2\2\u00bd\66\3\2\2\2\u00be\u00bf\7#\2\2\u00bf8\3\2\2\2\u00c0\u00c1"+
		"\7@\2\2\u00c1:\3\2\2\2\u00c2\u00c3\7@\2\2\u00c3\u00c4\7?\2\2\u00c4<\3"+
		"\2\2\2\u00c5\u00c6\7>\2\2\u00c6>\3\2\2\2\u00c7\u00c8\7>\2\2\u00c8\u00c9"+
		"\7?\2\2\u00c9@\3\2\2\2\u00ca\u00ce\n\2\2\2\u00cb\u00cc\7^\2\2\u00cc\u00ce"+
		"\7$\2\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ceB\3\2\2\2\u00cf\u00d1"+
		"\t\3\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3D\3\2\2\2\u00d4\u00d5\7^\2\2\u00d5\u00d6\13\2\2\2"+
		"\u00d6F\3\2\2\2\u00d7\u00dc\7$\2\2\u00d8\u00db\5E#\2\u00d9\u00db\n\4\2"+
		"\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da"+
		"\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\3\2\2\2\u00de\u00dc\3\2\2\2\u00df"+
		"\u00ea\7$\2\2\u00e0\u00e5\7)\2\2\u00e1\u00e4\5E#\2\u00e2\u00e4\n\5\2\2"+
		"\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3"+
		"\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8"+
		"\u00ea\7)\2\2\u00e9\u00d7\3\2\2\2\u00e9\u00e0\3\2\2\2\u00eaH\3\2\2\2\u00eb"+
		"\u00ec\5C\"\2\u00ecJ\3\2\2\2\u00ed\u00ee\5C\"\2\u00ee\u00ef\7\60\2\2\u00ef"+
		"\u00f0\5C\"\2\u00f0L\3\2\2\2\u00f1\u00f2\7v\2\2\u00f2\u00f3\7t\2\2\u00f3"+
		"\u00f4\7w\2\2\u00f4\u00fb\7g\2\2\u00f5\u00f6\7h\2\2\u00f6\u00f7\7c\2\2"+
		"\u00f7\u00f8\7n\2\2\u00f8\u00f9\7u\2\2\u00f9\u00fb\7g\2\2\u00fa\u00f1"+
		"\3\2\2\2\u00fa\u00f5\3\2\2\2\u00fbN\3\2\2\2\u00fc\u00fd\7p\2\2\u00fd\u00fe"+
		"\7q\2\2\u00fe\u00ff\7p\2\2\u00ff\u0100\7g\2\2\u0100P\3\2\2\2\u0101\u0102"+
		"\n\6\2\2\u0102R\3\2\2\2\u0103\u0104\n\7\2\2\u0104T\3\2\2\2\u0105\u0109"+
		"\5Q)\2\u0106\u0108\5S*\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010aV\3\2\2\2\u010b\u0109\3\2\2\2"+
		"\u010c\u010d\t\b\2\2\u010d\u010e\3\2\2\2\u010e\u010f\b,\2\2\u010fX\3\2"+
		"\2\2\u0110\u0111\7\61\2\2\u0111\u0112\7\61\2\2\u0112\u0116\3\2\2\2\u0113"+
		"\u0115\n\t\2\2\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u0116\3\2\2\2\u0119"+
		"\u011a\b-\2\2\u011aZ\3\2\2\2\u011b\u011c\7\61\2\2\u011c\u011d\7,\2\2\u011d"+
		"\u0121\3\2\2\2\u011e\u0120\13\2\2\2\u011f\u011e\3\2\2\2\u0120\u0123\3"+
		"\2\2\2\u0121\u0122\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0124\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0124\u0125\7,\2\2\u0125\u0126\7\61\2\2\u0126\u0127\3\2"+
		"\2\2\u0127\u0128\b.\2\2\u0128\\\3\2\2\2\17\2}\u00cd\u00d2\u00da\u00dc"+
		"\u00e3\u00e5\u00e9\u00fa\u0109\u0116\u0121\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}