/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

/**
 *
 * @author ormandyrony
 */
public class Operacion implements Instruccion {

    
    public static enum TipoOperacion {
        // Tipo Operacion Golan
         CON_PARENTECIS_GO,
        VARIABLE_GO,
        // TIPOS DE DATO
        NUMERO_GO,
        CADENA_GO,
        CARACTER_GO,
        BOOLEAN_GO,
        // Fuciones
        IMPRIMIR_GO,
        POTENCIA_GO,
        MODULO_GO,
        // Operadores RELACIONALES
        MAYOR_GO,
        MENOR_GO,
        MAYOR_O_IGUAL_GO,
        MENOR_O_IGUAL_GO,
        ES_IGUAL_GO,
        ES_DIFERENTE_GO,
        // Operadores logicos
        AND_GO,
        OR_GO,
        NOT_GO,
        
        // Operadores aritmeticos
        DIVISION_GO,
        MULTIPLICACION_GO,
        RESTA_GO,
        SUMA_GO,
       
        
         // Tipo Operacion Python
        
        CON_PARENTECIS,
        VARIABLE,
        // TIPOS DE DATO
        NUMERO,
        CADENA,
        CARACTER,
        BOOLEAN,
        // Fuciones
        IMPRIMIR,
        POTENCIA,
        MODULO,
        // Operadores RELACIONALES
        MAYOR,
        MENOR,
        MAYOR_O_IGUAL,
        MENOR_O_IGUAL,
        ES_IGUAL,
        ES_DIFERENTE,
        // Operadores logicos
        AND,
        OR,
        NOT,
        
        // Operadores aritmeticos
        DIVISION,
        MULTIPLICACION,
        RESTA,
        SUMA
      
    }
    
    private final TipoOperacion tipo;
    private Operacion operadorIzq;
    private Operacion operadorDer;
    private Object valor;
    
    public Operacion(Operacion operadorIzq, Operacion operadorDer, TipoOperacion tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
    }
    
    public Operacion(Operacion operadorIzq, TipoOperacion tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
    }
    
    public Operacion(String a, TipoOperacion tipo) {
        this.valor=a;
        this.tipo = tipo;
    }
    
    @Override
    public String traducir() {
        // Operadores aritmeticos
        if (tipo == TipoOperacion.SUMA) {
            return operadorIzq.traducir() + "+" + operadorDer.traducir();
        } else if (tipo == TipoOperacion.RESTA) {
            return operadorIzq.traducir() + "-" + operadorDer.traducir();
        } else if (tipo == TipoOperacion.MULTIPLICACION) {
            return operadorIzq.traducir() + "*" + operadorDer.traducir();
        } else if (tipo == TipoOperacion.DIVISION) {
            return operadorIzq.traducir() + "/" + operadorDer.traducir();
        } else if (tipo == TipoOperacion.CON_PARENTECIS) {
            return "(" + operadorIzq.traducir() + ")";
        } 
        // Funciones
        else if (tipo == TipoOperacion.POTENCIA) {
            return operadorIzq.traducir() + "**" + operadorDer.traducir();
        } else if (tipo == TipoOperacion.MODULO) {
            return operadorIzq.traducir() + " % " + operadorDer.traducir();
        }
        // Operadores relacionales
        else if (tipo == TipoOperacion.MAYOR) {
            return operadorIzq.traducir() + " > " + operadorDer.traducir();
        } else if (tipo == TipoOperacion.MENOR) {
            return operadorIzq.traducir() + " < " + operadorDer.traducir();
        } else if (tipo == TipoOperacion.MAYOR_O_IGUAL) {
            return operadorIzq.traducir() + " >= " + operadorDer.traducir();
        } else if (tipo == TipoOperacion.MENOR_O_IGUAL) {
            return operadorIzq.traducir() + " <= " + operadorDer.traducir();
        }else if (tipo == TipoOperacion.ES_IGUAL) {
            return operadorIzq.traducir() + " == " + operadorDer.traducir();
        } else if (tipo == TipoOperacion.ES_DIFERENTE) {
            return operadorIzq.traducir() + " !="  + operadorDer.traducir();
        }
        // OPERADORES LOGICOS
        else if (tipo == TipoOperacion.AND) {
            return operadorIzq.traducir() + " and " + operadorDer.traducir();
        } else if (tipo == TipoOperacion.OR) {
            return operadorIzq.traducir() + " or " + operadorDer.traducir();
        } else if (tipo == TipoOperacion.NOT) {
            return operadorIzq.traducir() + " not " + operadorDer.traducir();
        } 
        // Operadores unarios
        else if (tipo == TipoOperacion.NUMERO) {
            return valor.toString() + "";
        } else if (tipo == TipoOperacion.CADENA) {
            return valor.toString().replace("\n", "\\n") + "";
        } else if (tipo == TipoOperacion.CARACTER) {
            return valor.toString() + "";
        } else if (tipo == TipoOperacion.BOOLEAN) {
            return valor.toString() + "";
        } else if (tipo == TipoOperacion.VARIABLE) {
            return valor.toString();
        } else{
            return "";
        }
        
    }
    
    @Override
    public String traducirGo() {
        // Operadores aritmeticos
        if (tipo == TipoOperacion.SUMA) {
            return operadorIzq.traducirGo() + "+" + operadorDer.traducirGo();
        } else if (tipo == TipoOperacion.RESTA) {
            return operadorIzq.traducirGo() + "-" + operadorDer.traducirGo();
        } else if (tipo == TipoOperacion.MULTIPLICACION) {
            return operadorIzq.traducirGo() + "*" + operadorDer.traducirGo();
        } else if (tipo == TipoOperacion.DIVISION) {
            return operadorIzq.traducirGo() + "/" + operadorDer.traducirGo();
        } else if (tipo == TipoOperacion.CON_PARENTECIS) {
            return "(" + operadorIzq.traducirGo() + ")";
        } 
        // Funciones
        else if (tipo == TipoOperacion.POTENCIA_GO) {
            // aca se podia hacer una clase potencia
            return "math.Pow(float64("+ operadorIzq.traducirGo() + ")," + "float64(" + operadorDer.traducirGo() + "))";
        } else if (tipo == TipoOperacion.MODULO) {
            return operadorIzq.traducirGo() + " % " + operadorDer.traducirGo();
        }
        // Operadores relacionales
        else if (tipo == TipoOperacion.MAYOR) {
            return operadorIzq.traducirGo() + " > " + operadorDer.traducirGo();
        } else if (tipo == TipoOperacion.MENOR) {
            return operadorIzq.traducirGo() + " < " + operadorDer.traducirGo();
        } else if (tipo == TipoOperacion.MAYOR_O_IGUAL) {
            return operadorIzq.traducirGo() + " >= " + operadorDer.traducirGo();
        } else if (tipo == TipoOperacion.MENOR_O_IGUAL) {
            return operadorIzq.traducirGo() + " <= " + operadorDer.traducirGo();
        }else if (tipo == TipoOperacion.ES_IGUAL) {
            return operadorIzq.traducirGo() + " == " + operadorDer.traducirGo();
        } else if (tipo == TipoOperacion.ES_DIFERENTE) {
            return operadorIzq.traducirGo() + " !="  + operadorDer.traducirGo();
        }
        // OPERADORES LOGICOS
        else if (tipo == TipoOperacion.AND_GO) {
            return operadorIzq.traducirGo() + " && " + operadorDer.traducirGo();
        } else if (tipo == TipoOperacion.OR_GO) {
            return operadorIzq.traducirGo() + " || " + operadorDer.traducirGo();
        } else if (tipo == TipoOperacion.NOT_GO) {
            return operadorIzq.traducirGo() + " !" + operadorDer.traducirGo();
        } 
        // Operadores unarios
        else if (tipo == TipoOperacion.NUMERO) {
            return valor.toString() + "";
        } else if (tipo == TipoOperacion.CADENA) {
            return valor.toString().replace("\n", "\\n") + "";
        } else if (tipo == TipoOperacion.CARACTER) {
            return valor.toString() + "";
        } else if (tipo == TipoOperacion.BOOLEAN) {
            return valor.toString() + "";
        } else if (tipo == TipoOperacion.VARIABLE) {
            return valor.toString();
        } else{
            return "";
        }
    }
    
    private String convertirCaracter(String ascci)
    {
        String convertido;
        ascci = ascci.replace("{", "");
        ascci = ascci.replace("}", "");
        ascci = ascci.replace("$", "");
        convertido = ascci;
        
        return convertido;
    }
}
