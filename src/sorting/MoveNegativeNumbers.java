package sorting;

import java.util.Arrays;

public class MoveNegativeNumbers {
    public static void main(String[] args) {
        int[] arr = {2, -9, 10, 12, 5, -2, 10, -4, 0};
        moveNegativeNumbersLomuto(arr);
        //moveNegativeNumbersHoare(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveNegativeNumbersLomuto(int[] arr){
        int sliding_index = -1;

        for(int j = 0; j < arr.length; j++){
            if(arr[j] < 0){
                sliding_index++;
                int temp = arr[j];
                arr[j] = arr[sliding_index];
                arr[sliding_index] = temp;
            }
        }
    }

    public static void moveNegativeNumbersHoare(int[] arr){
        int i = 0;
        int j = arr.length - 1;

        while(i < j){
            while(i < arr.length && arr[i] < 0){
                i++;
            }

            while(j >= 0 && arr[j] > 0){
                j--;
            }

            if(i < j){
                int temp  = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
