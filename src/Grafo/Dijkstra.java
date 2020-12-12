
package Grafo;

import Lista.ConjuntoOrdenado;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Dijkstra {

    public static Grafo calculateShortestPathFromSource(Grafo graph, NodoGrafoPonderado source) {

        source.setDistancia(0);

        Set<NodoGrafoPonderado> settledNodes = new HashSet<>();
        Set<NodoGrafoPonderado> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            NodoGrafoPonderado currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            ConjuntoOrdenado adyasencias = currentNode.getAdyasencias();
            for(int i =0; i<adyasencias.getTamano();i++){
                Arista a = (Arista) adyasencias.get(i);
                NodoGrafoPonderado adjacentNode = a.getNodoFinal();
                Integer edgeWeigh = a.getPonderacion();
   
                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static void CalculateMinimumDistance(NodoGrafoPonderado evaluationNode, Integer edgeWeigh, NodoGrafoPonderado sourceNode) {
        Integer sourceDistance = sourceNode.getDistancia();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistancia()) {
            evaluationNode.setDistancia(sourceDistance + edgeWeigh);
            LinkedList<NodoGrafoPonderado> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static NodoGrafoPonderado getLowestDistanceNode(Set<NodoGrafoPonderado> unsettledNodes) {
        NodoGrafoPonderado lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (NodoGrafoPonderado node : unsettledNodes) {
            int nodeDistance = node.getDistancia();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
}