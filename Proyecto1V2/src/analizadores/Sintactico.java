
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analizadores;

import Estructuras.Produccion;
import Estructuras.Nodo;
import Estructuras.Arbol;
import Estructuras.Instrucciones.Instruccion;
import Estructuras.Instrucciones.Operacion;
import Estructuras.Instrucciones.Evaluar;
import java.util.LinkedList;
import java_cup.runtime.*;
import java_cup.runtime.XMLElement;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Sintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Sintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Sintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Sintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\010\000\002\002\004\000\002\002\005\000\002\002" +
    "\004\000\002\003\004\000\002\003\003\000\002\005\004" +
    "\000\002\016\005\000\002\016\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\016\000\004\004\005\001\002\000\004\002\020\001" +
    "\002\000\006\005\011\072\010\001\002\000\006\005\017" +
    "\072\010\001\002\000\006\005\ufffd\072\ufffd\001\002\000" +
    "\006\066\ufffa\071\ufffa\001\002\000\004\002\uffff\001\002" +
    "\000\006\066\013\071\014\001\002\000\006\005\ufffc\072" +
    "\ufffc\001\002\000\004\072\010\001\002\000\006\066\ufffb" +
    "\071\ufffb\001\002\000\006\005\ufffe\072\ufffe\001\002\000" +
    "\004\002\000\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\016\000\004\002\003\001\001\000\002\001\001\000" +
    "\010\003\005\005\006\016\011\001\001\000\006\005\015" +
    "\016\011\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\016\014\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Sintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Sintactico$actions(this);
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
    return action_obj.CUP$Sintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public LinkedList<Instruccion> AST;
    public Arbol arbol;

    public void syntax_error(Symbol s){
            System.err.println("Error Sintáctico en la linea: " + (s.left) + " y columna : " + s.right + ". No se esperaba este token: " + s.value + "."); 
    } 

    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{ 
            System.err.println("Error síntactico irrecuperable en la línea " + (s.left) + " y columna " + s.right + ". Componente " + s.value + " no reconocido."); 
    }  

    public Arbol getArbol() {
        return arbol;
    }
    
    public LinkedList<Instruccion> getAST() {
        return AST;
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Sintactico$actions {
  private final Sintactico parser;

  /** Constructor */
  CUP$Sintactico$actions(Sintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action_part00000000(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Sintactico$result;

      /* select the action based on the action number */
      switch (CUP$Sintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= iniciar EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		RESULT = start_val;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Sintactico$parser.done_parsing();
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // iniciar ::= INICIO lista_instrucciones FIN 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Produccion a = (Produccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		
                                                   
                                                    parser.AST = a.getInstrucciones();
                                                    Nodo nodoRaiz = new Nodo("Iniciar"); nodoRaiz.addHijo(a.getNodo());
                                                    parser.arbol = new Arbol(nodoRaiz);
                                                
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("iniciar",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // iniciar ::= INICIO FIN 
            {
              Object RESULT =null;
		 System.out.println("No hay intrucciones que procesar."); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("iniciar",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // lista_instrucciones ::= lista_instrucciones instrucciones 
            {
              Produccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Produccion a = (Produccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Produccion b = (Produccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 
                                                                    RESULT = new Produccion(new Nodo("Lista Instrucciones"), a.getInstrucciones());
                                                                    RESULT.addInstruccion(b.getInstruccion());
                                                                    RESULT.addHijo(a);
                                                                    RESULT.addHijo(b);
                                                                
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("lista_instrucciones",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // lista_instrucciones ::= instrucciones 
            {
              Produccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Produccion a = (Produccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 
                                            RESULT = new Produccion(new Nodo("Instrucciones"), new LinkedList<>()); 
                                            RESULT.addInstruccion(a.getInstruccion());
                                            RESULT.addHijo(a);
                                        
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("lista_instrucciones",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // instrucciones ::= expresion PUNTO_COMA 
            {
              Produccion RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Produccion e = (Produccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		 
                                RESULT = new Produccion(new Nodo("Instruccion"), new Evaluar((Operacion)e.getInstruccion()));
                                RESULT.addHijo(e);
                                RESULT.addHijo(";");
                            
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("instrucciones",3, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // expresion ::= expresion SUMA expresion 
            {
              Produccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Produccion a = (Produccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Produccion b = (Produccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		
                                                RESULT = new Produccion(new Nodo("Expresion"), new Operacion((Operacion)a.getInstruccion(), (Operacion)b.getInstruccion(), Operacion.TipoOperacion.SUMA));
                                                RESULT.addHijo(a);
                                                RESULT.addHijo("+");
                                                RESULT.addHijo(b);
                                            
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",12, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expresion ::= LIT_NUMERO 
            {
              Produccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 
                        RESULT = new Produccion(new Nodo(null, a), new Operacion(a, Operacion.TipoOperacion.NUMERO)); 

                    
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",12, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Sintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
              return CUP$Sintactico$do_action_part00000000(
                               CUP$Sintactico$act_num,
                               CUP$Sintactico$parser,
                               CUP$Sintactico$stack,
                               CUP$Sintactico$top);
    }
}

}
