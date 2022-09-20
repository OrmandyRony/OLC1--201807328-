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
public class Mientras implements Instruccion {
    private final Operacion condicion;
    private LinkedList<Instruccion> listaInstrucciones;
    
    /**
     * Cuando viene sin instrucciones
     * @param condicion 
     */
    public Mientras(Operacion condicion) {
        this.condicion = condicion;
    }

    /**
     * Con instrucciones
     * @param condicion
     * @param listaInstrucciones 
     */
    public Mientras(Operacion condicion, LinkedList<Instruccion> listaInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
    }
    
    @Override
    public String traducir() {
        String traduccion = "while (" + this.condicion.traducir() + "):\n";
        
        if (listaInstrucciones != null) {
            for (Instruccion instruccion : listaInstrucciones) {
                traduccion += "\t";
                traduccion += instruccion.traducir();
            }
        }
        
        
        return traduccion + "\n";
    }
    
    @Override
    public String traducirGo() {
        String traduccion = "for true {\n" ;
        
        traduccion += "if(" + this.condicion.traducirGo()+ "){\n"
                + "break" + "\n}\n";
        
        if (listaInstrucciones != null) {
            for (Instruccion instruccion : listaInstrucciones) {
                traduccion += "\t";
                traduccion += instruccion.traducirGo();
            }
        }
        
        
        
        return traduccion + "}\n";
    }
}
