package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String[] args) {

    }

    public boolean isBipartite(List<List<Integer>> adj, int V){
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(!check(i, V, adj, color)){
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean check(int u, int V, List<List<Integer>> adj, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        color[u] = 0;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int v : adj.get(curr)){
                if(color[v] == -1){
                    color[v] = 1 - color[curr];
                } else if(color[curr] == color[v]){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int u, List<List<Integer>> adj, int[] color, int colour){
        color[u] = colour;

        for(int v: adj.get(u)){
            if(color[v] == -1){
                if(!dfs(v, adj, color, 1 - colour)){
                    return false;
                }
            } else if(color[v] == colour){
                return false;
            }
        }
        return true;
    }
}
