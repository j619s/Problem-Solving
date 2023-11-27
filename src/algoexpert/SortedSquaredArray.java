package algoexpert;

import java.util.*;

class SortedSquaredArray {
    public static int[] sortedSquaredArray(int[] arr) {
        // Write your code here.
        int smallest = arr[0];
        int largest = arr[arr.length - 1];
        int[] output = new int[arr.length];

        int i = 0, j = arr.length - 1, k = arr.length - 1;
        while(i < j){
            if(Math.abs(smallest) <= Math.abs(largest)){
                output[k--] = largest * largest;
                j--;
                largest = arr[j];
            } else {
                output[k--] = smallest * smallest;
                i++;
                smallest = arr[i];
            }
        }

        if(i == j){
            output[k] = arr[i] * arr[i];
        }

        return output;
    }

    public static void main(String[] args){
        //int[] arr = {-10, -5, 0, 5, 10};
        int[] arr = {1, 2, 3, 5, 6, 8, 9};
        System.out.println(Arrays.toString(sortedSquaredArray(arr)));

    }
}

