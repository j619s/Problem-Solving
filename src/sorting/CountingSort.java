package sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        countingSort(arr);
    }

    // Sorts an array of integers where minimum value is 0 and maximum value is K
    public static void countingSort(int[] arr){
        //this will return maximum element in the array.
        int k = Arrays.stream(arr).max().getAsInt();
        System.out.println(k);

        int[] counts = new int[k + 1];
        for(int ele : arr){
            counts[ele] += 1;
        }
        System.out.println(Arrays.toString(counts));
        // we now overwrite our original counts with the starting index
        // of each element in the final sorted array
        int startingIndex = 0;
        for(int i = 0; i < k + 1; i++){
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        System.out.println(Arrays.toString(counts));

        int[] sortedArray = new int[arr.length];
        for(int elem: arr){
            sortedArray[counts[elem]] = elem;
            // since we have placed an item in index counts[elem], we need to
            // increment counts[elem] index by 1 so the next duplicate element
            // is placed in appropriate index
            counts[elem] += 1;
        }

        System.out.println(Arrays.toString(sortedArray));

    }
}
