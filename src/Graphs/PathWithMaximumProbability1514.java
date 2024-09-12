package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaximumProbability1514 {
    public static void main(String[] args) {

    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end){
        // using dijkstra's algorithm
        List<List<List<Double>>> adj = new ArrayList<>();
        double[] res = new double[n];

        //make adj
        for(int i = 0;i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double wt = succProb[i];

            List<Double> neighbor = new ArrayList<>();
            neighbor.add((double) v);
            neighbor.add(wt);
            adj.get(u).add(neighbor);

            List<Double> reverseNeighbor = new ArrayList<>();
            reverseNeighbor.add((double) u);
            reverseNeighbor.add(wt);
            adj.get(v).add(reverseNeighbor);
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        pq.add(new double[]{1.0, (double)start});
        res[start]= 1;

        while(!pq.isEmpty()){
            double[] curr = pq.poll();
            int currNode = (int)curr[1];
            double currProb = curr[0];

            for(List<Double> neighbor : adj.get(currNode)){
                double newNode =  neighbor.get(0);
                double newProb = neighbor.get(1);

                if(newProb * currProb > res[(int)newNode]){
                    res[(int)newNode] = newProb * currProb;
                    pq.add(new double[]{res[(int)newNode], newNode});
                }
            }
        }

        return res[end];
    }
}
