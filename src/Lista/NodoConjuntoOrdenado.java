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
public class NodoConjuntoOrdenado extends NodoListaOrdenada{

    public NodoConjuntoOrdenado(Comparable dato) {
        super(dato);
    }
    @Override
    public Nodo<Comparable> add(Comparable dato) throws Exception{
        if(!getDato().equals(dato))
           return super.add(dato);
        else 
            throw new Exception("EL elemento ya existe");
    }
    @Override
    public Nodo crearNodo(Comparable dato){
        return new NodoConjuntoOrdenado(dato);
    }
}
