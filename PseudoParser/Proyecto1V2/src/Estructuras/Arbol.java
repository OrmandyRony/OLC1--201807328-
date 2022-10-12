/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author ormandyrony
 */
public class Arbol {
    private Nodo raiz;
    private static int numGrafico = 0;
    public Arbol() {
    }

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }    
    
    public void graficar() throws IOException{
        StringBuilder s = new StringBuilder();
        s.append("digraph G{\n");
        s.append("\"node").append(raiz.hashCode()).append("\" [ label = \"").append(raiz.getValor()).append("\",];\n");
        graficar(raiz, s);
        s.append("}");
        System.out.println(s.toString());
        this.graficarGraphivz(s.toString());
        
    }
    
    public void graficar(Nodo raiz, StringBuilder s){        
        LinkedList<Nodo> hijos = raiz.getHijos();
        if(hijos != null){
            for(Nodo hijo: hijos){
                s.append("\"node").append(hijo.hashCode()).append("\" [ label = \"").append(hijo.getValor().replace("\"", "")).append("\",];\n");
                graficar(hijo, s);
                s.append("\"node").append(raiz.hashCode()).append("\" -> \"node").append(hijo.hashCode()).append("\" [ label = \"\",];\n");
            }
        }
    }
    
    public String graficarGraphivz(String codigoGraphviz) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try
        {
            fichero = new FileWriter("graf"+(++numGrafico)+".dot");
            escritor = new PrintWriter(fichero);
            escritor.print(codigoGraphviz);
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo graf" + numGrafico + ".dot");
        }finally{
           try {
                if (null != fichero)
                    fichero.close();
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo graf" + numGrafico + ".dot");
           } 
        }                        
        try{
          Runtime rt = Runtime.getRuntime();
          rt.exec( "dot -Tjpg -o graf"+numGrafico+".jpg graf"+numGrafico+".dot");
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo "
                    + "graf"+numGrafico+".dot");
        }            
        return "graf"+numGrafico+".jpg";
    }

}
