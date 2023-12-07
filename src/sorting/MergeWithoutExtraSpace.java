package sorting;

import java.time.LocalDate;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        long[] arr1 = {12, 42};
        long[] arr2 = {3, 4, 5, 28, 37, 42, 43, 46};

    }

    public static void merge(long[] arr1, long[] arr2, int n, int m){
        int len = n + m;
        int gap = (len / n) + (len % n);

        while(gap > 0){
            
        }

    }


    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2){
        if(arr1[ind1] > arr2[ind2]){

            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }








//Method2: Read about Shell sort.


//    public static void merge(long[] arr1, long arr2[], int n, int m){
//        int i = n;
//        int j = 0;
//
//        while(i >= 0 && j < m){
//            if(arr1[i] > arr2[j]){
//                long temp = arr1[i];
//                arr1[i] = arr2[j];
//                arr2[j] = temp;
//                j++;
//            }
//            i--;
//        }
//
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//    }



}
