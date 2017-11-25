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
public class ConjuntoOrdenado extends Lista<Comparable>{
    @Override
    public void crearInicio(Comparable dato){
        setInicio(new NodoConjuntoOrdenado(dato));
    }    
}
