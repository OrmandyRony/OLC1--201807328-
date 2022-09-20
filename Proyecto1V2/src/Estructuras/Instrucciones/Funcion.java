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
public class Funcion implements Instruccion {
    private String nombre;
    private LinkedList<Instruccion> listaParametros = null;
    private final LinkedList<Instruccion> listaInstrucciones;
    private Operacion retorno;

    public Funcion(String nombre, LinkedList<Instruccion> listaInstrucciones) {
        this.nombre = nombre;
        this.listaInstrucciones = listaInstrucciones;
    }

    public Funcion(String nombre, LinkedList<Instruccion> listaParametros, LinkedList<Instruccion> listaInstrucciones) {
        this.nombre = nombre;
        this.listaParametros = listaParametros;
        this.listaInstrucciones = listaInstrucciones;
    }

    public Funcion(String nombre, LinkedList<Instruccion> listaParametros, LinkedList<Instruccion> listaInstrucciones, Operacion retorno) {
        this.nombre = nombre;
        this.listaParametros = listaParametros;
        this.listaInstrucciones = listaInstrucciones;
        this.retorno = retorno;
    }

    public Funcion(String nombre, LinkedList<Instruccion> listaInstrucciones, Operacion retorno) {
        this.nombre = nombre;
        this.listaInstrucciones = listaInstrucciones;
        this.retorno = retorno;
    }
    
    
   

    @Override
    public String traducir() {
        String traduccion = "def " + this.nombre  + "(";
        if (listaParametros == null) {
            traduccion += "):\n";
        } else {
            int size = listaParametros.size();
           
            for (int i = 0; i < size; i++) { 

                if (i != (size-1)) {
                    traduccion += listaParametros.get(i).traducir() + ", ";
                } else {
                    traduccion += listaParametros.get(i).traducir() + " ";
                }

            }

            traduccion += "):\n";
        }
        
         
        
        if (listaInstrucciones != null) {
            for (Instruccion instruccion : listaInstrucciones) {
                traduccion += "\t";
                traduccion += instruccion.traducir();
            }
        }
        
        if (this.retorno != null) {
            traduccion += "\treturn ";
            traduccion += this.retorno.traducir();
        }
        
        return traduccion + "\n";
    }
    
    @Override
    public String traducirGo() {
        String traduccion = "func " + this.nombre  + "(";
        if (listaParametros == null) {
            traduccion += "){\n";
        } else {
            int size = listaParametros.size();
           
            for (int i = 0; i < size; i++) { 

                if (i != (size-1)) {
                    traduccion += listaParametros.get(i).traducir() + ", ";
                } else {
                    traduccion += listaParametros.get(i).traducir() + " ";
                }

            }

            traduccion += "){\n";
        }
        
         
        
        if (listaInstrucciones != null) {
            for (Instruccion instruccion : listaInstrucciones) {
                traduccion += "\t";
                traduccion += instruccion.traducir();
            }
        }
        
        if (this.retorno != null) {
            traduccion += "\treturn ";
            traduccion += this.retorno.traducir();
        }
        
        return traduccion + "\n}\n";
    }
}
