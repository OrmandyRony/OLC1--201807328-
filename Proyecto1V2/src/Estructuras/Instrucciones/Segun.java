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
    private String traduccion = "";
    private boolean bandera = true;
    

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
        
        traduccion += this.condicion.traducir() + " == ";
        if (this.listaInstrucciones != null) {
          
            for (Instruccion listaInstruccione : listaInstrucciones) {
                traduccion += listaInstruccione.traducir();
                traduccion += ":";
                
                
            }
            traduccion += "el";
        }
        
        if (this.listaInstruccionesDeLoContrario != null) {
            traduccion += "else: \n";
            for (Instruccion instruccion : listaInstruccionesDeLoContrario) {
                //traduccion += "\t";
                traduccion += instruccion.traducir();
            }
        }
        
        return traduccion;
    }
    
}
