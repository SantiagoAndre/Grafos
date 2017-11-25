/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Lista.ConjuntoOrdenado;
import Lista.Lista;

/**
 *
 * @author santiago
 */
public class TestLista {
    private final ConjuntoOrdenado lista;

    public TestLista() {
        this.lista = new ConjuntoOrdenado();
    }
    public void inicio(){
        add(lista);
        System.out.println(lista);
        
        remove(lista);
        System.out.println(lista);
        
        System.out.println("Index Of:");
        System.out.println("posicion de 2 no existe 2 -1 : -1:"+lista.indexOf(2));
        System.out.println("posicion de 11 es 5:"+lista.indexOf(11));
        
    }
    public void add(ConjuntoOrdenado lista){
        lista.add(2);
        lista.add(4);
        lista.add(3);
        lista.add(6);
        lista.add(0);
        lista.add(1000);        
        lista.add(10);
        lista.add(12);
        lista.add(11);
        lista.add(0);
        lista.add(2);
        lista.add(4);
        lista.add(3);
        lista.add(6);
        lista.add(0);
        lista.add(1000);        
        lista.add(10);
        lista.add(12);
        lista.add(11);
        lista.add(0);
    }
    public void remove(Lista lista){
        //lista.remove(0);
        lista.remove(new Integer(1000));
    }
}
