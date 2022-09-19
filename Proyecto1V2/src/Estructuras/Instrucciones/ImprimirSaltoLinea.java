/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

/**
 *
 * @author ormandyrony
 */
public class ImprimirSaltoLinea implements Instruccion {
    private final Operacion imprimir;
    private String metodo;
    /**
     * imprimir_nl expresión; //impresión con salto de linea
     * @param imprimir
     */
    public ImprimirSaltoLinea(Operacion imprimir) {
        this.imprimir = imprimir;
   
    }

    public ImprimirSaltoLinea(Operacion imprimir, String metodo) {
        this.imprimir = imprimir;
        this.metodo = metodo;
    }
    
    
    
    @Override
    public String traducir() {
        String traduccion = "print(" + this.imprimir.traducir() + "+\"\\n\")\n";
      
        return traduccion;
    }
     
}
