/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Grafo.*;
//import Grafo.NodoGrafoNoPonderado;

/**
 *
 * @author santiago
 */
public class TestGrafo {
    private GrafoNoPonderado grafo = new GrafoNoPonderado();
    private GrafoPonderado grafoPonderado = new GrafoPonderado();
    public void inicar(){
        try {
            addVertices(grafoPonderado);
            imprimir(addAristasPonderadas(grafoPonderado));  
            NodoGrafo verticeCondato = grafo.getVerticeCondato(12);
            System.out.print(grafoPonderado.toString());
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        
    }
    public void addVertices(Grafo grafo){
        try {
            grafo.addVertice(12);
            grafo.addVertice(13);
            grafo.addVertice(2);
            grafo.addVertice(1);
            grafo.addVertice(9);
            grafo.addVertice(17);
            grafo.addVertice(12);
        } catch (Exception ex) {
            System.out.print(ex.toString());
        }
    }
    public String addAristas(GrafoNoPonderado grafo){
        try {
            grafo.addArista(12, 13);
            grafo.addArista(17, 12);
            grafo.addArista(17, 17);
            grafo.addArista(1, 13);
            grafo.addArista(12, 99);
        } catch (Exception ex) {
           return ex.getMessage();
        }
        return "Se añadieron aristas.";
    }
    public String addAristasPonderadas(GrafoPonderado grafo){
        try {
            grafo.addArista(12, 13,2);
            grafo.addArista(17, 12,7);
            grafo.addArista(17, 17,20);
            grafo.addArista(1, 13,1);
            grafo.addArista(12, 99,33);
        } catch (Exception ex) {
           return ex.getMessage();
        }
        return "Se añadieron aristas.";
    }
    
    public void imprimir(String msg){
        System.out.println(msg);
    }
}
