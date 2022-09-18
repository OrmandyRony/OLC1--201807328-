/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

import java.util.LinkedList;

/**
 *
 * @author ormandyrony
 */
public class Para implements Instruccion {
    private String variableContador;
    private final Operacion valorInicial;
    private final Operacion valorFinal;
    private Operacion incremento = null;
    private LinkedList<Instruccion> listaInstrucciones;
    
    public Para(String variableContador, Operacion valorInicial, Operacion valorFinal) {
        this.variableContador = variableContador;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
    }

    public Para(String variableContador, Operacion valorInicial, Operacion valorFinal, LinkedList<Instruccion> listaInstrucciones) {
        this.variableContador = variableContador;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.listaInstrucciones = listaInstrucciones;
    }

    public Para(String variableContador, Operacion valorInicial, Operacion valorFinal, Operacion incremento, LinkedList<Instruccion> listaInstrucciones) {
        this.variableContador = variableContador;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.incremento = incremento;
        this.listaInstrucciones = listaInstrucciones;
    }
    
    
    
    @Override
    public String traducir() {
        String traduccion = "";
        if (this.incremento == null) {
            traduccion = "for " + this.variableContador + " in range("+ 
                            this.valorInicial.traducir() + ", " + this.valorFinal.traducir() + "):\n";
        } else {
            traduccion = "for " + this.variableContador + " in range("+ 
                            this.valorInicial.traducir() + ", " + 
                                this.valorFinal.traducir() + ", " + this.incremento.traducir() + "):\n";
        }
        
        
        if (listaInstrucciones != null) {
            for (Instruccion instruccion : listaInstrucciones) {
                traduccion += "\t";
                traduccion += instruccion.traducir();
            }
        } else {
            traduccion += "\t" + "pass";
        }
        
        return traduccion;
    }
    
}
