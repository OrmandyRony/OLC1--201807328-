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
public class Segun implements Instruccion {
    private final Operacion condicion;
    private LinkedList<Instruccion> listaInstrucciones;
    private LinkedList<Instruccion> listaInstruccionesDeLoContrario;
    private String declaracion = "";
    private static String var = "";
    //private String traduccion = "";
    private static boolean banderita = true;
     private static boolean bandera2 = false;
     private static boolean bandera30 = true;
    private static int contador = 0;

    public Segun(Operacion condicion, LinkedList<Instruccion> listaInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
        this.declaracion = "valor == " + this.condicion.traducir() + "\n";
        //traduccion = declaracion;
    }

    public Segun(Operacion condicion, LinkedList<Instruccion> listaInstrucciones, LinkedList<Instruccion> listaInstruccionesDeLoContrario) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
        this.listaInstruccionesDeLoContrario = listaInstruccionesDeLoContrario;
        this.declaracion = "valor == " + this.condicion.traducir() + "\n";
        //traduccion = declaracion;
    }

    @Override
    public String traducir() {
        String traduccion = "";
        
        if (banderita) {
            var = this.condicion.traducir();
           // System.out.println("Soy va: " + var);
            banderita = false; 
        }
        
        /*
        System.out.println("Contador: ");
        System.out.println(++contador);
        System.out.println("");
*/
        if (this.listaInstrucciones != null) {
            if (bandera2) {
                
                
                if (bandera30) {
                    traduccion += "if " + this.condicion.traducir() + " == " + var +":\n";
                 
                    bandera30 = false;
                   // System.out.println("BVandera 30  ;" + bandera30);
                } else {
                    traduccion += "elif " + this.condicion.traducir() + " == " + var +":\n";
     
                }
                
                
            } else {
                bandera2 = true;
            }
            
            for (Instruccion listaInstruccione : listaInstrucciones) {
                 if (bandera2) {
                    traduccion += "\t";
                }
                traduccion += listaInstruccione.traducir();
                  
            }
 
        }
        
        if (this.listaInstruccionesDeLoContrario != null) {
            traduccion += "else: \n";
            for (Instruccion instruccion : listaInstruccionesDeLoContrario) {
                traduccion += "\t";
                traduccion += instruccion.traducir();
            }
        }
        
        return traduccion + "\n";
    }
    
    @Override
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
