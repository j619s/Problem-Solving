package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUnweightedGraph {
    public static void main(String[] args) {

    }

    // shortest distance from source to every other vertex
    public void bfs(List<List<Integer>> adj, int s, boolean[] visited, int[] distance){
        distance[s] = 0;
        Queue<Integer> q =  new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while(!q.isEmpty()){
            
        }


    }
}
