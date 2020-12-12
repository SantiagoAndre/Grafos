/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Lista.Lista;


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
    
    public void columnaDeAdyasencias(int[] columa,Lista verticesDelGrafo, int columna){
        for(int i=0; i<verticesDelGrafo.getTamano();i++){
            boolean hayAdyasencia = getAdyasencias().existe((Comparable)verticesDelGrafo.get(i));
            getAdyasencias();
            if(hayAdyasencia)
                columa[i]= 1;
            else 
                columa[i]=-1;
        }
    }
    

}
