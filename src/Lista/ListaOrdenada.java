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
public class ListaOrdenada extends Lista<Comparable> {

    public ListaOrdenada() {
 
    }

    @Override
    public void crearInicio(Comparable dato){
        setInicio(new NodoListaOrdenada(dato));
    }
}
