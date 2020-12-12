/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Grafo.Dijkstra;
import Grafo.Grafo;
import Grafo.GrafoPonderado;
import Grafo.GrafoPonderadoDirigido;
import Grafo.NodoGrafo;
import Grafo.NodoGrafoPonderado;
import Lista.ConjuntoOrdenado;
import java.util.Arrays;

/**
 *
 * @author santiago
 */
public class TestPrincipal extends Menu{
    private GrafoPonderado grafo;
    public static String GRAFO_NODIRIGIDO = "2";
    public static String GRAFO_DIRIGIDO = "1";
    public static int TIPO_GRAFO_CARACTERES=0;
    public static int TIPO_GRAFO_NUMEROS = 1;
    int tipoGrafo;
    public TestPrincipal() {
        super(5);
        grafo = new GrafoPonderado();
        
    }

    @Override
    void escribirMenu() {
        
        System.out.println("0. vaciar grafo.");
        System.out.println("1. leer archivo 'entrada.txt' ");
        System.out.println("2. Imprimir grafo.");        
        System.out.println("3. Matrix de pesos.");        
        System.out.println("4. Dijkstra.");
    }

    @Override
    public String procesarOpcion(int opc) throws Exception {
         switch (opc) {
            case 0:
                grafo = new GrafoPonderadoDirigido();
                break;
            case 1:
                try{
                 leerArchivo();
                 System.out.println("Grafo cargado exitosamente.");
                }catch(Exception e){
                    grafo  = new GrafoPonderadoDirigido();
                    System.out.print("No se ha podido crear el grafo: ");
                    throw e;
                }
                break;
            case 2:
                return "Vertices: "+verticesAString(",","{","}")+"\nAristas: "+grafo.getAristas().toString(", ","{","}");
            case 3:
                System.out.println("Matrix de pesos");
                return matrizDePesos();
            case 4:
                System.out.println("Dijkstra");
                return dijkstra();
            case 5:
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
        int tipoGrafo;
        a.abrirArchivo("entrada.txt");
        Object[] lineas =  a.getLines().toArray();
           
        if(lineas.length<=1){
            return;
        }
        
        if(lineas[0].equals(GRAFO_NODIRIGIDO))
            grafo = new GrafoPonderado();
        else if(lineas[0].equals(GRAFO_DIRIGIDO)){
            grafo = new GrafoPonderadoDirigido();
        }else{
            throw  new Exception("Tipo de grafo no reconocido, Tipo de Grafo: 1. Dirigido; 2. No dirigido");
        }
        if(!((String)lineas[1]).matches("-?\\d+(\\.\\d+)?")){
            throw new Exception("No se puede dar formato al archivo, revice la linea 2");
        }
        tipoGrafo = Integer.parseInt((String) lineas[1]);
        
        if(tipoGrafo != TIPO_GRAFO_NUMEROS && tipoGrafo != TIPO_GRAFO_CARACTERES){
            
            throw  new Exception("El tipo ingresado no es valido");
        }
        this.tipoGrafo = tipoGrafo;
        Object[] array = Arrays.copyOfRange(lineas,2,lineas.length);
        cargarGrafo(array,grafo,0);
    }
         
    
    private void cargarGrafo(Object[] str, GrafoPonderado grafo,int inicio) throws Exception {
        
        if(inicio> str.length-1 || grafo == null)
            return ;
        if(str[inicio].equals("") || str[inicio].equals("Vertices") || str[inicio].equals("Edges") ){
            cargarGrafo(str,grafo,inicio+1);
            return;
        }
        
        String[] linea = str[inicio].toString().split(",");
        if(grafo.getVertices().getTamano() == 0 ){
            agregarVertices(grafo,linea);
        }else{
            
            if(!(linea[2].matches("-?\\d+(\\.\\d+)?") && linea[2].charAt(0)!='-' )){ //No es un numero positivo
               throw new Exception("La arista "+linea[0]+" - "+linea[1]+ " tiene un peso negativo");
            }
            int peso = Integer.parseInt(linea[2]);
            grafo.addArista(formatearElemento(linea[0]), formatearElemento(linea[1]), peso);
        }
         cargarGrafo(str,grafo,inicio+1);
    }

    private void agregarVertices(Grafo grafo, String[] vertices) throws Exception {
       for(String vertice:vertices){
           grafo.addVertice(formatearElemento(vertice));
       }
    }
 
    private String matrizDePesos(){
         
            int[][] matriz = grafo.getMatrizdePesos();
           
            return matrizToString(matriz);
    }
    private String dijkstra(){
        Dijkstra.calculateShortestPathFromSource(grafo, (NodoGrafoPonderado) grafo.getVertices().get(0));
        ConjuntoOrdenado vertices = grafo.getVertices();
        for(int i =0; i<vertices.getTamano();i++){
            NodoGrafoPonderado nodo = (NodoGrafoPonderado) vertices.get(i);
            System.out.print("Nodo "+nodo+": ");
            System.out.println(nodo.getShortestPath());
        }
        return ":3";
    }
    
    //-------------------------------- funciones auiliare ----------------------------------------//
    private Comparable formatearElemento(String vertice) throws Exception{
        Comparable verticeFormateado =vertice;       
          if(tipoGrafo== 1){//Numeros
            if(vertice.matches("-?\\d+(\\.\\d+)?")){
                verticeFormateado = Integer.parseInt(vertice);
            }
            
          }else  if(vertice.length()== 1 && Character.isLetter(vertice.charAt(0))){
            verticeFormateado = vertice;
          }else{
              
              throw new Exception("No se pudo dar formato al vertice " + vertice +".");
          }
               
        return verticeFormateado;
    }
    private String matrizToString(int[][] matriz){
        String str = "";
        String inf= "\u221e";
        for(int[] fila : matriz){
            str = str+ "\n" +Arrays.toString(fila).replace("-1",inf);
        }
        return str;
    }
}
