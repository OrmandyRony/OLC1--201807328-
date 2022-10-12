/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.util.LinkedList;

/**
 *
 * @author ormandyrony
 */
public class Nodo {
    private LinkedList<Nodo> hijos;
    private String valor;

    public Nodo() {
    }
    
    public Nodo(String valor) {
        this.valor = valor;
        this.hijos = new LinkedList<Nodo>();
    }    
    
    public Nodo(LinkedList<Nodo> hijos, String valor) {
        this.hijos = hijos;
        this.valor = valor;
    }

    public LinkedList<Nodo> getHijos() {
        return hijos;
    }

    public String getValor() {
        return valor;
    }
    
    public void addHijo(String valor){
        this.hijos.add(new Nodo(null, valor));
    }
    
     public void addHijo(Nodo valor){
        this.hijos.add(valor);
    }
     
    public void setHijos(LinkedList<Nodo> hijos) {
        this.hijos = hijos;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
}
