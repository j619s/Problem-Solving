package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponents {
    public static void main(String[] args) {

    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int connectedComponents = 0;

        // get the topological order of the original adj in stack
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfsTopsort(adj, i, visited, stack);
            }
        }

        // reverse the directed graph
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();

        // count the connected components by calling dfs in topological order on the reversed graph


        return connectedComponents;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited){
        visited[u] = true;
        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(adj, v, visited);
            }
        }
    }

    public void dfsTopsort(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, Stack<Integer> st){
        visited[u] = true;
        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(adj, v, visited);
            }
        }
        st.add(u);
    }

}
