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
public class Evaluar implements Instruccion {
    
    
    private LinkedList<Instruccion> listaInstruccionesVariables;
    private Operacion valor;
    //private String variable;

    public Evaluar(LinkedList<Instruccion> listaInstruccionesVariables, Operacion valor) {
        this.listaInstruccionesVariables = listaInstruccionesVariables;
        this.valor = valor;
    }

    @Override
    public String traducir() {
        
        String traduccion = "";
        /*
        System.out.println("Imrimiendo traduccionoes");
        for (Instruccion ins : listaInstruccionesVariables) {
            System.out.println(ins.traducir());
        }
        
        */
        if (listaInstruccionesVariables != null) {
            int size = listaInstruccionesVariables.size();
    
            for (int i = 0; i < size; i++) { 

                if (i != (size-1)) {
                    traduccion += listaInstruccionesVariables.get(i).traducir() + " = " + this.valor.traducir() + "\n";
                } else {
                    traduccion += listaInstruccionesVariables.get(i).traducir() + " = " + this.valor.traducir() + "\n";
                }

            }

        }
        
        return traduccion;
    }
}
