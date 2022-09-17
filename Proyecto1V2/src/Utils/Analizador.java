/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Estructuras.Arbol;
import Estructuras.Instrucciones.Instruccion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.LinkedList;

/**
 *
 * @author ormandyrony
 */
public class Analizador {

    LinkedList<Instruccion> AST_arbolSintaxisAbstracta;
    private Arbol arbol;
    
    public Analizador() {
    }
    
    public String interpretar(StringReader text) throws FileNotFoundException {
       // FileReader file = new FileReader("./public/parse.txt"); 
        
        analizadores.Sintactico pars;
        
        
        try {
            pars = new analizadores.Sintactico(new analizadores.Lexico(text));
            pars.parse();        
            AST_arbolSintaxisAbstracta = pars.getAST();
            arbol = pars.getArbol();
    
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println("Causa: "+ex);
        } 
        return ejecutarAST(AST_arbolSintaxisAbstracta);
    }
    
    public String ejecutarAST(LinkedList<Instruccion> ast) {
        if(ast==null){
            return("No es posible ejecutar las instrucciones porque\r\n"
                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
        }
        //Se traduce cada instruccion en el ast, es decir, cada instruccion de 
        //la lista principal de instrucciones.
        
        String traduccion = "";
        
        for(Instruccion ins:ast){
            //Si existe un error léxico o sintáctico en cierta instrucción esta
            //será inválida y se cargará como null, por lo tanto no deberá ejecutarse
            //es por esto que se hace esta validación.
            if(ins!=null)
                traduccion += ins.traducir();
        }
        
        System.out.println("/*========= Python ==========*/");
        
        return traduccion;
        
    }

    public Arbol getArbol() {
        return arbol;
    }
    
    
}
