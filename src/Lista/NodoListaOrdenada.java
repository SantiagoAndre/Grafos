/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

/**
 *
 * @author santiago
 */
public class NodoListaOrdenada extends Nodo<Comparable>{
    
    public NodoListaOrdenada(Comparable dato) {
        super(dato);
    }

    /**
     *
     * @param dato
     * @return
     * @throws java.lang.Exception
     */
    @Override
    public Nodo<Comparable> add(Comparable dato) throws Exception{
        int comparacion=getDato().compareTo(dato);
        if(comparacion>=0 ){
            Nodo nuevo = crearNodo(dato);
            nuevo.setSiguiente(this);
            return nuevo;
        }
        
        if(existeSiguiente()){
            Nodo siguiente = getSiguiente();
            setSiguiente(siguiente.add(dato));
        }else
            setSiguiente(crearNodo(dato));
        return this;            
    }
    @Override
    public Nodo crearNodo(Comparable dato){
        return new NodoListaOrdenada(dato);
    }
}
