/* The following code was generated by JFlex 1.7.0 */

package analizadores;
import java_cup.runtime.Symbol; 


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>lexico.jflex</tt>
 */
public class Lexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\3\1\72\1\1\1\2\22\0\1\4\1\0\1\26"+
    "\1\0\1\23\2\0\1\22\1\66\1\67\1\6\1\65\1\57\1\41"+
    "\1\12\1\5\1\17\1\20\1\21\2\7\1\14\1\13\2\15\1\16"+
    "\1\0\1\56\2\0\1\42\1\63\1\0\1\33\1\55\1\46\1\32"+
    "\1\30\1\35\1\47\1\61\1\44\1\54\1\10\1\36\1\50\1\45"+
    "\1\34\1\52\1\64\1\31\1\40\1\51\1\53\1\27\2\10\1\60"+
    "\1\10\1\70\1\0\1\71\1\0\1\11\1\0\1\33\1\55\1\46"+
    "\1\32\1\30\1\35\1\47\1\61\1\44\1\54\1\10\1\36\1\50"+
    "\1\45\1\34\1\52\1\64\1\31\1\40\1\51\1\53\1\27\2\10"+
    "\1\60\1\10\1\24\1\0\1\25\7\0\1\72\71\0\1\62\160\0"+
    "\2\43\115\0\1\37\u1ea8\0\1\72\1\72\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\1\5\13\1\1\6"+
    "\6\1\1\7\1\10\1\1\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\6\0\1\21\10\0\1\22"+
    "\4\0\1\23\1\24\16\0\2\20\2\0\1\5\1\25"+
    "\1\26\10\0\1\27\2\0\1\30\5\0\1\31\10\0"+
    "\1\32\7\0\1\20\14\0\1\33\14\0\1\34\4\0"+
    "\1\35\16\0\1\36\5\0\1\37\11\0\1\40\1\0"+
    "\1\41\3\0\1\42\1\43\12\0\1\44\4\0\1\45"+
    "\2\0\1\46\1\0\1\47\4\0\1\50\13\0\1\51"+
    "\6\0\1\52\12\0\1\53\2\0\1\54\1\55\1\56"+
    "\1\57\5\0\1\60\1\61\1\62\1\63\5\0\1\64"+
    "\1\65\4\0\1\66\4\0\1\67\3\0\1\70\3\0"+
    "\1\71\10\0\1\72\1\0\1\73\4\0\1\74\1\0"+
    "\1\75\7\0\1\76\1\77\2\0\1\100\1\101\1\102";

  private static int [] zzUnpackAction() {
    int [] result = new int[311];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\73\0\73\0\166\0\261\0\73\0\354\0\u0127"+
    "\0\u0162\0\u019d\0\u01d8\0\u0213\0\u024e\0\u0289\0\u02c4\0\u02ff"+
    "\0\u033a\0\u0375\0\u03b0\0\u03eb\0\u0426\0\u0461\0\u049c\0\u04d7"+
    "\0\u0512\0\73\0\73\0\u054d\0\73\0\73\0\73\0\73"+
    "\0\73\0\73\0\73\0\u0588\0\u05c3\0\u05fe\0\u0639\0\u0674"+
    "\0\u06af\0\u019d\0\73\0\u06ea\0\u0725\0\u0760\0\u079b\0\u07d6"+
    "\0\u0811\0\u084c\0\u0887\0\73\0\u08c2\0\u08fd\0\u0938\0\u0973"+
    "\0\73\0\73\0\u09ae\0\u09e9\0\u0a24\0\u0a5f\0\u0a9a\0\u0ad5"+
    "\0\u0b10\0\u0b4b\0\u0b86\0\u0bc1\0\u0bfc\0\u0c37\0\u0c72\0\u0cad"+
    "\0\u0ce8\0\73\0\u0d23\0\u0d5e\0\u05fe\0\u0639\0\73\0\u0d99"+
    "\0\u0dd4\0\u0e0f\0\u0e4a\0\u0e85\0\u0ec0\0\u0efb\0\u0f36\0\73"+
    "\0\u0f71\0\u0fac\0\u0fe7\0\u1022\0\u105d\0\u1098\0\u10d3\0\u110e"+
    "\0\73\0\u1149\0\u1184\0\u11bf\0\u11fa\0\u1235\0\u1270\0\u12ab"+
    "\0\u12e6\0\73\0\u1321\0\u135c\0\u1397\0\u13d2\0\u140d\0\u1448"+
    "\0\u1483\0\u0d23\0\u14be\0\u14f9\0\u1534\0\u156f\0\u15aa\0\u15e5"+
    "\0\u1620\0\u165b\0\u1696\0\u16d1\0\u170c\0\u1747\0\73\0\u1782"+
    "\0\u17bd\0\u17f8\0\u1833\0\u186e\0\u18a9\0\u18e4\0\u191f\0\u195a"+
    "\0\u1995\0\u19d0\0\u1a0b\0\73\0\u1a46\0\u1a81\0\u1abc\0\u1af7"+
    "\0\73\0\u1b32\0\u1b6d\0\u1ba8\0\u1be3\0\u1c1e\0\u1c59\0\u1c94"+
    "\0\u1ccf\0\u1d0a\0\u1d45\0\u1d80\0\u1dbb\0\u1df6\0\u1e31\0\73"+
    "\0\u1e6c\0\u1ea7\0\u1ee2\0\u1f1d\0\u1f58\0\73\0\u1f93\0\u1fce"+
    "\0\u2009\0\u2044\0\u207f\0\u20ba\0\u20f5\0\u2130\0\u216b\0\u21a6"+
    "\0\u21e1\0\u221c\0\u2257\0\u2292\0\u22cd\0\u2308\0\73\0\u2343"+
    "\0\u237e\0\u23b9\0\u23f4\0\u242f\0\u246a\0\u24a5\0\u24e0\0\u251b"+
    "\0\u2556\0\73\0\u2591\0\u25cc\0\u2607\0\u2642\0\73\0\u267d"+
    "\0\u26b8\0\73\0\u26f3\0\73\0\u272e\0\u2769\0\u27a4\0\u27df"+
    "\0\73\0\u281a\0\u2855\0\u2890\0\u28cb\0\u2906\0\u2941\0\u297c"+
    "\0\u29b7\0\u29f2\0\u2a2d\0\u2a68\0\73\0\u2aa3\0\u2ade\0\u2b19"+
    "\0\u2b54\0\u2b8f\0\u2bca\0\73\0\u2c05\0\u2c40\0\u2c7b\0\u2cb6"+
    "\0\u2cf1\0\u2d2c\0\u2d67\0\u2da2\0\u2ddd\0\u2e18\0\73\0\u2e53"+
    "\0\u2e8e\0\73\0\73\0\73\0\73\0\u2ec9\0\u2f04\0\u2f3f"+
    "\0\u2f7a\0\u2fb5\0\73\0\73\0\u2ff0\0\73\0\u302b\0\u3066"+
    "\0\u30a1\0\u30dc\0\u3117\0\73\0\73\0\u3152\0\u318d\0\u31c8"+
    "\0\u3203\0\73\0\u323e\0\u3279\0\u32b4\0\u32ef\0\73\0\u332a"+
    "\0\u3365\0\u33a0\0\73\0\u33db\0\u3416\0\u3451\0\73\0\u348c"+
    "\0\u34c7\0\u3502\0\u353d\0\u3578\0\u35b3\0\u35ee\0\u3629\0\73"+
    "\0\u3664\0\73\0\u369f\0\u36da\0\u3715\0\u3750\0\73\0\u378b"+
    "\0\73\0\u37c6\0\u3801\0\u383c\0\u3877\0\u38b2\0\u38ed\0\u3928"+
    "\0\73\0\73\0\u3963\0\u399e\0\73\0\73\0\73";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[311];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\2\3\1\5\1\6\1\7\1\2"+
    "\1\10\1\2\7\7\1\11\3\2\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\2\2\22\1\23"+
    "\1\2\2\24\1\25\1\26\1\2\1\27\1\2\1\30"+
    "\2\2\1\31\1\32\1\33\1\2\1\34\1\35\1\36"+
    "\1\2\1\37\1\40\1\41\1\42\1\43\77\0\1\3"+
    "\74\0\1\44\1\45\73\0\1\7\2\0\1\46\7\7"+
    "\61\0\1\47\16\0\10\47\1\0\1\47\3\0\12\47"+
    "\2\0\2\47\2\0\1\47\6\0\23\50\1\51\47\50"+
    "\26\52\1\53\44\52\30\0\1\54\101\0\2\55\4\0"+
    "\1\56\6\0\1\57\46\0\1\60\72\0\1\61\107\0"+
    "\1\62\36\0\1\63\17\0\1\64\74\0\1\65\7\0"+
    "\2\66\6\0\1\67\47\0\1\70\12\0\2\71\70\0"+
    "\1\72\75\0\1\73\2\0\1\74\56\0\1\75\16\0"+
    "\1\76\52\0\1\77\1\100\66\0\1\101\2\0\1\102"+
    "\1\103\6\0\2\104\61\0\1\105\1\106\72\0\1\107"+
    "\71\0\1\110\37\0\2\44\1\111\1\112\67\44\6\113"+
    "\1\114\64\113\7\0\1\115\3\0\7\115\60\0\2\47"+
    "\1\116\1\0\7\47\5\0\10\47\1\0\1\47\3\0"+
    "\12\47\2\0\2\47\2\0\1\47\30\0\1\117\72\0"+
    "\1\117\1\0\1\120\77\0\1\121\52\0\1\122\132\0"+
    "\1\123\51\0\1\124\113\0\1\125\1\126\31\0\1\127"+
    "\113\0\1\130\77\0\2\131\70\0\1\132\101\0\1\133"+
    "\72\0\1\134\74\0\1\135\66\0\2\136\2\0\1\137"+
    "\75\0\1\140\71\0\1\141\71\0\1\142\53\0\1\143"+
    "\1\144\105\0\1\145\2\0\1\146\67\0\1\147\3\0"+
    "\1\150\101\0\1\151\44\0\1\152\70\0\1\153\73\0"+
    "\1\154\112\0\1\155\55\0\1\156\75\0\2\157\5\0"+
    "\1\160\27\0\1\112\67\0\6\113\1\161\71\113\1\162"+
    "\1\161\64\113\13\0\1\163\1\0\1\164\1\165\1\0"+
    "\1\166\104\0\1\167\72\0\1\170\10\0\2\171\62\0"+
    "\1\172\104\0\1\173\60\0\1\174\66\0\1\175\100\0"+
    "\1\176\77\0\2\177\65\0\2\200\43\0\1\201\127\0"+
    "\1\202\77\0\1\203\65\0\1\204\55\0\1\205\72\0"+
    "\1\206\71\0\1\207\75\0\1\210\67\0\1\211\46\0"+
    "\1\212\4\0\1\213\115\0\1\214\72\0\1\215\72\0"+
    "\1\216\72\0\1\217\103\0\1\220\60\0\1\221\67\0"+
    "\1\222\100\0\1\223\105\0\1\224\51\0\1\225\42\0"+
    "\5\113\1\112\1\161\64\113\13\0\4\226\63\0\1\226"+
    "\3\0\7\226\66\0\3\226\72\0\2\164\1\227\104\0"+
    "\1\230\102\0\2\231\75\0\1\232\70\0\1\233\100\0"+
    "\1\234\50\0\1\235\112\0\1\236\55\0\1\237\72\0"+
    "\1\240\73\0\1\241\1\0\2\242\7\0\1\243\1\0"+
    "\1\244\63\0\2\245\73\0\1\246\70\0\2\247\56\0"+
    "\1\250\105\0\2\251\57\0\1\252\107\0\1\253\71\0"+
    "\1\254\70\0\2\255\55\0\1\256\22\0\1\257\51\0"+
    "\1\260\73\0\1\261\71\0\1\262\112\0\1\263\66\0"+
    "\1\264\55\0\1\265\75\0\1\266\70\0\1\267\66\0"+
    "\1\50\64\0\3\226\103\0\1\270\75\0\1\271\110\0"+
    "\1\272\65\0\1\273\75\0\1\274\66\0\1\275\70\0"+
    "\2\276\37\0\1\277\134\0\1\300\47\0\1\301\12\0"+
    "\2\302\56\0\1\303\12\0\2\304\61\0\1\305\73\0"+
    "\1\306\72\0\1\307\75\0\2\310\102\0\1\311\56\0"+
    "\1\312\107\0\1\313\54\0\1\314\104\0\1\315\60\0"+
    "\1\316\72\0\1\317\50\0\1\320\115\0\1\321\47\0"+
    "\1\322\112\0\1\323\107\0\1\324\57\0\1\325\50\0"+
    "\1\326\111\0\1\327\72\0\1\330\75\0\1\331\67\0"+
    "\1\332\75\0\1\333\72\0\1\334\70\0\1\335\107\0"+
    "\1\336\71\0\1\337\74\0\1\340\74\0\1\341\51\0"+
    "\1\342\73\0\1\343\106\0\1\344\60\0\1\345\102\0"+
    "\2\346\56\0\1\347\110\0\1\350\62\0\1\351\65\0"+
    "\1\352\75\0\1\353\72\0\1\354\71\0\1\355\102\0"+
    "\2\356\73\0\1\357\111\0\1\360\37\0\1\200\72\0"+
    "\1\361\77\0\1\362\73\0\2\363\63\0\1\364\72\0"+
    "\1\365\75\0\1\366\104\0\1\367\77\0\1\370\53\0"+
    "\1\371\103\0\1\372\60\0\1\373\70\0\1\374\72\0"+
    "\1\375\72\0\1\376\72\0\1\377\75\0\1\u0100\71\0"+
    "\1\u0101\50\0\1\u0102\72\0\1\u0103\120\0\2\u0104\65\0"+
    "\1\u0105\112\0\1\u0106\47\0\1\u0107\107\0\1\u0108\70\0"+
    "\2\u0109\73\0\1\u010a\57\0\1\u010b\111\0\1\u010c\32\0"+
    "\1\u010d\111\0\1\u010e\73\0\1\u010f\111\0\1\u0110\65\0"+
    "\2\u0111\71\0\2\u0112\56\0\1\u0113\107\0\1\u0114\76\0"+
    "\1\u0115\55\0\1\u0116\72\0\1\u0117\67\0\1\u0118\106\0"+
    "\1\u0119\75\0\1\u011a\52\0\1\u011b\111\0\1\u011c\72\0"+
    "\1\u011d\74\0\1\u011e\52\0\1\u011f\106\0\1\u0120\60\0"+
    "\1\u0121\75\0\1\u0122\64\0\1\u0123\113\0\1\u0124\74\0"+
    "\1\u0125\72\0\1\u0126\47\0\1\u0127\75\0\1\u0128\76\0"+
    "\2\u0129\77\0\1\u012a\56\0\1\u012b\74\0\1\u012c\72\0"+
    "\1\u012d\70\0\1\u012e\112\0\1\u012f\55\0\1\u0130\74\0"+
    "\1\u0131\72\0\1\u0132\77\0\2\u0133\61\0\1\u0134\76\0"+
    "\2\u0135\66\0\1\u0136\74\0\1\u0137\34\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[14809];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\2\1\1\11\23\1\2\11\1\1\7\11"+
    "\1\1\6\0\1\11\10\0\1\11\4\0\2\11\16\0"+
    "\1\1\1\11\2\0\2\1\1\11\10\0\1\11\2\0"+
    "\1\1\5\0\1\11\10\0\1\11\7\0\1\1\14\0"+
    "\1\11\14\0\1\11\4\0\1\11\16\0\1\11\5\0"+
    "\1\11\11\0\1\1\1\0\1\1\3\0\1\1\1\11"+
    "\12\0\1\11\4\0\1\11\2\0\1\11\1\0\1\11"+
    "\4\0\1\11\13\0\1\11\6\0\1\11\12\0\1\11"+
    "\2\0\4\11\5\0\2\11\1\1\1\11\5\0\2\11"+
    "\4\0\1\11\4\0\1\11\3\0\1\11\3\0\1\11"+
    "\10\0\1\11\1\0\1\11\4\0\1\11\1\0\1\11"+
    "\7\0\2\11\2\0\3\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[311];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexico(java.io.Reader in) {
      yyline = 1;
    yychar = 1;
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 246) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { System.out.println("Error Lexico : " +yytext() + " Linea: " + yyline + 
        " Columna: " + yycolumn);
            } 
            // fall through
          case 67: break;
          case 2: 
            { /* ignore */
            } 
            // fall through
          case 68: break;
          case 3: 
            { return new Symbol(sym.DIVISION, yyline, yychar, yytext());
            } 
            // fall through
          case 69: break;
          case 4: 
            { return new Symbol(sym.MULTIPLICACION, yyline, yychar, yytext());
            } 
            // fall through
          case 70: break;
          case 5: 
            { return new Symbol(sym.LIT_NUMERO, yyline, yychar, yytext());
            } 
            // fall through
          case 71: break;
          case 6: 
            { return new Symbol(sym.RESTA, yyline, yychar, yytext());
            } 
            // fall through
          case 72: break;
          case 7: 
            { return new Symbol(sym.PUNTO_COMA);
            } 
            // fall through
          case 73: break;
          case 8: 
            { return new Symbol(sym.COMA, yyline, yychar, yytext());
            } 
            // fall through
          case 74: break;
          case 9: 
            { return new Symbol(sym.INTERROGACION_ABRE, yyline, yychar, yytext());
            } 
            // fall through
          case 75: break;
          case 10: 
            { return new Symbol(sym.INTERROGACION_CIERRA, yyline, yychar, yytext());
            } 
            // fall through
          case 76: break;
          case 11: 
            { return new Symbol(sym.SUMA, yyline, yychar, yytext());
            } 
            // fall through
          case 77: break;
          case 12: 
            { return new Symbol(sym.PARENTECIS_ABRE, yyline, yychar, yytext());
            } 
            // fall through
          case 78: break;
          case 13: 
            { return new Symbol(sym.PARENTECIS_CIERRA, yyline, yychar, yytext());
            } 
            // fall through
          case 79: break;
          case 14: 
            { return new Symbol(sym.CORCHETE_ABRE, yyline, yychar, yytext());
            } 
            // fall through
          case 80: break;
          case 15: 
            { return new Symbol(sym.CORCHETE_CIERRA, yyline, yychar, yytext());
            } 
            // fall through
          case 81: break;
          case 16: 
            { /*ignore*/
            } 
            // fall through
          case 82: break;
          case 17: 
            { return new Symbol(sym.LIT_CADENA, yyline, yychar, yytext());
            } 
            // fall through
          case 83: break;
          case 18: 
            { return new Symbol(sym.OR, yyline, yychar, yytext());
            } 
            // fall through
          case 84: break;
          case 19: 
            { return new Symbol(sym.SI, yyline, yychar, yytext());
            } 
            // fall through
          case 85: break;
          case 20: 
            { return new Symbol(sym.ASIGNACION, yyline, yychar, yytext());
            } 
            // fall through
          case 86: break;
          case 21: 
            { return new Symbol(sym.VARIABLE, yyline, yychar, yytext());
            } 
            // fall through
          case 87: break;
          case 22: 
            { return new Symbol(sym.LIT_CARACTER, yyline, yychar, yytext());
            } 
            // fall through
          case 88: break;
          case 23: 
            { return new Symbol(sym.AND, yyline, yychar, yytext());
            } 
            // fall through
          case 89: break;
          case 24: 
            { return new Symbol(sym.FIN, yyline, yychar, yytext());
            } 
            // fall through
          case 90: break;
          case 25: 
            { return new Symbol(sym.NOT, yyline, yychar, yytext());
            } 
            // fall through
          case 91: break;
          case 26: 
            { return new Symbol(sym.MODULO, yyline, yychar, yytext());
            } 
            // fall through
          case 92: break;
          case 27: 
            { return new Symbol(sym.O_SI, yyline, yychar, yytext());
            } 
            // fall through
          case 93: break;
          case 28: 
            { return new Symbol(sym.COMO, yyline, yychar, yytext());
            } 
            // fall through
          case 94: break;
          case 29: 
            { return new Symbol(sym.PARA, yyline, yychar, yytext());
            } 
            // fall through
          case 95: break;
          case 30: 
            { return new Symbol(sym.LIT_BOOLEAN, yyline, yychar, yytext());
            } 
            // fall through
          case 96: break;
          case 31: 
            { return new Symbol(sym.SEGUN, yyline, yychar, yytext());
            } 
            // fall through
          case 97: break;
          case 32: 
            { return new Symbol(sym.MENOR, yyline, yychar, yytext());
            } 
            // fall through
          case 98: break;
          case 33: 
            { return new Symbol(sym.MAYOR, yyline, yychar, yytext());
            } 
            // fall through
          case 99: break;
          case 34: 
            { return new Symbol(sym.HASTA, yyline, yychar, yytext());
            } 
            // fall through
          case 100: break;
          case 35: 
            { return new Symbol(sym.HACER, yyline, yychar, yytext());
            } 
            // fall through
          case 101: break;
          case 36: 
            { return new Symbol(sym.FIN_SI, yyline, yychar, yytext());
            } 
            // fall through
          case 102: break;
          case 37: 
            { return new Symbol(sym.INICIO,yyline,yychar, yytext());
            } 
            // fall through
          case 103: break;
          case 38: 
            { return new Symbol(sym.NUMERO, yyline, yychar, yytext());
            } 
            // fall through
          case 104: break;
          case 39: 
            { return new Symbol(sym.CADENA, yyline, yychar, yytext());
            } 
            // fall through
          case 105: break;
          case 40: 
            { return new Symbol(sym.METODO, yyline, yychar, yytext());
            } 
            // fall through
          case 106: break;
          case 41: 
            { return new Symbol(sym.REPETIR, yyline, yychar, yytext());
            } 
            // fall through
          case 107: break;
          case 42: 
            { return new Symbol(sym.FUNCION, yyline, yychar, yytext());
            } 
            // fall through
          case 108: break;
          case 43: 
            { return new Symbol(sym.BOOLEAN, yyline, yychar, yytext());
            } 
            // fall through
          case 109: break;
          case 44: 
            { return new Symbol(sym.ES_IGUAL, yyline, yychar, yytext());
            } 
            // fall through
          case 110: break;
          case 45: 
            { return new Symbol(sym.ENTONCES, yyline, yychar, yytext());
            } 
            // fall through
          case 111: break;
          case 46: 
            { return new Symbol(sym.EJECUTAR, yyline, yychar, yytext());
            } 
            // fall through
          case 112: break;
          case 47: 
            { return new Symbol(sym.RETORNAR, yyline, yychar, yytext());
            } 
            // fall through
          case 113: break;
          case 48: 
            { return new Symbol(sym.FIN_PARA, yyline, yychar, yytext());
            } 
            // fall through
          case 114: break;
          case 49: 
            { return new Symbol(sym.INGRESAR, yyline, yychar, yytext());
            } 
            // fall through
          case 115: break;
          case 50: 
            { return new Symbol(sym.IMPRIMIR, yyline, yychar, yytext());
            } 
            // fall through
          case 116: break;
          case 51: 
            { return new Symbol(sym.CARACTER, yyline, yychar, yytext());
            } 
            // fall through
          case 117: break;
          case 52: 
            { return new Symbol(sym.MIENTRAS, yyline, yychar, yytext());
            } 
            // fall through
          case 118: break;
          case 53: 
            { return new Symbol(sym.POTENCIA, yyline, yychar, yytext());
            } 
            // fall through
          case 119: break;
          case 54: 
            { return new Symbol(sym.FIN_SEGUN, yyline, yychar, yytext());
            } 
            // fall through
          case 120: break;
          case 55: 
            { return new Symbol(sym.CON_VALOR, yyline, yychar, yytext());
            } 
            // fall through
          case 121: break;
          case 56: 
            { return new Symbol(sym.HASTA_QUE, yyline, yychar, yytext());
            } 
            // fall through
          case 122: break;
          case 57: 
            { return new Symbol(sym.FIN_METODO, yyline, yychar, yytext());
            } 
            // fall through
          case 123: break;
          case 58: 
            { return new Symbol(sym.FIN_FUNCION, yyline, yychar, yytext());
            } 
            // fall through
          case 124: break;
          case 59: 
            { return new Symbol(sym.IMPRIMIR_NL, yyline, yychar, yytext());
            } 
            // fall through
          case 125: break;
          case 60: 
            { return new Symbol(sym.ES_DIFERENTE, yyline, yychar, yytext());
            } 
            // fall through
          case 126: break;
          case 61: 
            { return new Symbol(sym.FIN_MIENTRAS, yyline, yychar, yytext());
            } 
            // fall through
          case 127: break;
          case 62: 
            { return new Symbol(sym.MENOR_O_IGUAL, yyline, yychar, yytext());
            } 
            // fall through
          case 128: break;
          case 63: 
            { return new Symbol(sym.MAYOR_O_IGUAL, yyline, yychar, yytext());
            } 
            // fall through
          case 129: break;
          case 64: 
            { return new Symbol(sym.CON_PARAMETROS, yyline, yychar, yytext());
            } 
            // fall through
          case 130: break;
          case 65: 
            { return new Symbol(sym.DE_LO_CONTRARIO, yyline, yychar, yytext());
            } 
            // fall through
          case 131: break;
          case 66: 
            { return new Symbol(sym.CON_INCREMENTAL, yyline, yychar, yytext());
            } 
            // fall through
          case 132: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
