package LeetcodeDailyJuly2024;

import java.util.Arrays;

public class FindValidMatrixGivenRowAndColumnSum1605 {
    public static void main(String[] args) {
        int[] rowSum = {14,9};
        int[] colSum = {6,9,8};
        System.out.println(Arrays.deepToString(restoreMatrix(rowSum, colSum)));

    }
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;

        int[][] res = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            res[i][0] = rowSum[i];
        }

        int i = 0, j = 0;
        for(i = 0; i < cols; i++){
            int cSum = 0;
            for(j = 0; j < rows; j++){
                cSum += res[j][i];
            }

            j = 0;
            while(cSum > colSum[i]){
                int diff = cSum - colSum[i];
                int shift = Math.min(res[j][i], diff);

                res[j][i] -= shift;
                res[j][i + 1] += shift;
                cSum -= shift;
                j += 1;
            }
        }

        return res;
    }
}
