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
        SUMA, 
        NUMERO
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
        if (tipo== TipoOperacion.SUMA) {
            return operadorIzq.traducir() + "+" + operadorDer.traducir();
        } /* ======== OPERACIONES UNARIOS ======== */
        else if (tipo == TipoOperacion.NUMERO) {
            return valor.toString();
        } else{
            return "";
        }
        
    }
}
