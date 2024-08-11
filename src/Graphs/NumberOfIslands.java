package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static final int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1,0}};

    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        boolean[][] visited  = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    res++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return res;
    }


    public void bfs(char[][] grid, boolean[][] visited, int row, int col){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row, col});
        visited[row][col] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for (int[] direction : directions) {
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];

                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                    q.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
}
