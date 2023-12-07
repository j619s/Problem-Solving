import java.util.Arrays;
import java.util.Scanner;

public class TrainBooking {
    public static void main(String[] args) {
        int N = 5;
        int K = 3;
        int bookingLength = 3;
        Scanner sc = new Scanner(System.in);
        int[][] booking = new int[K][bookingLength];
        for(int i = 0; i < booking.length; i++){
            for(int j = 0; j < booking[0].length; j++){
                booking[i][j] = sc.nextInt();
            }
        }

        int[] res = solve(N, K, bookingLength, booking);
        System.out.println(Arrays.toString(res));
    }

//    public static int[] solve(int N, int K, int bookingLength, int[][] booking){
//        int[] result = new int[N + 1];
//        int idx = 0;
//
//        for(int i = 0; i < booking.length; i++){
//            int start = booking[i][0];
//            int end = booking[i][1];
//            int booked = booking[i][2];
//            while(start <= end){
//                result[start] += booked;
//                start++;
//            }
//        }
//
//        return result;
//    }

    public static int[] solve(int N, int K, int bookingLength, int[][] booking){
        int[] result = new int[N + 1];

        int[] prefixSum = new int[N + 2];

        for(int i = 0; i < bookingLength; i++){
            int start = booking[i][0];
            int end = booking[i][1];
            int booked = booking[i][2];

            prefixSum[start] += booked;
            prefixSum[end + 1] -= booked;
            System.out.println(Arrays.toString(prefixSum));
        }
        System.out.println(Arrays.toString(prefixSum));
        int currentSum = 0;
        for(int i = 1; i <= N; i++){
            currentSum += prefixSum[i];
            result[i] = currentSum;
        }
        return result;
        //[0, 10, 55, 45, 25, 25]
//        1
//        2
//        10
//        2
//        3
//        20
//        2
//        5
//        25
    }

}
