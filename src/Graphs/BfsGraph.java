package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsGraph {
    public static void main(String[] args) {

    }

    public void bfs(List<List<Integer>> adj, int V, int s){
        boolean[] visited = new boolean[V + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int v : adj.get(u)){
                if (visited[v] == false){
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
    }
    // For disconnected graph:
    void BFSDis(List<List<Integer>> adj, int V){
        boolean[] visited = new boolean[V + 1];
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                bfs(adj, i, visited);
            }
        }

    }

    public void bfs(List<List<Integer>> adj, int s, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int v : adj.get(u)){
                if (visited[v] == false){
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
    }
}
