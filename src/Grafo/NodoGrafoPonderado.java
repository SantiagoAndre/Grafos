
package Grafo;

import Lista.Lista;

import java.util.function.Predicate;


public  class NodoGrafoPonderado extends NodoGrafo{
    private Integer distancia = Integer.MAX_VALUE;
    private Lista caminoMinimo = new Lista();
    public NodoGrafoPonderado(Comparable dato){
        super(dato);
    }

  
   
    public boolean addArista(NodoGrafoPonderado nodoAdyasente, int peso){
        boolean seRealizo = getAdyacencias().add(new Arista(this,nodoAdyasente,peso));
        if(seRealizo)
           return nodoAdyasente.getAdyacencias().add(new Arista(nodoAdyasente,this,peso));        
        return false;
    }
    public boolean eliminarNodoAdyasente(NodoGrafoPonderado nodoAdyasente, int peso){
        return getAdyacencias().remove(new Arista(this,nodoAdyasente,peso));
    }
    public boolean existeArista(NodoGrafoPonderado nodo, int peso){
        Arista a = new Arista(this,nodo,peso);
        return getAdyacencias().existe(a);
    }
    
    public boolean addNodoAdyasente(Arista a){
        return getAdyacencias().add(a);

    }
    public Arista getAdyasencia(NodoGrafoPonderado nodo){
        Arista posibleArista = new Arista(this, nodo);
        Predicate p = (Predicate<Arista>) (Arista a) -> {
            return a.equals(posibleArista);
        };
        Lista vAdyacencias = getAdyacencias().getIf(p);
        if(vAdyacencias.esVacia())
            return null;
        return (Arista) vAdyacencias.get(0);        
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
    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }
    public Lista getCaminoMinimo() {
        return caminoMinimo;
    }

    public void setCaminoMinimo(Lista caminoMinimo) {
        this.caminoMinimo = caminoMinimo;
    }
}
