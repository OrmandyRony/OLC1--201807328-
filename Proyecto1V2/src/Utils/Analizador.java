/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Estructuras.Arbol;
import Estructuras.Instrucciones.Funcion;
import Estructuras.Instrucciones.Instruccion;
import Estructuras.Instrucciones.Metodo;
import analizadores.ErrorLexico;
import analizadores.Lexico;
import analizadores.Sintactico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.LinkedList;

/**
 *
 * @author ormandyrony
 */
public class Analizador {

    LinkedList<Instruccion> AST_arbolSintaxisAbstracta;
    private Arbol arbol;
    private int numCodigo = 0;
    //public ArrayList<ErrorLexico> ErroresSintacticos = new ArrayList(); 
    
    public Analizador() {
    }
    
    public Codigos interpretar(StringReader text) throws FileNotFoundException {

        Sintactico pars;
        Lexico scanner = new Lexico(text);
        pars = new Sintactico(scanner);
          
        try {    
            pars.parse(); 
           // System.out.println("Aca ya no llega");
            String errores = "";
            for (int i = 0; i < scanner.ErroresLexicos.size(); i++) {
                errores += scanner.ErroresLexicos.get(i).toString();
            }
            
            crearArchivo(generarReporte(errores));
            
            AST_arbolSintaxisAbstracta = pars.getAST();
            arbol = pars.getArbol();
    
        } catch (Exception ex) {
            String errores = "";
            for (int i = 0; i < scanner.ErroresLexicos.size(); i++) {
                errores += scanner.ErroresLexicos.get(i).toString();
            }
            
            crearArchivo(generarReporte(errores));
            
            String erroresSintacticos = "";
            
            for (int i = 0; i < pars.ErroresSintacticos.size(); i++) {
                erroresSintacticos += pars.ErroresSintacticos.get(i).toString();
            }
            
            crearArchivo2(generarReporte2(erroresSintacticos));
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println("Causa: "+ex);
        } 
        
        String codigoPython = ejecutarASTpy(AST_arbolSintaxisAbstracta);
        String codigoGo = ejecutarASTgo(AST_arbolSintaxisAbstracta);
        Codigos cod = new Codigos(codigoPython, codigoGo);
        
        return cod;
    }
    
    public String ejecutarASTpy(LinkedList<Instruccion> ast) {
        if(ast==null){
            return("No es posible ejecutar las instrucciones porque\r\n"
                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
        }
        
        String traduccion = "";
        String funciones = "";
        for(Instruccion ins:ast){
            if(ins!=null) {
                if (ins instanceof Funcion || ins instanceof Metodo) { 
                    funciones += ins.traducir();
                } else {
                    traduccion += ins.traducir();
                }
            }
        }
        
        System.out.println("/*========= py ==========*/");
        
        traduccion = traduccion.replace("\n", "\n\t");
        //System.out.println(traduccion);
        return funciones + "if __name__ == '__main__:'\n\t" + traduccion;
        
    }

    public String ejecutarASTgo(LinkedList<Instruccion> ast) {
        if(ast==null){
            return("No es posible ejecutar las instrucciones porque\r\n"
                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
        }
        
        String funciones = "package main\n" +
                            "\n" +
                            "import (\n" +
"	\"fmt\"\n" +
"	\"math\"\n" +
")\n";
        
        String traduccion = "func main() {\n";
        
        
        for(Instruccion ins:ast){
            if(ins!=null) {
                if (ins instanceof Funcion || ins instanceof Metodo) { 
                    funciones += ins.traducirGo();
                } else {
                    traduccion += ins.traducirGo();
                }
            }
           
        }
        
        System.out.println("/*========= Go ==========*/");
        
        //System.out.println(traduccion);
        traduccion = traduccion.replace("\n", "\n\t");
        return funciones +  traduccion + "\n}";
        
    }
    
    public Arbol getArbol() {
        return arbol;
    }
    
    
    public String generarReporte(String codigo){
        String head = "<head>\n" +
"	<title>Errores Lexicos</title>\n" +
"	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/reporte.css\">\n" +
"       </head>";
        
        String body = "<body>\n" +
"	<div id = principal>\n" +
"		<header>\n" +
"			<div id=\"titulo_principal\">\n" +
"				<h1>Reporte de Errores Lexicos</h1>\n" +
"			</div>\n" +
"		</header>\n" +
"		<hr>\n" +
"\n" +
"		<section>\n" +
"			<div class=\"grafica\">\n" +
"				<div class=\"titulo\">\n" +
"					<h1></h1>\n" +
"				</div>\n" + tablaErroresLexicos(codigo) + "\n" +
"			</div>\n" +
"		</section>\n" +
"\n" +
"	</div>\n" +
"\n" +
"</body>\n";
        
        String html = "<!DOCTYPE html>\n<html>\n" + head + body + "</html>";
        return html;
    }
    
    
        public String generarReporte2(String codigo){
        String head = "<head>\n" +
"	<title>Errores Sintacticos</title>\n" +
"	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/reporte.css\">\n" +
"       </head>";
        
        String body = "<body>\n" +
"	<div id = principal>\n" +
"		<header>\n" +
"			<div id=\"titulo_principal\">\n" +
"				<h1>Reporte de Errores Sintacticos</h1>\n" +
"			</div>\n" +
"		</header>\n" +
"		<hr>\n" +
"\n" +
"		<section>\n" +
"			<div class=\"grafica\">\n" +
"				<div class=\"titulo\">\n" +
"					<h1></h1>\n" +
"				</div>\n" + tablaErroresLexicos(codigo) + "\n" +
"			</div>\n" +
"		</section>\n" +
"\n" +
"	</div>\n" +
"\n" +
"</body>\n";
        
        String html = "<!DOCTYPE html>\n<html>\n" + head + body + "</html>";
        return html;
    }
    
    public String tablaErroresLexicos(String codigo) {
        String tabla = "<table>\n" +
"		 	<tr>\n" +
"	 		<td> Tipo </td>\n" +
"	 		<td> Descripcion </td>\n" +
"            <td> Linea </td> \n" +
"            <td> Columna </td>\n" +
"		 	</tr>";
        
        tabla += codigo;
        tabla += "</table>";
        
        return tabla;
    }
    
    public String crearArchivo(String codigo) {
       
        
        FileWriter fichero = null;
        PrintWriter escritor;
        try
        {
            fichero = new FileWriter("ReporteErroresLexicos"+(numCodigo)+".html");
            escritor = new PrintWriter(fichero);
            escritor.print(codigo);
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo ReporteErroresLexicos" + numCodigo + ".html");
        }finally{
           try {
                if (null != fichero)
                    fichero.close();
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo ReporteErroresLexicos" + numCodigo + ".html");
           } 
        }                        
        
        
        return "";
    }
    
    public String crearArchivo2(String codigo) {
       
        
        FileWriter fichero = null;
        PrintWriter escritor;
        try
        {
            fichero = new FileWriter("ReporteErroresSintacticos"+(numCodigo)+".html");
            escritor = new PrintWriter(fichero);
            escritor.print(codigo);
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo ReporteErroresSintacticos" + numCodigo + ".html");
        }finally{
           try {
                if (null != fichero)
                    fichero.close();
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo ReporteErroresSintacticos" + numCodigo + ".html");
           } 
        }                        
        
        
        return "";
    }
    
}
