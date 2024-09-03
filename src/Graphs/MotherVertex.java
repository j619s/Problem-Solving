package Graphs;

import java.util.List;
import java.util.Stack;

public class MotherVertex {
    public static void main(String[] args) {

    }

    private int motherVertex(int V, List<List<Integer>> adj){
        boolean[] visited = new boolean[V];
        int  c = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < V; i++) {
            if(!visited[i]){
                dfs(adj, i, visited,stack, c);
            }
        }
        checkIfMotherVertex(adj, visited, stack.peek(), c);
        if(c == V){
            return stack.peek();
        } else {
            return -1;
        }

    }
    private void checkIfMotherVertex(List<List<Integer>> adj, boolean[] visited, int u, int c){
        visited[u] = true;
        c++;
        for(int v : adj.get(u)){
            if(!visited[v]){
                checkIfMotherVertex(adj, visited, v, c);
            }
        }
    }

    private void dfs(List<List<Integer>> adj, int u, boolean[] visited, Stack<Integer> stack, int c) {
        visited[u] = true;
        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(adj, v, visited, stack, c);
            }
        }
        stack.push(u);
    }
}
