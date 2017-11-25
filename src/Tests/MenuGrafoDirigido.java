/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Grafo.GrafoPonderado;
import Grafo.GrafoPonderadoDirigido;
import Grafo.NodoGrafo;

/**
 *
 * @author santiago
 */
public class MenuGrafoDirigido extends Menu {

    GrafoPonderado grafo = new GrafoPonderado();

    public MenuGrafoDirigido() {
        super(7);
    }

    @Override
    void escribirMenu() {
        System.out.println("1. vaciar grafo.");
        System.out.println("2. Agregar un vertice ");
        System.out.println("3. Agregar un arco");
        System.out.println("4. modificar la ponderacion de un arco");
        System.out.println("5. imprimir vertices adyasentes a un vertice ");
        System.out.println("6. maatriz de adyacencias.");
    }

    @Override
    public String procesarOpcion(int opc) throws Exception {
        switch (opc) {
            case 1:
                grafo = new GrafoPonderadoDirigido();
                break;
            case 2:
                return agregarVertice();
            case 3:
                return agregarArco();
            case 4:
                return modificarPonderacionArco();
            case 5:
                return verticesAdyasentesAUnVertice();
                
            case 6:
                return grafo.toString();
            case 7:
                return "Adios.";
            default:
                return "Opcion incorrecta.";
        }
        return "exito";

    }

    private String agregarVertice() throws Exception {
        System.out.print("ingrese nombre del vertice(en un Comparable)");
        String nombre = sc.next();
        grafo.addVertice(nombre);
        return "exito";
        }    

    private String agregarArco() throws Exception {
        System.out.print("ingrese nombre del vertice inicial");
        String nomVericeInicial = sc.next();
        
        System.out.print("ingrese nombre del vertice final");
        String nomVerticeFinal = sc.next();
        System.out.print("ingrese ponderacion");
        int ponderacion= sc.nextInt();
        grafo.addArista(nomVericeInicial, nomVerticeFinal,ponderacion );
        return "exito.";

    }

    private String modificarPonderacionArco() throws Exception {
        System.out.print("ingrese nombre del vertice inicial");
        String nomVericeInicial = sc.next();
        
        System.out.print("ingrese nombre del vertice final");
        String nomVerticeFinal = sc.next();
        System.out.print("ingrese antigua ponderacion");
        int ponderacion= sc.nextInt();
        System.out.print("ingrese nueva ponderacion");
        int ponderacionNueva= sc.nextInt();
        grafo.modificarPonderacionArista(nomVericeInicial, nomVerticeFinal, ponderacion, ponderacion);
        return "exito";
    }

    private String verticesAdyasentesAUnVertice() throws Exception {
        
        System.out.print("ingrese nombre del vertice");
        String nombre = sc.next();
        NodoGrafo vertice = grafo.getVerticeCondato(nombre);
        return "(vetice,coste)\n"+vertice.getAdyasencias().toString("\n","","");
        
    }

}
