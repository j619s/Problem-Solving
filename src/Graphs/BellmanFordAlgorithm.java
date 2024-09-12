package Graphs;

import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    // relax operation

    /*
    * if(dist[u] + wt < dist[v]){
    *   dist[v] = dist[u] + wt;
    * }
    * */

    //shortest path
    public int[] bellmanFordAlgorithm(int V, List<List<Integer>> edges, int s){
        //perform relax operation v- 1 times
        int[] res = new int[V];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[s] = 0;
        //O(E * V) - bellmann
        // O(ElogV) - dijkstra
        for(int i = 1; i <= V - 1; i++){
            for(List<Integer> edge: edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);

                if(res[u] != Integer.MAX_VALUE && res[u] + wt < res[v]){
                    res[v] = res[u] + wt;
                }
            }
        }

        // perform relax operation once more, if an edge gets relaxed then there's negative cycle present and return.

        for(List<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);

            if(res[u] != Integer.MAX_VALUE && res[u] + wt < res[v]){
                return new int[]{-1};
            }
        }
        return res;

    }
}
