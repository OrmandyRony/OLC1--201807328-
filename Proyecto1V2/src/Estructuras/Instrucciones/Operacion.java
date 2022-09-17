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
        NUMERO,
        CADENA,
        CARACTER,
        BOOLEAN,
        // Fuciones
        IMPRIMIR,
        // Operadores logicos
        MAYOR,
        
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
        }
        // Operadores logicos
        else if (tipo == TipoOperacion.MAYOR) {
            return operadorIzq.traducir() + ">" + operadorDer.traducir();
        }
        // Operadores unarios
        else if (tipo == TipoOperacion.NUMERO) {
            return valor.toString();
        } 
        // CADENA
        else if (tipo == TipoOperacion.CADENA) {
            return valor.toString();
        }
        else{
            return "";
        }
        
    }
}
