
package Grafo;


public class GrafoPonderadoDirigido extends GrafoPonderado{
    @Override
    public void  addArista(Comparable datoNodo1,Comparable datoNodo2,int peso) throws Exception{
        NodoGrafoPonderado nodo1 = (NodoGrafoPonderado) getVerticeCondato(datoNodo1);
        NodoGrafoPonderado nodo2 =  (NodoGrafoPonderado) getVerticeCondato(datoNodo2);
        
        if(!nodo1.addNodoAdyasente(crearArista(nodo1,nodo2,peso)))
            throw new Exception("Ya existe la arista");
    }
    @Override
    public NodoGrafo crearNodoGrafo(Comparable dato) {
        return new NodoGrafoPonderadoDirigido(dato);
    }
    @Override
     public Arista crearArista(NodoGrafoPonderado nodo1,NodoGrafoPonderado nodo2,int ponderacion){
        return new AristaDirigida(nodo1, nodo2, ponderacion);
    }

}
