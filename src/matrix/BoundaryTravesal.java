package matrix;

import java.util.ArrayList;

public class BoundaryTravesal {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4}, { 5, 6, 7, 8 }, {9, 10, 11, 12}, {13, 14, 15, 16} };
        System.out.println(boundayTraversal(arr, arr.length, arr[0].length));
    }

    public static ArrayList<Integer> boundayTraversal(int[][] matrix, int n, int m){
        ArrayList<Integer> list = new ArrayList<>();

        // if number of row or col is 1
        if(n == 1){
            int j = 0;
            while(j < m){
                list.add(matrix[0][j++]);
            }
        } else if(m == 1){
            int i = 0;
            while(i < n){
                list.add(matrix[i++][0]);
            }
        } else {
            //traverse first row
            for(int j = 0; j < m; j++)
                list.add(matrix[0][j]);

            //traverse last col
            for(int i = 1; i < n; i++)
                list.add(matrix[i][m - 1]);

            //traverse last row
            for(int j = m - 2; j>= 0; j--)
                list.add(matrix[n - 1][j]);

            // traverse first column

            for(int i = n - 2; i >= 1; i--)
                list.add(matrix[i][0]);

        }
        return list;
    }
}
