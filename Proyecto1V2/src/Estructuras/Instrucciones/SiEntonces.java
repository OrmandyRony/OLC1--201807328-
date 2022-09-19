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
    private LinkedList<Instruccion> listaInstrucciones;
    private LinkedList<Instruccion> listaInstruccionesOsi;
    private LinkedList<Instruccion> listaInstruccionesDeLoContrario;
    private String var;
    private static int contadorTabsIf = 1;
    private static int contadorTabsElseIf = 1;
    private static int contadorTabsElse = 1;
    private static boolean bandera = false;
    /**
     * Constructor sin de lo contrario
     * SI expresion_relacional:a ENTONCES lista_instrucciones:b FIN_SI
     * @param condicion
     * @param listaInstrucciones 
     */
    public SiEntonces(Operacion condicion, LinkedList<Instruccion> listaInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
    }
    
    public SiEntonces(Operacion condicion, LinkedList<Instruccion> listaInstruccionesOsi, String var) {
        this.condicion = condicion;
        this.listaInstruccionesOsi = listaInstruccionesOsi;
        this.var = var;
    }

    /**
     * SI expresion_relacional:e ENTONCES lista_instrucciones:l DE_LO_CONTRARIO lista_instrucciones:l2 FIN_SI
     * @param condicion
     * @param listaInstrucciones
     * @param listaInstruccionesDeLoContrario 
     */
    public SiEntonces(Operacion condicion, LinkedList<Instruccion> listaInstrucciones, LinkedList<Instruccion> listaInstruccionesDeLoContrario) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
        this.listaInstruccionesDeLoContrario = listaInstruccionesDeLoContrario;
    }
    
    /**
     * SI expresion_relacional:e ENTONCES lista_instrucciones:l osi:o DE_LO_CONTRARIO lista_instrucciones:l2 FIN_SI 
     * @param condicion
     * @param listaInstrucciones
     * @param listaInstruccionesOsi
     * @param listaInstruccionesDeLoContrario 
     */
    public SiEntonces(Operacion condicion, LinkedList<Instruccion> listaInstrucciones, LinkedList<Instruccion> listaInstruccionesOsi, LinkedList<Instruccion> listaInstruccionesDeLoContrario) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
        this.listaInstruccionesOsi = listaInstruccionesOsi;
        this.listaInstruccionesDeLoContrario = listaInstruccionesDeLoContrario;
    }

    @Override
    public String traducir() {
        String traduccion = "";

        if(listaInstrucciones != null) {
            traduccion += "if " + this.condicion.traducir() + ":\n";
            /*
            for (int i = 0; i < contadorTabsIf; i++) {
                    traduccion += "\t";
                    System.out.println("Agregando tabif: " + contadorTabsIf);
                    
            }*/
            for(Instruccion ins: listaInstrucciones){
                
                traduccion += "\t";
                traduccion += ins.traducir();
            }
            
            ++contadorTabsIf;
        }
        
        if(listaInstruccionesOsi != null) {
            if (bandera) {
                traduccion += "elif " + this.condicion.traducir() + ":\n";
            } else {
                bandera = true;
            }
            
            /*
            for (int i = 0; i < contadorTabsElseIf; i++) {
                    traduccion += "\t";
                    System.out.println("Agregando tabelseif: " + contadorTabsElseIf);
                    
            }*/
            
            for(Instruccion ins: listaInstruccionesOsi){
                if (bandera) {
                    traduccion += "\t";
                }
                
                traduccion += ins.traducir();
            }
            ++contadorTabsElseIf;
        }
        
        if(listaInstruccionesDeLoContrario != null) {
            traduccion += "else: \n";
            for(Instruccion ins: listaInstruccionesDeLoContrario){
                for (int i = 0; i < contadorTabsElse; i++) {
                    System.out.println("Agregando tabelsea");
                    traduccion += "\t";
                   
                }
                traduccion += ins.traducir();
            }
             ++contadorTabsElse;
        }
        
        return traduccion + "\n";
    }

    
    @Override
    public String traducirGo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
 
 
}
