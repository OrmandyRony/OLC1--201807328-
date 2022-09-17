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
public class SiEntonces implements Instruccion {
    private final Operacion condicion;
    private final LinkedList<Instruccion> listaInstrucciones;
    private LinkedList<Instruccion> listaInstruccionesOsi;
    private LinkedList<Instruccion> listaInstruccionesDeLoContrario;

    /**
     * Constructor sin de lo contrario
     * @param condicion
     * @param listaInstrucciones 
     */
    public SiEntonces(Operacion condicion, LinkedList<Instruccion> listaInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
    }

    public SiEntonces(Operacion condicion, LinkedList<Instruccion> listaInstrucciones, LinkedList<Instruccion> listaInstruccionesDeLoContrario) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
        this.listaInstruccionesDeLoContrario = listaInstruccionesDeLoContrario;
    }
    
    public SiEntonces(Operacion condicion, LinkedList<Instruccion> listaInstrucciones, LinkedList<Instruccion> listaInstruccionesOsi, LinkedList<Instruccion> listaInstruccionesDeLoContrario) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
        this.listaInstruccionesOsi = listaInstruccionesOsi;
        this.listaInstruccionesDeLoContrario = listaInstruccionesDeLoContrario;
    }

    @Override
    public String traducir() {
        String traduccion = "if " + this.condicion.traducir() + ":\n";
        if(listaInstrucciones != null)
            for(Instruccion ins: listaInstrucciones){
                traduccion += "\t";
                traduccion += ins.traducir();
            }
        if(listaInstruccionesOsi != null){
            traduccion += "el ";
            for(Instruccion ins: listaInstruccionesOsi){
                traduccion += "\t";
                traduccion += ins.traducir();
            }
        }
        if(listaInstruccionesDeLoContrario != null){
            traduccion += "else: \n";
            for(Instruccion ins: listaInstruccionesDeLoContrario){
                traduccion += "\t";
                traduccion += ins.traducir();
            }
        }
        return traduccion;
    }

    

   
 
 
}
