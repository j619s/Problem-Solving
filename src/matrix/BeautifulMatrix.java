package matrix;

public class BeautifulMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3}, {4,2,3}, {3,2,1}};
        int[][] matrix ={{4,1},{4,1}};
        System.out.println(findMinOperation(matrix, matrix.length));
    }

    public static int findMinOperation(int[][] matrix, int n){

        int[] sumRow = new int[n];
        int[] sumCol = new int[n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                sumRow[i] += matrix[i][j];
                sumCol[j] += matrix[i][j];
            }
        }

        int maxSum = 0;
        for (int i = 0; i < n; ++i)
        {
            maxSum = Math.max(maxSum, sumRow[i]);
            maxSum = Math.max(maxSum, sumCol[i]);
        }

        int operations = 0;

        for(int s: sumRow){
            operations += maxSum - s;
        }


        return operations;

    }



}
