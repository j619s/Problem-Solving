package sorting;

import java.util.ArrayList;

public class Merge3SortedArrays {
    public static void main(String[] args) {
        int[] a = {8, 9, 10};
        int[] b = {1,2,3,4};
        int[] c = {1,2,3,6};
        merge(a, b, c);
    }

    public static void merge(int[] a, int[] b, int[] c){
        int lenA = a.length;
        int lenB = b.length;
        int lenC = c.length;
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j = 0, k = 0;
        while(i < lenA && j < lenB && k < lenC){
            if(a[i] <= b[j] && a[i] <= c[k]){
                list.add(a[i]);
                i++;
            } else if(b[j] <= a[i] && b[j] <= c[k]){
                list.add(b[j]);
                j++;
            } else {
                list.add(c[k]);
                k++;
            }
        }

        while(i < lenA && j < lenB){
            if(a[i] < b[j]){
                list.add(a[i]);
                i++;
            } else {
                list.add(b[j]);
                j++;
            }
        }

        while(j < lenB && k < lenC){
            if(b[j] < c[k]){
                list.add(b[j]);
                j++;
            } else {
                list.add(c[k]);
                k++;
            }
        }

        while(i < lenA && k < lenC){
            if(a[i] < c[k]){
                list.add(a[i]);
                i++;
            } else {
                list.add(c[k]);
                k++;
            }
        }

        while(i < lenA){
            list.add(a[i]);
            i++;
        }
        while(j < lenB){
            list.add(b[j]);
            j++;
        }
        while(k < lenC){
            list.add(c[k]);
            k++;
        }
        System.out.println(list);
    }
}
