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
		INT=40, DEC=41, BOOL=42, NONE=43, NAN=44, UNDEFINED=45, ID=46;
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
			"DEC", "BOOL", "NONE", "NAN", "UNDEFINED", "IDStart", "IDPart", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'func'", "'return'", "'using'", "'in'", "'if'", 
			null, "'else'", "'loop'", "'break'", "'continue'", "'global'", "','", 
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'.'", "'=='", "'!='", 
			"'='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'&'", "'|'", "'>'", 
			"'>='", "'<'", "'<='", null, null, null, null, "'none'", "'nan'", "'undefined'"
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
			"NONE", "NAN", "UNDEFINED", "ID"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u0158\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3r\n\3\f\3\16\3u\13\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\7\4}\n\4\f\4\16\4\u0080\13\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00a9"+
		"\n\n\f\n\16\n\u00ac\13\n\3\n\3\n\5\n\u00b0\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21"+
		"\6\21\u00d5\n\21\r\21\16\21\u00d6\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#"+
		"\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\5(\u010c\n(\3)\6)\u010f\n)"+
		"\r)\16)\u0110\3*\3*\3*\3+\3+\3+\7+\u0119\n+\f+\16+\u011c\13+\3+\3+\3+"+
		"\3+\7+\u0122\n+\f+\16+\u0125\13+\3+\5+\u0128\n+\3,\3,\3-\3-\3-\3-\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\5.\u0139\n.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\63\3\63"+
		"\3\64\3\64\7\64\u0154\n\64\f\64\16\64\u0157\13\64\3~\2\65\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O\2Q\2S\2U)W*Y+[,]-_.a/c\2e\2g\60\3\2\n\5\2\13\f\17\17\"\"\3\2"+
		"\f\f\3\2$$\3\2\62;\4\2$$^^\4\2))^^\26\2\13\f\17\17\"%\'B]`bb}\u0080\u00b9"+
		"\u00b9\u201a\u201b\u201e\u201f\u2028\u2028\u3003\u3004\u300c\u300d\u3012"+
		"\u3013\uff03\uff03\uff0a\uff0b\uff0e\uff0e\uff1c\uff1d\uff21\uff21\uffe7"+
		"\uffe7\27\2\13\f\17\17\"%\'\61<B]`bb}\u0080\u00b9\u00b9\u201a\u201b\u201e"+
		"\u201f\u2028\u2028\u3003\u3004\u300c\u300d\u3012\u3013\uff03\uff03\uff0a"+
		"\uff0b\uff0e\uff0e\uff1c\uff1d\uff21\uff21\uffe7\uffe7\2\u0160\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2g\3\2\2\2\3i\3\2\2\2\5m\3\2\2\2\7"+
		"x\3\2\2\2\t\u0086\3\2\2\2\13\u008b\3\2\2\2\r\u0092\3\2\2\2\17\u0098\3"+
		"\2\2\2\21\u009b\3\2\2\2\23\u00af\3\2\2\2\25\u00b1\3\2\2\2\27\u00b6\3\2"+
		"\2\2\31\u00bb\3\2\2\2\33\u00c1\3\2\2\2\35\u00ca\3\2\2\2\37\u00d1\3\2\2"+
		"\2!\u00d4\3\2\2\2#\u00d8\3\2\2\2%\u00da\3\2\2\2\'\u00dc\3\2\2\2)\u00de"+
		"\3\2\2\2+\u00e0\3\2\2\2-\u00e2\3\2\2\2/\u00e4\3\2\2\2\61\u00e6\3\2\2\2"+
		"\63\u00e9\3\2\2\2\65\u00ec\3\2\2\2\67\u00ee\3\2\2\29\u00f0\3\2\2\2;\u00f2"+
		"\3\2\2\2=\u00f4\3\2\2\2?\u00f6\3\2\2\2A\u00f8\3\2\2\2C\u00fa\3\2\2\2E"+
		"\u00fc\3\2\2\2G\u00fe\3\2\2\2I\u0100\3\2\2\2K\u0103\3\2\2\2M\u0105\3\2"+
		"\2\2O\u010b\3\2\2\2Q\u010e\3\2\2\2S\u0112\3\2\2\2U\u0127\3\2\2\2W\u0129"+
		"\3\2\2\2Y\u012b\3\2\2\2[\u0138\3\2\2\2]\u013a\3\2\2\2_\u013f\3\2\2\2a"+
		"\u0143\3\2\2\2c\u014d\3\2\2\2e\u014f\3\2\2\2g\u0151\3\2\2\2ij\t\2\2\2"+
		"jk\3\2\2\2kl\b\2\2\2l\4\3\2\2\2mn\7\61\2\2no\7\61\2\2os\3\2\2\2pr\n\3"+
		"\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\b\3"+
		"\2\2w\6\3\2\2\2xy\7\61\2\2yz\7,\2\2z~\3\2\2\2{}\13\2\2\2|{\3\2\2\2}\u0080"+
		"\3\2\2\2~\177\3\2\2\2~|\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081"+
		"\u0082\7,\2\2\u0082\u0083\7\61\2\2\u0083\u0084\3\2\2\2\u0084\u0085\b\4"+
		"\2\2\u0085\b\3\2\2\2\u0086\u0087\7h\2\2\u0087\u0088\7w\2\2\u0088\u0089"+
		"\7p\2\2\u0089\u008a\7e\2\2\u008a\n\3\2\2\2\u008b\u008c\7t\2\2\u008c\u008d"+
		"\7g\2\2\u008d\u008e\7v\2\2\u008e\u008f\7w\2\2\u008f\u0090\7t\2\2\u0090"+
		"\u0091\7p\2\2\u0091\f\3\2\2\2\u0092\u0093\7w\2\2\u0093\u0094\7u\2\2\u0094"+
		"\u0095\7k\2\2\u0095\u0096\7p\2\2\u0096\u0097\7i\2\2\u0097\16\3\2\2\2\u0098"+
		"\u0099\7k\2\2\u0099\u009a\7p\2\2\u009a\20\3\2\2\2\u009b\u009c\7k\2\2\u009c"+
		"\u009d\7h\2\2\u009d\22\3\2\2\2\u009e\u009f\7g\2\2\u009f\u00a0\7n\2\2\u00a0"+
		"\u00a1\7k\2\2\u00a1\u00b0\7h\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7n\2\2"+
		"\u00a4\u00a5\7u\2\2\u00a5\u00a6\7g\2\2\u00a6\u00aa\3\2\2\2\u00a7\u00a9"+
		"\7\"\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7k"+
		"\2\2\u00ae\u00b0\7h\2\2\u00af\u009e\3\2\2\2\u00af\u00a2\3\2\2\2\u00b0"+
		"\24\3\2\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7u\2\2\u00b4"+
		"\u00b5\7g\2\2\u00b5\26\3\2\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7q\2\2\u00b8"+
		"\u00b9\7q\2\2\u00b9\u00ba\7r\2\2\u00ba\30\3\2\2\2\u00bb\u00bc\7d\2\2\u00bc"+
		"\u00bd\7t\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7m\2\2"+
		"\u00c0\32\3\2\2\2\u00c1\u00c2\7e\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4\7"+
		"p\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8"+
		"\7w\2\2\u00c8\u00c9\7g\2\2\u00c9\34\3\2\2\2\u00ca\u00cb\7i\2\2\u00cb\u00cc"+
		"\7n\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7d\2\2\u00ce\u00cf\7c\2\2\u00cf"+
		"\u00d0\7n\2\2\u00d0\36\3\2\2\2\u00d1\u00d2\7.\2\2\u00d2 \3\2\2\2\u00d3"+
		"\u00d5\7=\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2"+
		"\2\2\u00d6\u00d7\3\2\2\2\u00d7\"\3\2\2\2\u00d8\u00d9\7*\2\2\u00d9$\3\2"+
		"\2\2\u00da\u00db\7+\2\2\u00db&\3\2\2\2\u00dc\u00dd\7]\2\2\u00dd(\3\2\2"+
		"\2\u00de\u00df\7_\2\2\u00df*\3\2\2\2\u00e0\u00e1\7}\2\2\u00e1,\3\2\2\2"+
		"\u00e2\u00e3\7\177\2\2\u00e3.\3\2\2\2\u00e4\u00e5\7\60\2\2\u00e5\60\3"+
		"\2\2\2\u00e6\u00e7\7?\2\2\u00e7\u00e8\7?\2\2\u00e8\62\3\2\2\2\u00e9\u00ea"+
		"\7#\2\2\u00ea\u00eb\7?\2\2\u00eb\64\3\2\2\2\u00ec\u00ed\7?\2\2\u00ed\66"+
		"\3\2\2\2\u00ee\u00ef\7-\2\2\u00ef8\3\2\2\2\u00f0\u00f1\7/\2\2\u00f1:\3"+
		"\2\2\2\u00f2\u00f3\7,\2\2\u00f3<\3\2\2\2\u00f4\u00f5\7\61\2\2\u00f5>\3"+
		"\2\2\2\u00f6\u00f7\7\'\2\2\u00f7@\3\2\2\2\u00f8\u00f9\7#\2\2\u00f9B\3"+
		"\2\2\2\u00fa\u00fb\7(\2\2\u00fbD\3\2\2\2\u00fc\u00fd\7~\2\2\u00fdF\3\2"+
		"\2\2\u00fe\u00ff\7@\2\2\u00ffH\3\2\2\2\u0100\u0101\7@\2\2\u0101\u0102"+
		"\7?\2\2\u0102J\3\2\2\2\u0103\u0104\7>\2\2\u0104L\3\2\2\2\u0105\u0106\7"+
		">\2\2\u0106\u0107\7?\2\2\u0107N\3\2\2\2\u0108\u010c\n\4\2\2\u0109\u010a"+
		"\7^\2\2\u010a\u010c\7$\2\2\u010b\u0108\3\2\2\2\u010b\u0109\3\2\2\2\u010c"+
		"P\3\2\2\2\u010d\u010f\t\5\2\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2"+
		"\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111R\3\2\2\2\u0112\u0113\7"+
		"^\2\2\u0113\u0114\13\2\2\2\u0114T\3\2\2\2\u0115\u011a\7$\2\2\u0116\u0119"+
		"\5S*\2\u0117\u0119\n\6\2\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119"+
		"\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2"+
		"\2\2\u011c\u011a\3\2\2\2\u011d\u0128\7$\2\2\u011e\u0123\7)\2\2\u011f\u0122"+
		"\5S*\2\u0120\u0122\n\7\2\2\u0121\u011f\3\2\2\2\u0121\u0120\3\2\2\2\u0122"+
		"\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126\3\2"+
		"\2\2\u0125\u0123\3\2\2\2\u0126\u0128\7)\2\2\u0127\u0115\3\2\2\2\u0127"+
		"\u011e\3\2\2\2\u0128V\3\2\2\2\u0129\u012a\5Q)\2\u012aX\3\2\2\2\u012b\u012c"+
		"\5Q)\2\u012c\u012d\7\60\2\2\u012d\u012e\5Q)\2\u012eZ\3\2\2\2\u012f\u0130"+
		"\7v\2\2\u0130\u0131\7t\2\2\u0131\u0132\7w\2\2\u0132\u0139\7g\2\2\u0133"+
		"\u0134\7h\2\2\u0134\u0135\7c\2\2\u0135\u0136\7n\2\2\u0136\u0137\7u\2\2"+
		"\u0137\u0139\7g\2\2\u0138\u012f\3\2\2\2\u0138\u0133\3\2\2\2\u0139\\\3"+
		"\2\2\2\u013a\u013b\7p\2\2\u013b\u013c\7q\2\2\u013c\u013d\7p\2\2\u013d"+
		"\u013e\7g\2\2\u013e^\3\2\2\2\u013f\u0140\7p\2\2\u0140\u0141\7c\2\2\u0141"+
		"\u0142\7p\2\2\u0142`\3\2\2\2\u0143\u0144\7w\2\2\u0144\u0145\7p\2\2\u0145"+
		"\u0146\7f\2\2\u0146\u0147\7g\2\2\u0147\u0148\7h\2\2\u0148\u0149\7k\2\2"+
		"\u0149\u014a\7p\2\2\u014a\u014b\7g\2\2\u014b\u014c\7f\2\2\u014cb\3\2\2"+
		"\2\u014d\u014e\n\b\2\2\u014ed\3\2\2\2\u014f\u0150\n\t\2\2\u0150f\3\2\2"+
		"\2\u0151\u0155\5c\62\2\u0152\u0154\5e\63\2\u0153\u0152\3\2\2\2\u0154\u0157"+
		"\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156h\3\2\2\2\u0157"+
		"\u0155\3\2\2\2\21\2s~\u00aa\u00af\u00d6\u010b\u0110\u0118\u011a\u0121"+
		"\u0123\u0127\u0138\u0155\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}