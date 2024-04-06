package LeetcodeDailyApril2024;

public class WordSearch {
    private static final int[][] DIRS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, word));
    }

    public boolean exist(char[][] board, String word){
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, visited, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int r, int c, int i, boolean[][] visited, String word){
        if(i == word.length()){
            return true;
        }

        if(r < 0 || c < 0 ||r >= board.length || c >= board[0].length
                || word.charAt(i) != board[r][c] || visited[r][c]){
            return false;
        }

        visited[r][c] = true;
        boolean found = false;

        for(int[] dir : DIRS){
            if(dfs(board, r + dir[0], c + dir[1], i + 1, visited, word)){
                found = true;
                break;
            }
        }

        visited[r][c] = false;
        return found;
    }


}
