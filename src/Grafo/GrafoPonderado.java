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
public  class GrafoPonderado extends Grafo {
    public GrafoPonderado(){
        setVertices(new ConjuntoOrdenado());
    }

  
    public void  addArista(Comparable datoNodo1,Comparable datoNodo2,int ponderacion) throws Exception{
        NodoGrafoPonderado nodo1 = (NodoGrafoPonderado) getVerticeCondato(datoNodo1);
        NodoGrafoPonderado nodo2 =  (NodoGrafoPonderado) getVerticeCondato(datoNodo2);
        if(nodo1.existeArista(nodo2, ponderacion) || nodo2.existeArista(nodo1, ponderacion)){
            throw new Exception("Ya existe la arista");
        }
        if(nodo1.addNodoAdyasente(crearArista(nodo1,nodo2,ponderacion))){
            nodo2.addNodoAdyasente(crearArista(nodo2,nodo1,ponderacion)); 
        }else
            throw new Exception("Ya existe la arista");
    }
    public Arista crearArista(NodoGrafoPonderado nodo1,NodoGrafoPonderado nodo2,int ponderacion){
        return new Arista(nodo1, nodo2, ponderacion);
    }
    public Arista getArista(Comparable inicio, Comparable fin, int ponderacion) throws Exception{
        NodoGrafo verticeInicial = super.getVerticeCondato(inicio);
        NodoGrafo verticeFinal  = super.getVerticeCondato(inicio);
        
        Predicate p = (Predicate<Arista>) (Arista arista) -> {
            return arista.getNodoFinal().equals(verticeFinal);
        };
        ConjuntoOrdenado nodosAdyasentes = verticeInicial.getAdyasencias();
        
        Lista coincidiencias= nodosAdyasentes.getIf(p);
        if(coincidiencias.esVacia())     
            throw new Exception("No existe arco con las espesificaciones");
        return  (Arista) coincidiencias.get(0);
    }
    public void modificarPonderacionArista(Comparable inicio, Comparable fin, int ponderacion,int nuevaPonderacion) throws Exception{
        Arista a = getArista(inicio,fin,ponderacion);
        a.setPonderacion(nuevaPonderacion);
    }
    @Override
    public NodoGrafo crearNodoGrafo(Comparable dato) {
        return new NodoGrafoPonderado(dato);
    }
    public ConjuntoOrdenado getAristas(){
        ConjuntoOrdenado aristas = new ConjuntoOrdenado();
        for(int i=0;i<getVertices().getTamano();i++){
            NodoGrafo nodo = (NodoGrafo) getVertices().get(i);
            aristas.addAll(nodo.getAdyasencias());
        }
        return aristas;
    }
    public  int[][] getMatrizdePesos(){
        if(esVacio())      
            return null;
        int numeroVertices = getVertices().getTamano();
        int[][] base = new int[numeroVertices][numeroVertices];
        for(int i = 0; i<getVertices().getTamano();i++){
            NodoGrafoPonderado nodo = (NodoGrafoPonderado)getVertices().get(i);
            nodo.columnaDePesos(base[i], getVertices(), i);
        }
        return base;
    }
}