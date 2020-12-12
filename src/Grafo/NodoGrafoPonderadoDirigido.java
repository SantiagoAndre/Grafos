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
public  class NodoGrafoPonderadoDirigido extends NodoGrafoPonderado{
    
    public NodoGrafoPonderadoDirigido(Comparable dato) {
        super(dato);
    }
    
    public void columnaDeAdyasencias(int[] columa,Lista verticesDelGrafo, int columna){
        for(int i=0; i<verticesDelGrafo.getTamano();i++){
            AristaDirigida posibleArista = new AristaDirigida(this, (NodoGrafoPonderado) verticesDelGrafo.get(i));
            boolean hayAdyasencia = getAdyasencias().existe(posibleArista);
            if(hayAdyasencia)
                columa[i]= 1;
            else 
                columa[i]=0;
        }
    }
    /*public void columnaDePesos(int[] columa,Lista verticesDelGrafo, int columna){
        for(int i=0; i<verticesDelGrafo.getTamano();i++){
            Arista arista = getAdyasencia((NodoGrafoPonderado) verticesDelGrafo.get(i));
            
            if(arista!= null)
                columa[i]= arista.getPonderacion();
            else 
                columa[i]=-1;
        }
    }*/
}
