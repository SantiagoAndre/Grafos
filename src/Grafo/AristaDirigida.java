/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author santiago
 */
public class AristaDirigida extends Arista {
    
    public AristaDirigida(NodoGrafoPonderado nodoInicial, NodoGrafoPonderado nodoFinal, Integer ponderacion) {
        super(nodoInicial, nodoFinal, ponderacion);
    }
    public AristaDirigida(NodoGrafoPonderado nodoInicial, NodoGrafoPonderado nodoFinal) {
        super(nodoInicial, nodoFinal);
    }
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arista a = (Arista) obj;
        if( a.getPonderacion()!=-1 && getPonderacion() !=-1){
            if(!getPonderacion().equals(a.getPonderacion()))
                return false;
        }
        return getNodoInicial().equals(a.getNodoInicial()) && getNodoFinal().equals(a.getNodoFinal());
    }


}
