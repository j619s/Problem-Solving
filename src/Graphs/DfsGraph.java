package Graphs;
import java.util.List;
public class DfsGraph {
    public static void main(String[] args) {

    }

    void dfs(List<List<Integer>> adj, int V, int s){
        boolean[] visited = new boolean[V];
        dfsRec(adj, s, visited);
    }

    void dfsDis(List<List<Integer>> adj, int V){
        boolean[] visited = new boolean[V];
        for(int i = 0;i < V; i++){
            if(!visited[i]){
                dfsRec(adj, i, visited);
            }
        }
    }

    void dfsRec(List<List<Integer>> adj, int s, boolean[] visited){
        visited[s] = true;
        System.out.print(s + " ");
        for(int u : adj.get(s)){
            if(!visited[u]){
                dfsRec(adj, s, visited);
            }
        }
    }


}
