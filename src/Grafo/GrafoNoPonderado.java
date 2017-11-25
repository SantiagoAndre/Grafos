/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author santiago
 */
public class GrafoNoPonderado extends Grafo{
    public GrafoNoPonderado(){
        super();
    }

   
   
    public boolean  addArista(Comparable datoNodo1,Comparable datoNodo2) throws Exception{
        NodoGrafoNoPonderado nodo1 =  (NodoGrafoNoPonderado) getVerticeCondato(datoNodo1);
        NodoGrafoNoPonderado nodo2 =  (NodoGrafoNoPonderado) getVerticeCondato(datoNodo2);
        
        if(nodo1.addNodoAdyasente(nodo2)){
            return nodo2.addNodoAdyasente(nodo1);
        }
        return false;
    }

    @Override
    public NodoGrafo crearNodoGrafo(Comparable dato) {
        return new NodoGrafoNoPonderado(dato);
    }
  
}
