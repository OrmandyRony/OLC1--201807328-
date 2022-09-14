/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

/**
 *
 * @author ormandyrony
 */
public class Declaracion implements Instruccion {
    private final String id;
    Simbolo.Tipo tipo;

    public Declaracion(String id, Simbolo.Tipo tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public Object ejecutar(TablaSimbolos ts) {
        /*Aca lo tomo y lo tradusco a otro lenguaje :
            solo tomo los valores que me importan y eso los imprimo
        v*/
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
 
}
