
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analizadores;

import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class AnalizadorSintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public AnalizadorSintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public AnalizadorSintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\046\000\002\002\005\000\002\002\004\000\002\002" +
    "\004\000\002\003\004\000\002\003\003\000\002\007\003" +
    "\000\002\007\003\000\002\007\003\000\002\005\003\000" +
    "\002\005\003\000\002\005\003\000\002\005\003\000\002" +
    "\006\003\000\002\006\003\000\002\006\003\000\002\006" +
    "\003\000\002\013\003\000\002\013\003\000\002\013\003" +
    "\000\002\013\003\000\002\004\011\000\002\004\011\000" +
    "\002\004\011\000\002\004\011\000\002\010\006\000\002" +
    "\012\003\000\002\012\003\000\002\012\003\000\002\012" +
    "\003\000\002\012\003\000\002\012\003\000\002\014\005" +
    "\000\002\014\003\000\002\011\007\000\002\011\011\000" +
    "\002\011\012\000\002\015\007\000\002\015\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\110\000\004\004\005\001\002\000\004\002\112\001" +
    "\002\000\012\005\006\006\014\007\010\032\016\001\002" +
    "\000\004\002\uffff\001\002\000\020\005\ufffa\006\ufffa\007" +
    "\ufffa\032\ufffa\033\ufffa\034\ufffa\036\ufffa\001\002\000\004" +
    "\031\103\001\002\000\020\005\ufffb\006\ufffb\007\ufffb\032" +
    "\ufffb\033\ufffb\034\ufffb\036\ufffb\001\002\000\012\005\ufffd" +
    "\006\ufffd\007\ufffd\032\ufffd\001\002\000\020\005\ufffc\006" +
    "\ufffc\007\ufffc\032\ufffc\033\ufffc\034\ufffc\036\ufffc\001\002" +
    "\000\004\007\061\001\002\000\012\005\057\006\014\007" +
    "\010\032\016\001\002\000\012\007\024\016\022\026\023" +
    "\027\021\001\002\000\020\017\033\020\032\021\025\022" +
    "\027\023\034\024\030\035\031\001\002\000\020\017\uffe1" +
    "\020\uffe1\021\uffe1\022\uffe1\023\uffe1\024\uffe1\035\uffe1\001" +
    "\002\000\020\017\uffef\020\uffef\021\uffef\022\uffef\023\uffef" +
    "\024\uffef\035\uffef\001\002\000\020\017\ufff1\020\ufff1\021" +
    "\ufff1\022\ufff1\023\ufff1\024\ufff1\035\ufff1\001\002\000\020" +
    "\017\ufff0\020\ufff0\021\ufff0\022\ufff0\023\ufff0\024\ufff0\035" +
    "\ufff0\001\002\000\020\017\uffee\020\uffee\021\uffee\022\uffee" +
    "\023\uffee\024\uffee\035\uffee\001\002\000\012\007\uffe6\016" +
    "\uffe6\026\uffe6\027\uffe6\001\002\000\012\007\024\016\022" +
    "\026\023\027\021\001\002\000\012\007\uffe5\016\uffe5\026" +
    "\uffe5\027\uffe5\001\002\000\012\007\uffe3\016\uffe3\026\uffe3" +
    "\027\uffe3\001\002\000\010\006\014\007\010\032\016\001" +
    "\002\000\012\007\uffe7\016\uffe7\026\uffe7\027\uffe7\001\002" +
    "\000\012\007\uffe8\016\uffe8\026\uffe8\027\uffe8\001\002\000" +
    "\012\007\uffe4\016\uffe4\026\uffe4\027\uffe4\001\002\000\010" +
    "\033\036\034\040\036\037\001\002\000\020\005\uffe0\006" +
    "\uffe0\007\uffe0\032\uffe0\033\uffe0\034\uffe0\036\uffe0\001\002" +
    "\000\010\006\014\007\010\032\016\001\002\000\012\007" +
    "\024\016\022\026\023\027\021\001\002\000\006\034\043" +
    "\036\042\001\002\000\010\006\014\007\010\032\016\001" +
    "\002\000\012\007\024\016\022\026\023\027\021\001\002" +
    "\000\020\017\033\020\032\021\025\022\027\023\034\024" +
    "\030\035\045\001\002\000\010\006\014\007\010\032\016" +
    "\001\002\000\006\034\uffdd\036\uffdd\001\002\000\004\033" +
    "\050\001\002\000\020\005\uffde\006\uffde\007\uffde\032\uffde" +
    "\033\uffde\034\uffde\036\uffde\001\002\000\020\017\033\020" +
    "\032\021\025\022\027\023\034\024\030\035\052\001\002" +
    "\000\010\006\014\007\010\032\016\001\002\000\006\034" +
    "\uffdc\036\uffdc\001\002\000\004\033\055\001\002\000\020" +
    "\005\uffdf\006\uffdf\007\uffdf\032\uffdf\033\uffdf\034\uffdf\036" +
    "\uffdf\001\002\000\020\017\uffe2\020\uffe2\021\uffe2\022\uffe2" +
    "\023\uffe2\024\uffe2\035\uffe2\001\002\000\004\002\001\001" +
    "\002\000\012\005\ufffe\006\ufffe\007\ufffe\032\ufffe\001\002" +
    "\000\004\010\062\001\002\000\012\012\065\013\063\014" +
    "\064\015\066\001\002\000\004\011\100\001\002\000\004" +
    "\011\075\001\002\000\004\011\072\001\002\000\004\011" +
    "\067\001\002\000\004\027\070\001\002\000\004\025\071" +
    "\001\002\000\020\005\uffeb\006\uffeb\007\uffeb\032\uffeb\033" +
    "\uffeb\034\uffeb\036\uffeb\001\002\000\004\030\073\001\002" +
    "\000\004\025\074\001\002\000\020\005\uffea\006\uffea\007" +
    "\uffea\032\uffea\033\uffea\034\uffea\036\uffea\001\002\000\004" +
    "\026\076\001\002\000\004\025\077\001\002\000\020\005" +
    "\uffec\006\uffec\007\uffec\032\uffec\033\uffec\034\uffec\036\uffec" +
    "\001\002\000\004\016\101\001\002\000\004\025\102\001" +
    "\002\000\020\005\uffed\006\uffed\007\uffed\032\uffed\033\uffed" +
    "\034\uffed\036\uffed\001\002\000\012\016\106\026\107\027" +
    "\105\030\110\001\002\000\004\025\111\001\002\000\004" +
    "\025\ufff3\001\002\000\004\025\ufff5\001\002\000\004\025" +
    "\ufff4\001\002\000\004\025\ufff2\001\002\000\020\005\uffe9" +
    "\006\uffe9\007\uffe9\032\uffe9\033\uffe9\034\uffe9\036\uffe9\001" +
    "\002\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\110\000\004\002\003\001\001\000\002\001\001\000" +
    "\014\003\014\004\012\007\011\010\010\011\006\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\012\004\012\007\057\010\010\011\006\001" +
    "\001\000\006\013\017\014\016\001\001\000\004\012\025" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\013\055\001\001\000\002\001\001\000\002\001" +
    "\001\000\012\004\012\007\034\010\010\011\006\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\015\040\001\001\000\002\001\001\000\012\004\012" +
    "\007\053\010\010\011\006\001\001\000\006\013\017\014" +
    "\050\001\001\000\002\001\001\000\012\004\012\007\046" +
    "\010\010\011\006\001\001\000\006\013\017\014\043\001" +
    "\001\000\004\012\025\001\001\000\012\004\012\007\045" +
    "\010\010\011\006\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\012\025\001\001\000\012" +
    "\004\012\007\052\010\010\011\006\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\006\103\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public String codigoTraducido = "";


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$AnalizadorSintactico$actions {
  private final AnalizadorSintactico parser;

  /** Constructor */
  CUP$AnalizadorSintactico$actions(AnalizadorSintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintactico$do_action_part00000000(
    int                        CUP$AnalizadorSintactico$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintactico$parser,
    java.util.Stack            CUP$AnalizadorSintactico$stack,
    int                        CUP$AnalizadorSintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintactico$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // iniciar ::= INICIO lista_expresiones FIN 
            {
              Object RESULT =null;
		 System.out.println("codigo traducido");
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("iniciar",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= iniciar EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintactico$parser.done_parsing();
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // iniciar ::= INICIO FIN 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("iniciar",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // lista_expresiones ::= lista_expresiones expresion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("lista_expresiones",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // lista_expresiones ::= expresion 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 System.out.println(e);
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("lista_expresiones",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // expresion ::= declaracion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // expresion ::= asignacion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expresion ::= condicionales 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // tipo_dato ::= BOOLEAN 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("tipo_dato",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // tipo_dato ::= NUMERO 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("tipo_dato",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // tipo_dato ::= CARACTER 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("tipo_dato",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // tipo_dato ::= CADENA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("tipo_dato",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // literal ::= LIT_NUMERO 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // literal ::= LIT_CARACTER 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // literal ::= LIT_CADENA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // literal ::= LIT_BOOLEAN 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // literal_booleana ::= LIT_NUMERO 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal_booleana",9, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // literal_booleana ::= LIT_CARACTER 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal_booleana",9, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // literal_booleana ::= LIT_CADENA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal_booleana",9, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // literal_booleana ::= VARIABLE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal_booleana",9, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // declaracion ::= INGRESAR VARIABLE COMO NUMERO CON_VALOR LIT_NUMERO PUNTO_COMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("declaracion",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-6)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // declaracion ::= INGRESAR VARIABLE COMO CARACTER CON_VALOR LIT_CARACTER PUNTO_COMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("declaracion",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-6)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // declaracion ::= INGRESAR VARIABLE COMO CADENA CON_VALOR LIT_CADENA PUNTO_COMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("declaracion",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-6)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // declaracion ::= INGRESAR VARIABLE COMO BOOLEAN CON_VALOR LIT_BOOLEAN PUNTO_COMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("declaracion",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-6)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // asignacion ::= VARIABLE ASIGNACION literal PUNTO_COMA 
            {
              Object RESULT =null;
		 System.out.println("Reconoci una asignacion");
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("asignacion",6, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // operador ::= MAYOR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("operador",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // operador ::= MENOR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("operador",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // operador ::= MAYOR_O_IGUAL 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("operador",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // operador ::= MENOR_O_IGUAL 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("operador",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // operador ::= ES_IGUAL 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("operador",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // operador ::= ES_DIFERENTE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("operador",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // expresion_booleana ::= expresion_booleana operador literal_booleana 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expresion_booleana",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // expresion_booleana ::= literal_booleana 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expresion_booleana",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // condicionales ::= SI expresion_booleana ENTONCES expresion FIN_SI 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("condicionales",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-4)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // condicionales ::= SI expresion_booleana ENTONCES expresion DE_LO_CONTRARIO expresion FIN_SI 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("condicionales",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-6)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // condicionales ::= SI expresion_booleana ENTONCES expresion osi DE_LO_CONTRARIO expresion FIN_SI 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("condicionales",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-7)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // osi ::= osi O_SI expresion_booleana ENTONCES expresion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("osi",11, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-4)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // osi ::= O_SI expresion_booleana ENTONCES expresion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("osi",11, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$AnalizadorSintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintactico$do_action(
    int                        CUP$AnalizadorSintactico$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintactico$parser,
    java.util.Stack            CUP$AnalizadorSintactico$stack,
    int                        CUP$AnalizadorSintactico$top)
    throws java.lang.Exception
    {
              return CUP$AnalizadorSintactico$do_action_part00000000(
                               CUP$AnalizadorSintactico$act_num,
                               CUP$AnalizadorSintactico$parser,
                               CUP$AnalizadorSintactico$stack,
                               CUP$AnalizadorSintactico$top);
    }
}

}
