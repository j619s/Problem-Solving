package Graphs;

import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {
    public static void main(String[] args) {

    }

    // Prim's Algorithm
    static int minimumSpanningTree(List<List<int[]>> adj, int V, int E){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] inMST = new boolean[V];
        pq.add(new int[]{0, 0});  // wt, node
        int sum = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currWt = curr[0];
            int currNode = curr[1];
            if(inMST[currNode]){
                continue;
            }
            inMST[currNode] = true;
            sum += currWt;
            for(int[] u : adj.get(currNode)){
                int neighborWt = u[0];
                int neighbor = u[1];

                if(!inMST[neighbor]){
                    pq.add(new int[]{neighborWt, neighbor});
                }
            }

        }
        return sum;
    }
    
}
