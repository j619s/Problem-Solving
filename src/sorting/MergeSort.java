package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4,7,1,3,9,2,0,6};
        MergeSort sort = new MergeSort();
        sort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void merge(int[] arr, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l + 0, L, 0, n1);
        for(int j = 0; j < n2; j++){
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = l;

        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    public void sort(int[] arr, int l, int r){
        if(l < r) {


            int mid = l + (r - l) / 2;

            sort(arr, l, mid);
            sort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }
}
