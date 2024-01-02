package sorting;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        long[] arr1 = {12, 42};
        long[] arr2 = {3, 4, 5, 28, 37, 42, 43, 46};
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

   public static void merge(long[] arr1, long[] arr2, int n, int m){
       int len = n + m;
       int gap = (len / 2) + (len % 2);  //len%2 is added for odd no.'s

       while(gap > 0){
           int left = 0;
           int right = left + gap;

           while(right < len){

               //case 1: arr1 and arr2
               if(left < n && right >= n){
                   swapIfGreater(arr1, arr2, left, right - n);
               } else if(left >= n){    //case 2: arr2 and arr2
                   swapIfGreater(arr1, arr2, left - n, right - n);
               } else {     //case 3: arr1 and arr1
                   swapIfGreater(arr1, arr2, left, right);
               }
               left++;
               right++;
           }
           if(gap == 1) break;
           gap = (gap / 2) + (gap % 2);
       }

   }

   public static void swapIfGreater(long[] arr1, long[] arr2, int idx1, int idx2){
        if(arr1[idx1] > arr2[idx2]){
            long temp = arr1[idx1];
            arr1[idx1] = arr2[idx2];
            arr2[idx2] = temp;
        }
   }

}
