package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSorting {
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer> > adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(0, 2, adj);
        addEdge(0, 3, adj);
        addEdge(1, 3, adj);
        addEdge(1, 4, adj);
        addEdge(2, 3, adj);

        System.out.println("Following is a Topological Sort of");
        topologicalSort(adj,V);
        // topsort using dfs
        boolean[] visited = new boolean[V];
        List<Integer> topSort = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(adj, i, visited, topSort);
            }
        }

        // print the topsort list in the reverse order;

    }

    public static void addEdge(int u, int v, List<List<Integer>> adj){
        adj.get(u).add(v);
    }

    /*
    *  BFS based solution
    *  Create a Queue, q
    *  Add all the 0 indegree vertices to the q
    *  while(q is not empty){
    *       u = q.pop();
    *       print u
    *       for every adjacent v of u
    *       (i) reduce indegree of v by 1
    *       (ii) If indegree of v becomes 0, add v to the q
    *   }
    *
    * */

    static void topologicalSort(List<List<Integer>> adj, int V){
        int[] indegree = new int[V];
        for(int u = 0; u < V; u++){
            for(int v : adj.get(u)){
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int v : adj.get(u)){
                if(--indegree[v] == 0){
                    q.add(v);
                }
            }
        }

    }

    static void dfs(List<List<Integer>> adj, int u, boolean[] visited, List<Integer> topSort){
        visited[u] = true;
        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(adj, v, visited, topSort);
            }
        }
        topSort.add(u);

    }

}
