
package Grafo;

import Lista.ConjuntoOrdenado;
import Lista.Lista;
import java.util.function.Predicate;

public abstract class Grafo {
        private ConjuntoOrdenado vertices;
    public Grafo(){
        setVertices(new ConjuntoOrdenado());
    }

    public ConjuntoOrdenado getVertices() {
        return vertices;
    }

    public void setVertices(ConjuntoOrdenado vertices) {
        this.vertices = vertices;
    }
    public void addVertice(Comparable dato) throws Exception{
        if(!getVertices().add(crearNodoGrafo(dato)))
            throw new Exception("Ya existe vertice con el dato"+dato+".");
    }

    public NodoGrafo getVerticeCondato(Comparable dato) throws Exception{
        Predicate p = (Predicate<NodoGrafo>) (NodoGrafo nodo) -> {
            return nodo.getDato().equals(dato);
        };
            Lista coincidiencias = getVertices().getIf(p);//ya que no se permiten duplicados tiene maximo un dato
            if(coincidiencias.esVacia())
                throw new Exception("No existe vertice con el dato "+dato+".");
            return (NodoGrafo) coincidiencias.get(0);
    }

    protected boolean esVacio() {
        return getVertices().esVacia();
    }
    @Override
    public String toString(){
        return getVertices().toString("\n","","");
    }
    public abstract NodoGrafo crearNodoGrafo(Comparable dato);


}
