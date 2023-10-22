import java.util.Arrays;

public class RearrangeArray {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {1,2,3,4,5,6};

        int lastIndex = n - 1;
        int firstIndex = 0;

        int max = arr[n - 1] + 1;

        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                arr[i] += (arr[lastIndex] % max) * max;
                lastIndex--;
            } else {
                arr[i] += (arr[firstIndex] % max) * max;
                firstIndex++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]/max + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]%max + " ");
        }
    }
}
