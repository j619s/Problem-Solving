import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] a1 = {1,2,6};
        int[] a2 = {3,4};

        int[] mergedArray = new int[a1.length + a2.length];
        double median = 0.0;
        int i = 0, j = 0, k = 0;

        while(i < a1.length && j < a2.length){
            if(a1[i] <= a2[j]){
                mergedArray[k++] = a1[i];
                i++;
            } else {
                mergedArray[k++] = a2[j];
                j++;
            }
        }

        while(i < a1.length){
            mergedArray[k++] = a1[i];
            i++;
        }
        while(j < a2.length){
            mergedArray[k++] = a2[j];
            j++;
        }
        System.out.println(Arrays.toString(mergedArray));
    }
}
