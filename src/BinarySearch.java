import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {2,8,9,12};
        int x = 15;
        int lower_bound = Arrays.binarySearch(arr, x) + arr.length;
        System.out.println(lower_bound);
    }
}
