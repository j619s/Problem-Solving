package Graphs;

import java.util.*;

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int V = sc.nextInt();
//        int E = sc.nextInt();
//
//        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
//        for(int i = 0; i < V; i++){
//            adj.add(new ArrayList<ArrayList<Integer>>());
//        }

    }

    //shortest path.

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        int[] res = new int[V];
        Arrays.fill(res, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        res[s] = 0;
        pq.add(new int[]{0, s});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currDistance = curr[0];
            int currNode = curr[1];
            for(ArrayList<Integer> neighbour  : adj.get(currNode)){
                int newNode = neighbour.get(0);
                int dist = neighbour.get(1);

                if(currDistance + dist < res[newNode]){     // relax operation
                    pq.remove(new int[]{res[newNode], newNode});
                    res[newNode] = currDistance + dist;
                    pq.add(new int[]{currDistance + dist, newNode});
                }
            }
        }

        return res;
    }

}
