/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stringcomillas;

/**
 *
 * @author ormandyrony
 */
public class StringComillas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ascci = "${70}";
        String convertido;
        ascci = ascci.replace("{", "");
        ascci = ascci.replace("}", "");
        ascci = ascci.replace("$", "");
        System.out.println(ascci);
        convertido = ascci;
        
        int asci = Integer.parseInt(ascci);
        System.out.println(asci);
        char as = (char) asci;
        
        System.out.println(as);
        convertido = String.valueOf(as);
        System.out.println(convertido);
        /*
        String codigo = "\t\telif";
        System.out.println(codigo);
        codigo = codigo.replaceFirst("\t", "");
        System.out.println(codigo);*/
        /*
        String a = "verdadero";
        String c = "falso";

        // son iguales
        if (a.equalsIgnoreCase(b)) {
           b = "True"
        } else if (a.equalsIgnoreCase(b)) {
            b = "False"
        }
        */
        /*
        String olc =  "olc\n";
        System.out.println(olc);
        olc = olc.replace("\n", "\\n");
        System.out.println(olc);
        */
    }
    
}
