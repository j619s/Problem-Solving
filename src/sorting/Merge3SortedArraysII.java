package sorting;

import java.util.ArrayList;

public class Merge3SortedArraysII {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {1,2,3,4,5};
        int[] c = {1,2,3,4,5,6};
        merge2(a, b, c);
    }

    public static void merge2(int[] a, int[] b, int[] c) {
        int lenA = a.length;
        int lenB = b.length;
        int lenC = c.length;
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        while(i < lenA || j < lenB || k < lenC){
            // Assigning a, b, c with max values so that if
            // any value is not present then also we can
            // sort the array.
            int aVal = Integer.MAX_VALUE;
            int bVal = Integer.MAX_VALUE;
            int cVal = Integer.MAX_VALUE;

            if(i < lenA){
                aVal = a[i];
            }
            if(j < lenB){
                bVal = b[j];
            }
            if(k < lenC){
                cVal = c[k];
            }

            if(aVal <= bVal && aVal <= cVal){
                list.add(aVal);
                i++;
            }else if(bVal <= aVal && bVal <= cVal){
                list.add(bVal);
                j++;
            } else if(cVal <= aVal && cVal <= bVal){
                list.add(cVal);
                k++;
            }

        }
        System.out.println(list);
    }

}
