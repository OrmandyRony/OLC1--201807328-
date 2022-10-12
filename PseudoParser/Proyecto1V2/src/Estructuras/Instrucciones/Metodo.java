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
    private LinkedList<Instruccion> listaParametros = null;
    private final LinkedList<Instruccion> listaInstrucciones;

    public Metodo(String nombre, LinkedList<Instruccion> listaInstrucciones) {
        this.nombre = nombre;
        this.listaInstrucciones = listaInstrucciones;
    }

    public Metodo(String nombre, LinkedList<Instruccion> listaParametros, LinkedList<Instruccion> listaInstrucciones) {
        this.nombre = nombre;
        this.listaParametros = listaParametros;
        this.listaInstrucciones = listaInstrucciones;
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
        
        return traduccion + "\n\n";
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
                    //System.out.println(listaParametros.get(i));
                    traduccion += listaParametros.get(i).traducirGo()+ listaParametros.get(i).getTipoDato() + ", ";
                } else {
                    traduccion += listaParametros.get(i).traducirGo()+ listaParametros.get(i).getTipoDato() +" ";
                }

            }

            traduccion += "){\n";
        }
        
         
        
        if (listaInstrucciones != null) {
            for (Instruccion instruccion : listaInstrucciones) {
                traduccion += "\t";
                traduccion += instruccion.traducirGo();
            }
        }
        
        return traduccion + "\n}\n\n";
    }

    @Override
    public String getTipoDato() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
