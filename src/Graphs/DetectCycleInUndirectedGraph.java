package Graphs;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = 6;
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        addEdge(0, 1, adj);
        addEdge(1, 2, adj);
        addEdge(1, 3, adj);
        addEdge(2, 3, adj);
        addEdge(2, 4, adj);
        addEdge(4, 5, adj);

       // System.out.println(dfs(adj, 0, new boolean[V], -1));
        //if the graph is disconnected then,
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(dfs(adj, i, visited, -1)){
                    System.out.println("cycle");
                    break;
                } else{
                    System.out.println("No cycle");
                }
            }
        }



    }

    public static void addEdge(int u, int v, List<List<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static boolean dfs(List<List<Integer>> adj, int s, boolean[] visited, int parent){
        visited[s] = true;
        for(int u : adj.get(s)){
            if(!visited[u]){
                if(dfs(adj, u, visited, s)){
                    return true;
                }
            } else if(u != parent){
                return true;
            }
        }
        return false;
    }
}
