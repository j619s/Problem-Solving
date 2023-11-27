package sorting;


import java.util.Arrays;

public class HoarePartition {

    /*
    * The pivot is always the first element of the array.
    *
    * Initialize two pointers L and H where L is for the element at the smallest
    * index and the other, H is for the element at the highest index.
    *
    * The pivot is the element at the smallest index.
    *  3. Do this:
    *  3.1 Keep increasing L while arr[i] < pivot.
    *  3.2 Keep decreasing H while arr[j] > pivot.
    *  3.3 If i >= j, return j.
    *  3.4If i < j, swap arr[i] and arr[j] and continue step 3.
    *
    * */
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int parti = partition(arr,low, high);
            quickSort(arr, low, parti);
            quickSort(arr, parti + 1, high);
        }
    }

    public static int partition(int[] arr, int l, int h){
        int pivot = arr[l];
        int i = l - 1;
        int j = h + 1;

        while(true){
            do{
                i++;
            } while (arr[i] < pivot);

            do{
                j--;
            } while (arr[j] > pivot);

            if(i >= j){
                return j;
            }

            swap(arr, i, j);

        }


    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
