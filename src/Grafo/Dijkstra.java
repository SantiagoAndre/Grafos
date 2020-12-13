
package Grafo;

import Lista.ConjuntoOrdenado;
import Lista.Lista;




public class Dijkstra {

    public static Grafo calcularLaRutaMasCortaDesdeLaFuente(Grafo graph, NodoGrafoPonderado verticeInicial) {

        verticeInicial.setDistancia(0);
        
        Lista nodosRevisados = new Lista();
        Lista nodosSinRevisar = new Lista();
        nodosSinRevisar.add(verticeInicial);

        while (nodosSinRevisar.getTamano()!= 0) {
            NodoGrafoPonderado nodoActual = getNodoConDistanciaMinima(nodosSinRevisar);
            nodosSinRevisar.remove(nodoActual);
            ConjuntoOrdenado adyasencias = nodoActual.getAdyasencias();
            for(int i =0; i<adyasencias.getTamano();i++){
                Arista a = (Arista) adyasencias.get(i);
                NodoGrafoPonderado nodoAdyacente = a.getNodoFinal();
                Integer pesoArista = a.getPonderacion();
   
                if (!nodosRevisados.existe(nodoAdyacente)) {
                    CalcularDistanciaMinima(nodoAdyacente, pesoArista, nodoActual);
                    nodosSinRevisar.add(nodoAdyacente);
                }
            }
            nodosRevisados.add(nodoActual);
        }
        return graph;
    }

    private static void CalcularDistanciaMinima(NodoGrafoPonderado nodoEvaluado, Integer pesoArista, NodoGrafoPonderado pverticeInicial) {
        Integer distanciaAcomulada = pverticeInicial.getDistancia();
        if (distanciaAcomulada + pesoArista < nodoEvaluado.getDistancia()) {
            nodoEvaluado.setDistancia(distanciaAcomulada + pesoArista);
            Lista  caminoMinimo = new Lista(pverticeInicial.getShortestPath());
            caminoMinimo.add(pverticeInicial);
            nodoEvaluado.setShortestPath(caminoMinimo);
        }
    }

        private static NodoGrafoPonderado getNodoConDistanciaMinima(Lista nodosSinRevisar) {
        NodoGrafoPonderado nodoBuscado = null;
        int distanciaMinima = Integer.MAX_VALUE;
        for(int i=0; i<nodosSinRevisar.getTamano();i++){
            NodoGrafoPonderado vnodo = (NodoGrafoPonderado) nodosSinRevisar.get(i);    
            int distanciaNodo = vnodo.getDistancia();
            if (distanciaNodo < distanciaMinima) {
                distanciaMinima = distanciaNodo;
                nodoBuscado = vnodo;
            }
        }
        return nodoBuscado;
    }
}