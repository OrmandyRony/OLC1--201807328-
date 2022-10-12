/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

import java.util.LinkedList;

/**
 *
 * @author ormandyrony
 */
public class TablaSimbolos extends LinkedList<Simbolo>{

    public TablaSimbolos() {
        super();
    }
    
    Object getValor(String id) {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                return s.getValor();
            }
        }
        System.out.println("La variable " + id + " no existe en este ámbito.");
        return "Desconocido";
    }
    
    void setValor(String id, Object valor) {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                s.setValor(valor);
                return;
            }
        }
        System.out.println("La variable "+id+" no existe en este ámbito, por lo "
                + "que no puede asignársele un valor.");
    }
}
