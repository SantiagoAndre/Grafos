
package Grafo;

import Lista.ConjuntoOrdenado;
import java.util.Objects;

public abstract class NodoGrafo implements Comparable{
    
   Comparable dato;
    ConjuntoOrdenado adyacencias;// de nodos adyasentes
    public NodoGrafo(Comparable dato){
        setDato(dato);
        setNodosAdyasentes(new ConjuntoOrdenado());
    }

    public Comparable getDato() {
        return dato;
    }

    public void setDato(Comparable dato) {
        this.dato = dato;
    }
    public ConjuntoOrdenado getAdyacencias() {
        return adyacencias;
    }
    public void setNodosAdyasentes(ConjuntoOrdenado adyacencias) {
        this.adyacencias = adyacencias;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final NodoGrafo other = (NodoGrafo) obj;
        return Objects.equals(this.dato, other.dato);
    }
    
    @Override
    public int compareTo(Object o) {
        NodoGrafo nodo = (NodoGrafo) o;
        return getDato().compareTo(nodo.getDato());
    }
    
    
    public String toString1(){
        String adyasentes=  getAdyacencias().toString("->","","");
        if(adyasentes.isEmpty())
            return getDato().toString();
        return getDato().toString()+"-->"+adyasentes;
    }
    @Override
    public String toString(){
        return (String) this.getDato();
    }
}
