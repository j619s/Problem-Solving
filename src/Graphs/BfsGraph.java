package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsGraph {
    public static final int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) {

    }

    public void bfs(List<List<Integer>> adj, int V, int s){
        boolean[] visited = new boolean[V + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int v : adj.get(u)){
                if (visited[v] == false){
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
    }
    // For disconnected graph:
    void BFSDis(List<List<Integer>> adj, int V){
        boolean[] visited = new boolean[V + 1];
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                bfs(adj, i, visited);
            }
        }

    }

    public void bfs(List<List<Integer>> adj, int s, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int v : adj.get(u)){
                if (visited[v] == false){
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
    }

    public void bfs(int[][] grid, int row, int col, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for(int[] dir : dirs){
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && !visited[newRow][newCol]){
                    q.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }

            }
        }


    }

    


}
