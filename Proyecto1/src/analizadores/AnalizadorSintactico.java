
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
    "\000\051\000\002\002\005\000\002\002\004\000\002\002" +
    "\004\000\002\003\004\000\002\003\003\000\002\007\003" +
    "\000\002\007\003\000\002\007\003\000\002\007\003\000" +
    "\002\005\003\000\002\005\003\000\002\005\003\000\002" +
    "\005\003\000\002\006\003\000\002\006\003\000\002\006" +
    "\003\000\002\006\003\000\002\013\003\000\002\013\003" +
    "\000\002\013\003\000\002\013\003\000\002\004\011\000" +
    "\002\004\011\000\002\004\011\000\002\004\011\000\002" +
    "\010\006\000\002\012\003\000\002\012\003\000\002\012" +
    "\003\000\002\012\003\000\002\012\003\000\002\012\003" +
    "\000\002\014\005\000\002\014\003\000\002\011\007\000" +
    "\002\011\011\000\002\011\012\000\002\015\007\000\002" +
    "\015\006\000\002\016\005\000\002\016\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\117\000\004\004\005\001\002\000\004\002\121\001" +
    "\002\000\016\005\010\006\016\007\011\027\020\030\006" +
    "\035\021\001\002\000\012\007\027\016\026\031\025\032" +
    "\024\001\002\000\024\005\ufffa\006\ufffa\007\ufffa\027\ufffa" +
    "\030\ufffa\035\ufffa\036\ufffa\037\ufffa\041\ufffa\001\002\000" +
    "\004\002\uffff\001\002\000\004\034\110\001\002\000\024" +
    "\005\ufff9\006\ufff9\007\ufff9\027\ufff9\030\ufff9\035\ufff9\036" +
    "\ufff9\037\ufff9\041\ufff9\001\002\000\024\005\ufffb\006\ufffb" +
    "\007\ufffb\027\ufffb\030\ufffb\035\ufffb\036\ufffb\037\ufffb\041" +
    "\ufffb\001\002\000\016\005\ufffd\006\ufffd\007\ufffd\027\ufffd" +
    "\030\ufffd\035\ufffd\001\002\000\024\005\ufffc\006\ufffc\007" +
    "\ufffc\027\ufffc\030\ufffc\035\ufffc\036\ufffc\037\ufffc\041\ufffc" +
    "\001\002\000\004\007\066\001\002\000\016\005\064\006" +
    "\016\007\011\027\020\030\006\035\021\001\002\000\012" +
    "\007\027\016\026\031\025\032\024\001\002\000\012\007" +
    "\027\016\026\031\025\032\024\001\002\000\020\017\036" +
    "\020\035\021\031\022\032\023\037\024\033\040\034\001" +
    "\002\000\020\017\uffe0\020\uffe0\021\uffe0\022\uffe0\023\uffe0" +
    "\024\uffe0\040\uffe0\001\002\000\022\017\uffee\020\uffee\021" +
    "\uffee\022\uffee\023\uffee\024\uffee\025\uffee\040\uffee\001\002" +
    "\000\022\017\uffef\020\uffef\021\uffef\022\uffef\023\uffef\024" +
    "\uffef\025\uffef\040\uffef\001\002\000\022\017\ufff0\020\ufff0" +
    "\021\ufff0\022\ufff0\023\ufff0\024\ufff0\025\ufff0\040\ufff0\001" +
    "\002\000\022\017\uffed\020\uffed\021\uffed\022\uffed\023\uffed" +
    "\024\uffed\025\uffed\040\uffed\001\002\000\012\007\027\016" +
    "\026\031\025\032\024\001\002\000\012\007\uffe5\016\uffe5" +
    "\031\uffe5\032\uffe5\001\002\000\012\007\uffe4\016\uffe4\031" +
    "\uffe4\032\uffe4\001\002\000\012\007\uffe2\016\uffe2\031\uffe2" +
    "\032\uffe2\001\002\000\014\006\016\007\011\027\020\030" +
    "\006\035\021\001\002\000\012\007\uffe6\016\uffe6\031\uffe6" +
    "\032\uffe6\001\002\000\012\007\uffe7\016\uffe7\031\uffe7\032" +
    "\uffe7\001\002\000\012\007\uffe3\016\uffe3\031\uffe3\032\uffe3" +
    "\001\002\000\010\036\041\037\043\041\042\001\002\000" +
    "\024\005\uffdf\006\uffdf\007\uffdf\027\uffdf\030\uffdf\035\uffdf" +
    "\036\uffdf\037\uffdf\041\uffdf\001\002\000\014\006\016\007" +
    "\011\027\020\030\006\035\021\001\002\000\012\007\027" +
    "\016\026\031\025\032\024\001\002\000\006\037\046\041" +
    "\045\001\002\000\014\006\016\007\011\027\020\030\006" +
    "\035\021\001\002\000\012\007\027\016\026\031\025\032" +
    "\024\001\002\000\020\017\036\020\035\021\031\022\032" +
    "\023\037\024\033\040\050\001\002\000\014\006\016\007" +
    "\011\027\020\030\006\035\021\001\002\000\006\037\uffdc" +
    "\041\uffdc\001\002\000\004\036\053\001\002\000\024\005" +
    "\uffdd\006\uffdd\007\uffdd\027\uffdd\030\uffdd\035\uffdd\036\uffdd" +
    "\037\uffdd\041\uffdd\001\002\000\020\017\036\020\035\021" +
    "\031\022\032\023\037\024\033\040\055\001\002\000\014" +
    "\006\016\007\011\027\020\030\006\035\021\001\002\000" +
    "\006\037\uffdb\041\uffdb\001\002\000\004\036\060\001\002" +
    "\000\024\005\uffde\006\uffde\007\uffde\027\uffde\030\uffde\035" +
    "\uffde\036\uffde\037\uffde\041\uffde\001\002\000\020\017\uffe1" +
    "\020\uffe1\021\uffe1\022\uffe1\023\uffe1\024\uffe1\040\uffe1\001" +
    "\002\000\004\025\063\001\002\000\024\005\uffda\006\uffda" +
    "\007\uffda\027\uffda\030\uffda\035\uffda\036\uffda\037\uffda\041" +
    "\uffda\001\002\000\004\002\001\001\002\000\016\005\ufffe" +
    "\006\ufffe\007\ufffe\027\ufffe\030\ufffe\035\ufffe\001\002\000" +
    "\004\010\067\001\002\000\012\012\072\013\070\014\071" +
    "\015\073\001\002\000\004\011\105\001\002\000\004\011" +
    "\102\001\002\000\004\011\077\001\002\000\004\011\074" +
    "\001\002\000\004\032\075\001\002\000\004\025\076\001" +
    "\002\000\024\005\uffea\006\uffea\007\uffea\027\uffea\030\uffea" +
    "\035\uffea\036\uffea\037\uffea\041\uffea\001\002\000\004\033" +
    "\100\001\002\000\004\025\101\001\002\000\024\005\uffe9" +
    "\006\uffe9\007\uffe9\027\uffe9\030\uffe9\035\uffe9\036\uffe9\037" +
    "\uffe9\041\uffe9\001\002\000\004\031\103\001\002\000\004" +
    "\025\104\001\002\000\024\005\uffeb\006\uffeb\007\uffeb\027" +
    "\uffeb\030\uffeb\035\uffeb\036\uffeb\037\uffeb\041\uffeb\001\002" +
    "\000\004\016\106\001\002\000\004\025\107\001\002\000" +
    "\024\005\uffec\006\uffec\007\uffec\027\uffec\030\uffec\035\uffec" +
    "\036\uffec\037\uffec\041\uffec\001\002\000\012\016\114\031" +
    "\113\032\112\033\115\001\002\000\004\025\116\001\002" +
    "\000\004\025\ufff2\001\002\000\004\025\ufff3\001\002\000" +
    "\004\025\ufff4\001\002\000\004\025\ufff1\001\002\000\024" +
    "\005\uffe8\006\uffe8\007\uffe8\027\uffe8\030\uffe8\035\uffe8\036" +
    "\uffe8\037\uffe8\041\uffe8\001\002\000\004\025\120\001\002" +
    "\000\024\005\uffd9\006\uffd9\007\uffd9\027\uffd9\030\uffd9\035" +
    "\uffd9\036\uffd9\037\uffd9\041\uffd9\001\002\000\004\002\000" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\117\000\004\002\003\001\001\000\002\001\001\000" +
    "\016\003\016\004\014\007\013\010\012\011\006\016\011" +
    "\001\001\000\004\013\116\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\014\004\014\007\064\010\012\011\006\016\011" +
    "\001\001\000\004\013\061\001\001\000\006\013\022\014" +
    "\021\001\001\000\004\012\027\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\013\060\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\014\004\014\007" +
    "\037\010\012\011\006\016\011\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\015\043\001" +
    "\001\000\002\001\001\000\014\004\014\007\056\010\012" +
    "\011\006\016\011\001\001\000\006\013\022\014\053\001" +
    "\001\000\002\001\001\000\014\004\014\007\051\010\012" +
    "\011\006\016\011\001\001\000\006\013\022\014\046\001" +
    "\001\000\004\012\027\001\001\000\014\004\014\007\050" +
    "\010\012\011\006\016\011\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\012\027\001\001" +
    "\000\014\004\014\007\055\010\012\011\006\016\011\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\006\110\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001" });

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
          case 8: // expresion ::= imprimir 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // tipo_dato ::= BOOLEAN 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("tipo_dato",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // tipo_dato ::= NUMERO 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("tipo_dato",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // tipo_dato ::= CARACTER 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("tipo_dato",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // tipo_dato ::= CADENA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("tipo_dato",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // literal ::= LIT_NUMERO 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // literal ::= LIT_CARACTER 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // literal ::= LIT_CADENA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // literal ::= LIT_BOOLEAN 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // literal_booleana ::= LIT_NUMERO 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal_booleana",9, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // literal_booleana ::= LIT_CARACTER 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal_booleana",9, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // literal_booleana ::= LIT_CADENA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal_booleana",9, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // literal_booleana ::= VARIABLE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("literal_booleana",9, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // declaracion ::= INGRESAR VARIABLE COMO NUMERO CON_VALOR LIT_NUMERO PUNTO_COMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("declaracion",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-6)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // declaracion ::= INGRESAR VARIABLE COMO CARACTER CON_VALOR LIT_CARACTER PUNTO_COMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("declaracion",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-6)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // declaracion ::= INGRESAR VARIABLE COMO CADENA CON_VALOR LIT_CADENA PUNTO_COMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("declaracion",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-6)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // declaracion ::= INGRESAR VARIABLE COMO BOOLEAN CON_VALOR LIT_BOOLEAN PUNTO_COMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("declaracion",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-6)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // asignacion ::= VARIABLE ASIGNACION literal PUNTO_COMA 
            {
              Object RESULT =null;
		 System.out.println("Reconoci una asignacion");
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("asignacion",6, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // operador ::= MAYOR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("operador",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // operador ::= MENOR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("operador",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // operador ::= MAYOR_O_IGUAL 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("operador",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // operador ::= MENOR_O_IGUAL 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("operador",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // operador ::= ES_IGUAL 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("operador",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // operador ::= ES_DIFERENTE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("operador",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // expresion_booleana ::= expresion_booleana operador literal_booleana 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expresion_booleana",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // expresion_booleana ::= literal_booleana 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expresion_booleana",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // condicionales ::= SI expresion_booleana ENTONCES expresion FIN_SI 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("condicionales",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-4)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // condicionales ::= SI expresion_booleana ENTONCES expresion DE_LO_CONTRARIO expresion FIN_SI 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("condicionales",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-6)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // condicionales ::= SI expresion_booleana ENTONCES expresion osi DE_LO_CONTRARIO expresion FIN_SI 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("condicionales",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-7)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // osi ::= osi O_SI expresion_booleana ENTONCES expresion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("osi",11, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-4)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // osi ::= O_SI expresion_booleana ENTONCES expresion 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("osi",11, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // imprimir ::= IMPRIMIR literal_booleana PUNTO_COMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("imprimir",12, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // imprimir ::= IMPRIMIR_NL literal_booleana PUNTO_COMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("imprimir",12, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
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
