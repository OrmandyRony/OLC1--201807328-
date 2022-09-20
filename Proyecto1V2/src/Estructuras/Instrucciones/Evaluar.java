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
    
    private String atributo;
    private LinkedList<Instruccion> listaInstruccionesVariables;
    private Operacion valor;
    
    //private String variable;

    /**
     * Para python
     * @param listaInstruccionesVariables
     * @param valor 
     */
    public Evaluar(LinkedList<Instruccion> listaInstruccionesVariables, Operacion valor) {
        this.listaInstruccionesVariables = listaInstruccionesVariables;
        this.valor = valor;
    }

    /**
     * Para go
     * @param atributo
     * @param listaInstruccionesVariables
     * @param valor 
     */
    public Evaluar(String atributo, LinkedList<Instruccion> listaInstruccionesVariables, Operacion valor) {
        this.atributo = this.convertir(atributo);
        this.listaInstruccionesVariables = listaInstruccionesVariables;
        this.valor = valor;
    }
    
    public String convertir(String b) {
        String a = "numero";
        String c = "caracter";
        String d = "cadena";
        String e = "boolean";
        
        String f = "verdadero";
        String g = "falso";

        // son iguales
        if (a.equalsIgnoreCase(b)) {
            b = "float64";
        } else if (c.equalsIgnoreCase(b)) {
            b = "";
        } else if (d.equalsIgnoreCase(b)) {
            b = "";
        } else if (e.equalsIgnoreCase(b)) {
            b = "bool";
        }
         
                             
        return b;
                      
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
    
    @Override
    public String traducirGo() {
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
                    traduccion += "var " + listaInstruccionesVariables.get(i).traducir() + " " + this.atributo + " = " + this.valor.traducir() + "\n";
                } else {
                    traduccion += "var " + listaInstruccionesVariables.get(i).traducir() + " " + this.atributo  + " = " + this.valor.traducir() + "\n";
                }

            }

        }
        // en ves de atrbuto es tipo
        return traduccion;
    }
}
