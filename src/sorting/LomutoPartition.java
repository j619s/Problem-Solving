package sorting;

import java.util.Arrays;

public class LomutoPartition {
    public static void main(String[] args) {
        int[] arr = {4,2,7,3,1,9,6,0,8};
        System.out.println(Arrays.toString(arr));
        //quicksort(arr, 0, arr.length - 1);
        int parti = partition(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(parti);
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j <= high - 1; j++){
            if(pivot >= arr[j]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[high];
        arr[high] = arr[i+1];
        arr[i+1] = temp;

        return i+1;
    }

//    public static void quicksort(int[] arr, int low, int high){
//        if(low < high){
//            int part = partition(arr, low, high);
//            quicksort(arr, low, part - 1);
//            quicksort(arr, part + 1, high);
//        }
//    }
}
