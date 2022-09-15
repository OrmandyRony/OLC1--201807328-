/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Scanner;

/**
 *
 * @author ormandyrony
 */
public class Files {

    public Files() {
    }
    
    public String readFile(File archivo) {
        try {
            java.util.Scanner obj = new java.util.Scanner(archivo);
            String entrada = "";
            while (obj.hasNextLine()){
                entrada += obj.nextLine()+'\n';                
            }
            return entrada;
        } catch (FileNotFoundException ex) {
            return "Error Archivo invalido.";
        } 
    }
    
}
