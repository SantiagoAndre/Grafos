/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Grafo.Grafo;
import Grafo.GrafoPonderado;
import Grafo.GrafoPonderadoDirigido;
import Grafo.Matrices;
import Grafo.NodoGrafo;
import Lista.ConjuntoOrdenado;
import java.util.Arrays;

/**
 *
 * @author santiago
 */
public class TestPrincipal extends Menu{
    private GrafoPonderado grafo;
    public static String GRAFO_NODIRIGIDO = "Tipo Grafo 2";
    public static String GRAFO_DIRIGIDO = "Tipo Grafo 1";
    
    public TestPrincipal() {
        super(5);
        grafo = new GrafoPonderado();
        
    }

    @Override
    void escribirMenu() {
        
        System.out.println("1. vaciar grafo.");
        System.out.println("2. leer archivo 'entrada.txt' ");
        System.out.println("3. Matriz de adyasencias.");        
        System.out.println("3. imprimir vertices adyasentes a un vertice ");        
        System.out.println("4. maatriz de adyacencias.");
    }

    @Override
    public String procesarOpcion(int opc) throws Exception {
         switch (opc) {
            case 1:
                grafo = new GrafoPonderadoDirigido();
                break;
            case 2:
                leerArchivo();
                break;
            case 3:
                return matrizDeAdyasenciasN();
            case 4:
                return "Vertices: "+verticesAString(",","{","}")+"\nAristas: "+grafo.getAristas().toString(", ","{","}");
            case 5:
                return grafo.toString();
            case 6:
                return "Adios.";
            default:
                return "Opcion incorrecta.";
        }
         
         return "";    
    }
    private String verticesAString(String separador,String inicio,String fin){
        ConjuntoOrdenado vertices = grafo.getVertices();
        String str=inicio;
        for(int i=0; i<vertices.getTamano();i++){
            NodoGrafo nodo = (NodoGrafo) vertices.get(i);
            str = str + nodo.getDato();
            if(i!=vertices.getTamano()-1)
                str = str +separador;
        }
        return str+fin;
    }
    private void leerArchivo() throws Exception {
        Archivo a = new Archivo();
        a.abrirArchivo("entrada.txt");
        Object[] lineas = a.getLines().toArray();
           
        if(lineas.length==0){
            return;
        }
        if(lineas[0].equals(GRAFO_NODIRIGIDO))
            grafo = new GrafoPonderado();
        else
            grafo = new GrafoPonderadoDirigido();
        Object[] array = Arrays.copyOfRange(lineas,1,lineas.length);
        cargarGrafo(array,grafo,0);
    }
         
    
    private void cargarGrafo(Object[] str, GrafoPonderado grafo,int inicio) throws Exception {
        
        if(inicio> str.length-1 || grafo == null)
            return ;
        if(str[inicio].equals("") || str[inicio].equals("Vertices") || str[inicio].equals("Edges") ){
            cargarGrafo(str,grafo,inicio+1);
            return;
        }
        String[] linea = str[inicio].toString().split(" ");
        if(linea[0].equals("V")){
            agregarVertices(grafo,Arrays.copyOfRange(linea,1,linea.length));
        }else if (linea[0].equals("E")){
            grafo.addArista(linea[1], linea[2], Integer.parseInt(linea[3]));
        }
         cargarGrafo(str,grafo,inicio+1);
    }

    private void agregarVertices(Grafo grafo, String[] vertices) throws Exception {
       for(String vertice:vertices){
           grafo.addVertice(vertice);
       }
    }
    
    private String verticesAdyasentesAUnVertice() throws Exception {
        
        System.out.print("ingrese nombre del vertice");
        String nombre = sc.next();
        NodoGrafo vertice = grafo.getVerticeCondato(nombre);
        return "(vetice,coste)\n"+vertice.getAdyasencias().toString("\n","","");
        
    }
    private String matrizDeAdyasenciasN(){
           System.out.print("ingrese exponente de la matriz");
           int exponente = sc.nextInt();
            int[][] matriz = grafo.getMatrizdeAdyasencias(exponente);
            if(matriz == null)
                return "el exponente no es valido";
            return Matrices.MatrizToString(matriz);
           
    }
}
