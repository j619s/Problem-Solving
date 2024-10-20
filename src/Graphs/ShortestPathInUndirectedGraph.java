package Graphs;
import java.util.*;

public class ShortestPathInUndirectedGraph {
    public static void main(String[] args) {
        // sample input
        //n = 9, m = 10
        //edges=[[0,1],[0,3],[3,4],[4,5],[5,6],[1,2],[2,6],[6,7],[7,8],[6,8]]
        // src=0

        //output: 0 1 2 1 2 3 3 4 4

    }
    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int u = curr[0];
            int currDist = curr[1];

            for(int v : adj.get(u)){
                if(currDist + 1 < dist[v]){
                    dist[v] = currDist + 1;
                    q.add(new int[]{v, currDist + 1});
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
    }
}
