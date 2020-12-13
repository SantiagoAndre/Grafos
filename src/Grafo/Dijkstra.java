
package Grafo;

import Lista.ConjuntoOrdenado;
import Lista.Lista;




public class Dijkstra {

    public static Grafo calcularLaRutaMasCortaDesdeLaFuente(Grafo graph, NodoGrafoPonderado source) {

        source.setDistancia(0);
        
        Lista settledNodes = new Lista();
        Lista unsettledNodes = new Lista();
        unsettledNodes.add(source);

        while (unsettledNodes.getTamano()!= 0) {
            NodoGrafoPonderado currentNode = getNodoConDistanciaMinima(unsettledNodes);
            unsettledNodes.remove(currentNode);
            ConjuntoOrdenado adyasencias = currentNode.getAdyasencias();
            for(int i =0; i<adyasencias.getTamano();i++){
                Arista a = (Arista) adyasencias.get(i);
                NodoGrafoPonderado adjacentNode = a.getNodoFinal();
                Integer edgeWeigh = a.getPonderacion();
   
                if (!settledNodes.existe(adjacentNode)) {
                    CalcularDistanciaMinima(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static void CalcularDistanciaMinima(NodoGrafoPonderado evaluationNode, Integer edgeWeigh, NodoGrafoPonderado sourceNode) {
        Integer sourceDistance = sourceNode.getDistancia();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistancia()) {
            evaluationNode.setDistancia(sourceDistance + edgeWeigh);
            Lista  shortestPath = new Lista(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

        private static NodoGrafoPonderado getNodoConDistanciaMinima(Lista unsettledNodes) {
        NodoGrafoPonderado lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for(int i=0; i<unsettledNodes.getTamano();i++){
            NodoGrafoPonderado node = (NodoGrafoPonderado) unsettledNodes.get(i);    
            int nodeDistance = node.getDistancia();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
}