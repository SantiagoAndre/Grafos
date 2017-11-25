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
public  class NodoGrafoPonderado extends NodoGrafo{
    public NodoGrafoPonderado(Comparable dato){
        super(dato);
    }

  
   
    public boolean addArista(NodoGrafoPonderado nodoAdyasente, int peso){
        boolean seRealizo = getAdyasencias().add(new Arista(this,nodoAdyasente,peso));
        if(seRealizo)
           return nodoAdyasente.getAdyasencias().add(new Arista(nodoAdyasente,this,peso));        
        return false;
    }
    public boolean eliminarNodoAdyasente(NodoGrafoPonderado nodoAdyasente, int peso){
        return getAdyasencias().remove(new Arista(this,nodoAdyasente,peso));
    }
    public boolean existeArista(NodoGrafoPonderado nodo, int peso){
        Arista a = new Arista(this,nodo,peso);
        return getAdyasencias().existe(a);
    }
    public boolean addNodoAdyasente(Arista a){
        return getAdyasencias().add(a);

    }
    @Override
    public void columnaDeAdyasencias(int[] columa,Lista verticesDelGrafo, int columna){
        for(int i=0; i<verticesDelGrafo.getTamano();i++){
            Arista posibleArista = new Arista(this, (NodoGrafoPonderado) verticesDelGrafo.get(i));
            boolean hayAdyasencia = getAdyasencias().existe(posibleArista);
            if(hayAdyasencia)
                columa[i]= 1;
            else 
                columa[i]=0;
        }
    }
 
}
