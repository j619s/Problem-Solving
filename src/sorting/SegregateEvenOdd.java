package sorting;

import java.util.Arrays;

public class SegregateEvenOdd {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        //segregateEvenOdd(arr);
        segregateEvenOddLomuto(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void segregateEvenOdd(int[] arr){
        int i = 0;
        int j = arr.length - 1;

        while(i < j){
            while(i < arr.length && arr[i] % 2 == 0){
                i += 1;
            }

            while(j >= 0 && arr[j] % 2 != 0){
                j -= 1;
            }

            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void segregateEvenOddLomuto(int[] arr){

        int sliding_index = -1;

        for(int j = 0; j <= arr.length - 1; j++){
            if(arr[j] % 2 == 0){
                sliding_index = sliding_index + 1;
                int temp = arr[j];
                arr[j] = arr[sliding_index];
                arr[sliding_index] = temp;
            }
        }

    }
}
