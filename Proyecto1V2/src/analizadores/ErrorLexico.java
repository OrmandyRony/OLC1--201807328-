/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadores;

/**
 *
 * @author ormandyrony
 */
public class ErrorLexico {
    public String tipo;
    public String descripcion; // con lexema
    public String linea;
    public String columna;

    public ErrorLexico(String tipo, String descripcion, String linea, String columna) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
        System.out.println("Ingreso error: " + this.tipo);
    }
    
    @Override
    public String toString(){
        return "<tr>\n\t<td>" + this.tipo + "</td>\n\t<td>"+this.descripcion +"</td>\n\t<td>"
                +this.linea+"</td>\n\t<td>"+this.columna+"</td>\n\t</tr>";
    }
    
}
