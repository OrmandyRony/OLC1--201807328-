/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

/**
 *
 * @author ormandyrony
 */
public class Evaluar implements Instruccion {
    
    private Operacion valor;

    public Evaluar(Operacion valor) {
        this.valor = valor;
    }
    
    public String traducir() {
        return "estamos evaluando (" + valor.traducir() + ")\n";
    }
}
