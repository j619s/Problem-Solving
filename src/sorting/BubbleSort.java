package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        /*
        *     In this algorithm, traverse from left and compare adjacent elements
        *       and the higher one is placed at right side.
                In this way, the largest element is moved to the rightmost end at first.
                This process is then continued to find the second largest and
                place it and so on until the data is sorted.
        *
        *
        * */

        int[] arr = {1,2,3,4,5};
        boolean swapped;
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++){
            swapped = false;
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                    swapped = true;
                    count++;
                }

            }
            if(!swapped){
                break;
            }
        }
        System.out.println("Count: \t" + count);
        System.out.println(Arrays.toString(arr));
    }
}
