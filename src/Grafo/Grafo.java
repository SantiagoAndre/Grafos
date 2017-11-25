/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Lista.ConjuntoOrdenado;
import Lista.Lista;
import java.util.function.Predicate;

/**
 *
 * @author santiago
 */
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
    public int[][] getMatrizdeAdyasencias(int exponente){
        if(exponente>getVertices().getTamano() || exponente<1)
            return null;
        if(exponente<1)
            return null;
        int[][] matrizBase = getMatrizdeAdyasenciasBase();
        if(exponente ==1)
            return matrizBase;
        Matrices m = new Matrices(matrizBase,matrizBase,matrizBase.length,matrizBase.length);
        int[][] base_a_la_i = matrizBase;
        for(int i = 1; i<exponente;i++){
            base_a_la_i =m.multiplicarMatrices();
            m.setMatrizes(base_a_la_i, matrizBase, matrizBase.length,matrizBase.length);
        }
        return base_a_la_i;
            
    }
    public  int[][] getMatrizdeAdyasenciasBase(){
        if(esVacio())      
            return null;
        int numeroVertices = getVertices().getTamano();
        int[][] base = new int[numeroVertices][numeroVertices];
        for(int i = 0; i<getVertices().getTamano();i++){
            NodoGrafo nodo = (NodoGrafo)getVertices().get(i);
            nodo.columnaDeAdyasencias(base[i], getVertices(), i);
        }
        return base;
    }
    @Override
    public String toString(){
        return getVertices().toString("\n","","");
    }
    public abstract NodoGrafo crearNodoGrafo(Comparable dato);

    private boolean esVacio() {
        return getVertices().esVacia();
    }
}
