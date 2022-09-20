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
public class Ejecutar implements Instruccion {
    private final String nombre;
    private LinkedList<Instruccion> listaParametros = null;

    public Ejecutar(String nombre) {
        this.nombre = nombre;
    }

    public Ejecutar(String nombre, LinkedList<Instruccion> listaParametros) {
        this.nombre = nombre;
        this.listaParametros = listaParametros;
    }

    @Override
    public String traducir() {
        String traduccion = this.nombre + "(";
        
         if (listaParametros == null) {
            traduccion += ")\n";
        } else {
            int size = listaParametros.size();
           
            for (int i = 0; i < size; i++) { 

                if (i != (size-1)) {
                    traduccion += listaParametros.get(i).traducir() + ", ";
                } else {
                    traduccion += listaParametros.get(i).traducir() + " ";
                }

            }

            traduccion += ")\n";
        }
         
         return traduccion;
        
    }
    
    
    @Override
    public String traducirGo() {
        String traduccion = this.nombre + "(";
        
         if (listaParametros == null) {
            traduccion += ")\n";
        } else {
            int size = listaParametros.size();
           
            for (int i = 0; i < size; i++) { 

                if (i != (size-1)) {
                    traduccion += listaParametros.get(i).traducirGo()+ ", ";
                } else {
                    traduccion += listaParametros.get(i).traducirGo()+ " ";
                }

            }

            traduccion += ")\n";
        }
         
         return traduccion;
    }
    
}
