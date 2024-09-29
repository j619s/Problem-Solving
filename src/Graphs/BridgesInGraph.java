package Graphs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesInGraph {
    static int timer = 1;
    static boolean flag = false;
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 9;
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        addEdge(0, 2, adj);
        addEdge(1, 4, adj);
        addEdge(1, 5, adj);
        addEdge(2, 3, adj);
        addEdge(2, 4, adj);
        addEdge(4, 5, adj);
        addEdge(3, 0, adj);
        addEdge(6, 3, adj);
        addEdge(6, 7, adj);
        addEdge(7, 8, adj);
        addEdge(8, 6, adj);
        addEdge(8, 2, adj);
        System.out.println(isBridge(V, adj));
        System.out.println(flag);
    }

    public static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static List<List<Integer>> isBridge(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        int[] disc = new int[V]; // time at which dfs is called i.e. discovery time
        int[] low  = new int[V]; // int[] low, smallest discovery time reachable from node v

        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, visited, adj, disc, low, bridges);
        return bridges;
    }

    public static void dfs(int u, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj, int[] disc, int[] low, List<List<Integer>> bridges){
        visited[u] = true;
        disc[u] = low[u] = timer;
        timer++;

        for(int v : adj.get(u)){
            if(v == parent){
                continue;
            } else if(!visited[v]){
                dfs(v, u, visited, adj, disc, low, bridges);
                low[u] = Math.min(low[u], low[v]);
                if(disc[u] < low[v]){
                    bridges.add(Arrays.asList(u, v));
                    if(v == 3 && u == 6 || v == 6 && u == 3){
                        flag = true;
                    }
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
