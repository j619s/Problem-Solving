package sorting;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        long[] arr1 = {12, 42};
        long[] arr2 = {3, 4, 5, 28, 37, 42, 43, 46};
        merge(arr1, arr2, arr1.length - 1, arr2.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void merge(long[] arr1, long arr2[], int n, int m){
        int i = n;
        int j = 0;

        while(i >= 0 && j < m){
            if(arr1[i] > arr2[j]){
                long temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                j++;
            }
            i--;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    //Method2: Read about Shell sort.

}
