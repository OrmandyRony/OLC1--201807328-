/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

/**
 *
 * @author ormandyrony
 */
class Simbolo {
    private final Tipo tipo;
    private final String id;
    private Object valor;

    public Simbolo(Tipo tipo, String id) {
        this.tipo = tipo;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
    
    /**
     * Lista de los tipos de variable reconocidos por el lenguaje.
     */
    public static enum Tipo {
        BOOLEAN,
        NUMERO,
        CARACTER, 
        CADENA
    }
}
