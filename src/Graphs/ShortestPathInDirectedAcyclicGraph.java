package Graphs;

import java.util.*;

public class ShortestPathInDirectedAcyclicGraph {
    public static void main(String[] args) {
        int n = 10;
        int m = 24;
        int[][] edges = new int[m][3];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < 3; j++){
                edges[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.println(Arrays.toString(shortestPath(n, m, edges)));

    }

    private static void topSort(int u, List<List<int[]>> adj, boolean[] visited, Stack<Integer> st){
        visited[u] = true;

        for(int i = 0; i < adj.get(u).size(); i++){
            int v = adj.get(u).get(i)[0];
            if(!visited[v]){
                topSort(v, adj, visited, st);
            }
        }
        st.add(u);
    }

    public static int[] shortestPath(int n, int m, int[][] edges){
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                topSort(i, adj, visited, st);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[0] = 0;
        while(!st.isEmpty()){
            int u = st.pop();
            for(int[] neighbor: adj.get(u)){
                int v = neighbor[0];
                int wt = neighbor[1];
                if(dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for(int i = 0;i < n; i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }

        return dist;
    }
}
