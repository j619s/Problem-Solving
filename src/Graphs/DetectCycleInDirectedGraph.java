package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = 6;
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        addEdge(0, 1, adj);
        addEdge(2, 1, adj);
        addEdge(2, 3, adj);
        addEdge(3, 4, adj);
        addEdge(4, 5, adj);
        addEdge(5, 3, adj);
        System.out.println(adj);
//        System.out.println(dfs(adj, 0, new boolean[V], new boolean[V]));
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(dfs(adj, i, visited, recStack)){
                    System.out.println("true");
                    break;
                }
            }
        }

    }

    public static void addEdge(int u, int v, List<List<Integer>> adj){
        adj.get(u).add(v);
    }

    public static boolean dfs(List<List<Integer>> adj, int s, boolean[] visited, boolean[] recStack){
        visited[s] = true;
        recStack[s] = true;

        for(int u : adj.get(s)){
            if(!visited[u] && dfs(adj, u, visited, recStack)){
                return true;
            } else if(recStack[u]){
                return true;
            }
        }
        recStack[s] = false;
        return false;
    }

    // using topological sort -> Kahn's Algorithm
    public static boolean topologicalSort(List<List<Integer>> adj, int V){
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int u : adj.get(i)){
                indegree[u]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int u = q.poll();

            for(int v : adj.get(u)){
                if(--indegree[v] == 0){
                    q.add(v);
                }
            }
            count++;
        }

        return count != V;


    }

}
