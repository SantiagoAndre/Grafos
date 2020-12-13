
package Grafo;

import Lista.Lista;


public  class NodoGrafoPonderadoDirigido extends NodoGrafoPonderado{
    
    public NodoGrafoPonderadoDirigido(Comparable dato) {
        super(dato);
    }
    
    public void columnaDeAdyacencias(int[] columa,Lista verticesDelGrafo, int columna){
        for(int i=0; i<verticesDelGrafo.getTamano();i++){
            AristaDirigida posibleArista = new AristaDirigida(this, (NodoGrafoPonderado) verticesDelGrafo.get(i));
            boolean hayAdyasencia = getAdyacencias().existe(posibleArista);
            if(hayAdyasencia)
                columa[i]= 1;
            else 
                columa[i]=0;
        }
    }

}
