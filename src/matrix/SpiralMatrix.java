package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = { { 45, 48, 54 , 34}, { 21, 89, 87, 90 }, {70, 78, 15, 22} };
        System.out.println(snakePattern(arr));
    }

    public static List<Integer> snakePattern(int matrix[][]){
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++){
            if(i % 2 == 0){
                for(int j = 0; j < matrix[0].length; j++){
                    list.add(matrix[i][j]);
                }
            } else {
                for(int j = matrix[0].length - 1; j >= 0; j--){
                    list.add(matrix[i][j]);
                }
            }
        }

        return list;
    }



}
