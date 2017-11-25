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
public class NodoGrafoNoPonderado extends NodoGrafo{
    public NodoGrafoNoPonderado(Comparable dato){
        super(dato);
    }

   
    public boolean addNodoAdyasente(NodoGrafoNoPonderado nodoAdyasente){
        return getAdyasencias().add(nodoAdyasente);
    }

    

}
