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
public class Metodo implements Instruccion {
    private String nombre;
    private final LinkedList<Instruccion> listaInstrucciones;

    public Metodo(String nombre, LinkedList<Instruccion> listaInstrucciones) {
        this.nombre = nombre;
        this.listaInstrucciones = listaInstrucciones;
    }

    

    @Override
    public String traducir() {
        String traduccion = "def " + this.nombre + "():\n";
        
        if (listaInstrucciones != null) {
            for (Instruccion instruccion : listaInstrucciones) {
                traduccion += "\t";
                traduccion += instruccion.traducir();
            }
        }
        
        return traduccion + "\n";
    }
    
    
}
