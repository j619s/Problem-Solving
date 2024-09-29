package Graphs;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoints {
    static int time = 1;
    public static void main(String[] args) {

    }

    public static List<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[V];
        int[] disc = new int[V]; // discovery time : time at which dfs for u is called
        int[] low = new int[V]; // smallest discovery time reachable from u consider both types of edges
        int[] mark = new int[V]; // which are articulation points

        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(i, -1, adj, visited, disc, low, mark);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(mark[i] == 1){
                res.add(i);
            }
        }

        if(res.size() == 0){
            res.add(-1);
        }
        return res;
    }

    public static void dfs(int u, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] disc, int[] low, int[] mark){
        visited[u] = 1;
        disc[u] = low[u] = time;
        time++;

        int children = 0;
        for(int v : adj.get(u)){
            if(v == parent) continue;

            if(visited[v] == 0){
                dfs(v, u, adj, visited, disc, low, mark);
                low[u] = Math.min(low[u], low[v]);

                if(disc[u] <= low[v] && parent != -1){
                    mark[u] = 1;
                }
                children++;
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if(children > 1 && parent == -1){
            mark[u] = 1;
        }
    }
}
