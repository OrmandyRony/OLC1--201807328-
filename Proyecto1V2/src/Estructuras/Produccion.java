/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Estructuras.Instrucciones.Instruccion;
import java.util.LinkedList;

/**
 *
 * @author ormandyrony
 */
public class Produccion {
    private Nodo nodo;
    private Instruccion instruccion;
    private LinkedList<Instruccion> instrucciones;

    public Produccion() {
    }

    public Produccion(Nodo nodo, Instruccion instruccion) {
        this.nodo = nodo;
        this.instruccion = instruccion;
    }
    
    public Produccion(Nodo nodo, LinkedList<Instruccion> instrucciones) {
        this.nodo = nodo;
        this.instrucciones = instrucciones;
    }
    
    public Produccion(Nodo nodo, Instruccion instruccion, LinkedList<Instruccion> instrucciones) {
        this.nodo = nodo;
        this.instruccion = instruccion;
        this.instrucciones = instrucciones;
    }
    
    public void addHijo(String valor){
        this.nodo.addHijo(valor);
    }
    
    public void addHijo(Produccion valor){
        this.nodo.addHijo(valor.getNodo());
    }
    
    public void addInstruccion(Instruccion instruccion) {
        this.instrucciones.add(instruccion);
    }
    
    public Instruccion getInstruccion() {
        return instruccion;
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setInstruccion(Instruccion instruccion) {
        this.instruccion = instruccion;
    }

    public void setInstrucciones(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }
    
    
    
    
}
