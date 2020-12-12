/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Lista.Lista;
import java.util.function.Predicate;

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
    public Arista getAdyasencia(NodoGrafoPonderado nodo){
        Arista posibleArista = new Arista(this, nodo);
        Predicate p = (Predicate<Arista>) (Arista a) -> {
            return a.equals(posibleArista);
        };
        Lista vAdyasencias = getAdyasencias().getIf(p);
        if(vAdyasencias.esVacia())
            return null;
        return (Arista) vAdyasencias.get(0);        
    }
    
    public void columnaDePesos(int[] columa,Lista verticesDelGrafo, int columna){
        
        for(int i=0; i<verticesDelGrafo.getTamano();i++){
            NodoGrafoPonderado  otro = (NodoGrafoPonderado)verticesDelGrafo.get(i);
            if(this.equals(otro)){
                 columa[i] = 0;
                 continue;
            }
            Arista arista = getAdyasencia( otro);
            
            if(arista!= null)
                columa[i]= arista.getPonderacion();
            else 
                columa[i]=-1;
        }
    }
 
}
