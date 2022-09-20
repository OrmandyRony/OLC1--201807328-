/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

/**
 *
 * @author ormandyrony
 */
public class Imprimir implements Instruccion {
    private final Operacion imprimir;
  
    /**
     * imprimir expresión; //impresión sin salto de línea
     * @param imprimir
     */
    public Imprimir(Operacion imprimir) {
        this.imprimir = imprimir;
   
    }
    
    
    
    
    @Override
    public String traducir() {
        String traduccion = "print(" + this.imprimir.traducir() + ")\n";
      
        return traduccion;
    }
     
    @Override
    public String traducirGo() {
        String traduccion = "fmt.Print(" + this.imprimir.traducir() + ")\n";
      
        return traduccion;
    }
}
