import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //Approach 1:
//        int []arr = new int[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = sc.nextInt();
//        }
//        long steps = 0;
//        for(int i = 1; i < n; i++){
//            if(arr[i] < arr[i - 1]){
//                steps += arr[i-1] - arr[i];
//                arr[i] = arr[i - 1];
//            }
//        }
//
//        System.out.println(steps);
        long res = 0;
        int maxSoFar = 0;
        int[] arr ={3,2,5,1,7};
        for(int x: arr){
            maxSoFar = Math.max(x, maxSoFar);
            res += maxSoFar - x;
        }
        System.out.println(res);

    }
}
