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
public class Variable implements Instruccion {
    private final Operacion variable;
    private LinkedList<Instruccion> listaInstrucciones;

    public Variable(Operacion variable, LinkedList<Instruccion> listaInstrucciones) {
        this.variable = variable;
        this.listaInstrucciones = listaInstrucciones;
    }
    
    public Variable(Operacion variable) {
        this.variable = variable;
    }

    @Override
    public String traducir() {
        String traduccion = this.variable.toString();
        return traduccion;
    }
    
}
