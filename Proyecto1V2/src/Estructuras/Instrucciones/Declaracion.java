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
public class Declaracion {
    
    // Aca pueden venir una o varias variables
    private final Operacion declaracion;
    private LinkedList<Instruccion> listaliterales;
    private LinkedList<Instruccion> listaExpresiones;

    public Declaracion(Operacion declaracion, LinkedList<Instruccion> listaliterales, LinkedList<Instruccion> listaExpresiones) {
        this.declaracion = declaracion;
        this.listaliterales = listaliterales;
        this.listaExpresiones = listaExpresiones;
    }

}
