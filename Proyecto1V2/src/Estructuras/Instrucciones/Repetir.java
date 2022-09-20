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
public class Repetir implements Instruccion {
    private LinkedList<Instruccion> listaInstrucciones;
    private final Operacion condicion;

    public Repetir(Operacion condicion) {
        this.condicion = condicion;
    }

    public Repetir(LinkedList<Instruccion> listaInstrucciones, Operacion condicion) {
        this.listaInstrucciones = listaInstrucciones;
        this.condicion = condicion;
    }

    @Override
    public String traducir() {
        String traduccion = "valor = True\n";
        traduccion += "while (valor == True):\n";
        
        if (listaInstrucciones != null) {
            for (Instruccion instruccion : listaInstrucciones) {
                traduccion += "\t";
                traduccion += instruccion.traducir();
            }
        }
        
        traduccion += "\tif " + this.condicion.traducir() + ":\n\tbreak";
        
        return traduccion + "\n";
    }
    
    @Override
    public String traducirGo() {
        String traduccion = "for true {\n" ;
        
        if (listaInstrucciones != null) {
            for (Instruccion instruccion : listaInstrucciones) {
                traduccion += "\t";
                traduccion += instruccion.traducirGo();
            }
        }
        
        traduccion += "if(" + this.condicion.traducirGo()+ "){\n"
                + "break" + "\n}\n";
        
        return traduccion + "}\n";
    
    }
}
