package Graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacenyListImpl {
    public static void main(String[] args) {
        int v = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        printEdges(adj);

        int[][] edges = {{0, 1}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {3, 4}};
        System.out.println(printAdjacencyList(5, edges));


    }

    static void addEdge(List<List<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printEdges(List<List<Integer>> adj){
        for(int i = 0; i < adj.size(); i++){
            for (int j = 0; j < adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> printAdjacencyList(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] curr : edges) {
            adj.get(curr[0]).add(curr[1]);
            adj.get(curr[1]).add(curr[0]);
        }

        return adj;
    }
}
