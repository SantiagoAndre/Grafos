package Grafo;

import java.util.Arrays;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ingesis
 */
public class Matrices {
        private int n;
        private int m;
        private int aMatrizA[][]= new int [n][m];
        private int aMatrizB[][]= new int [m][n];
        //voy a manjar los indices de las matrices empezando en 0 y terminando en n-1
        
        public int[][] multiplicarMatrices(){
        	int resultado[][] = new int[n][n];   		
            multiplicarMatrices(resultado,0,0);
            return resultado;
        }
        public Matrices(int matrizA[][],int matrizB[][], int n, int m){
            setMatrizes(matrizA,matrizB,n,m);
        }
        public void setMatrizes(int matrizA[][],int matrizB[][], int n, int m){ 
         //precondicion: matrizA de n*m y matrizB de m*n
            aMatrizA = matrizA;
            aMatrizB = matrizB;
            this.n = n;
            this.m = m;
        }
        
        
        private int  productoPuntoFlaClmna(int fila, int clmna){
            int resultado = 0;
            for (int i=0;i<m;i++){
                   resultado += aMatrizA[fila][i]*aMatrizB[i][clmna];
               }
            return resultado;
        }
    

        //tomo en cuenta que ya se el tamano de la matriz
        private void multiplicarMatrices(int resultado[][], int flaInicio,int clmnaInicio){
            //fila inicio de aMatrizA, filaFin es n
            //columna inicio de aMatrizB, columnaFin en n
            if(flaInicio==n)//termine de rotar las filas y entonces acabe
            	return;
            if(clmnaInicio==n){//termine de usar la FlaInicio
                multiplicarMatrices(resultado,flaInicio+1,0);
                return;
            }
            resultado[flaInicio][clmnaInicio]=productoPuntoFlaClmna(flaInicio,clmnaInicio);
            multiplicarMatrices(resultado,flaInicio,clmnaInicio+1);
        }
    
    public static String MatrizToString(int[][] matriz){
        String str = "";
        for(int[] fila : matriz){
            str = str+ "\n" +Arrays.toString(fila);
        }
        return str;
    }
}