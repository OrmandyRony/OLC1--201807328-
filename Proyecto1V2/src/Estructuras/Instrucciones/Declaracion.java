/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Instrucciones;

/**
 *
 * @author ormandyrony
 */
public class Declaracion implements Instruccion {
    public static enum Tipo {
        NUMERO
    }
    /**
     * Identificador de la variable que será declarada.
     */
    private final String id;
    /**
     * Tipo de la variable que será declarada.
     */
    Tipo tipo;
    /**
     * Constructor de la clase
     * @param a Identificador de la variable que será declarada
     * @param t Tipo de la clase que será declarada
     */
    public Declaracion(String a, Tipo t) {
        id = a;
        tipo = t;
    }

    @Override
    public String traducir() {
        if (tipo == Tipo.NUMERO) {
            return "";
        } else {
            return "";
        }
    }
}
