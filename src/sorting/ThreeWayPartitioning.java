package sorting;

import java.util.Arrays;

public class ThreeWayPartitioning {
    public static void main(String[] args) {
        int[] arr = {6,9,11,3,8,5,19,21};
        threeWay(arr, 7, 12);
        System.out.println(Arrays.toString(arr));
    }

    public static void threeWay(int[] arr, int l, int h){
        int begin = 0;
        int end = arr.length - 1;

        for(int i = 0; i <= end; i++){
            if(arr[i] < l){
                swap(arr, i, begin);
                begin++;
            } else if(arr[i] > h){
                swap(arr, i, end);
                i--;
                end--;
            }
        }
    }

    public static void swap(int[] arr, int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}
