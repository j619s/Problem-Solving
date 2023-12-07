package sorting;

import java.util.Arrays;

public class CountingSortII {
    public static void main(String[] args) {

    }

    public static void countingSort(int[] arr){
        int shift = Arrays.stream(arr).min().getAsInt();
        int k = Arrays.stream(arr).max().getAsInt() - shift;
        int[] counts = new int[k + 1];
        for(int ele: arr){
            counts[ele - shift] += 1;
        }

        int startingIndex = 0;
        for(int i = 0; i < k + 1; i++){
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        int[] sortedArray = new int[arr.length];
        for(int elem: arr){
            sortedArray[counts[elem - shift]] = elem;

            counts[elem - shift] += 1;
        }

        System.out.println(Arrays.toString(sortedArray));
    }
}
