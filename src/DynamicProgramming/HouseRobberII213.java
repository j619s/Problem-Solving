package DynamicProgramming;

public class HouseRobberII213 {
    public static void main(String[] args) {

    }

//    public  long rob(int[] arr) {
//        int len = arr.length;
//        if (len == 1) return arr[0];
//        if (len == 2) return Math.max(arr[0], arr[1]);
//
//        // Function to compute the max sum from a linear range of houses
//        long robLinear(int[] arr, int start, int end) {
//            long[] dp = new long[len];
//            dp[start] = arr[start];
//            dp[start + 1] = Math.max(arr[start], arr[start + 1]);
//
//            for (int i = start + 2; i <= end; i++) {
//                dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
//            }
//
//            return dp[end];
//        }
//
//        // Rob houses excluding the last one and excluding the first one
//        long withoutLast = rob(arr, 0, len - 2);
//        long withoutFirst = rob(arr, 1, len - 1);
//
//        return Math.max(withoutFirst, withoutLast);
//    }

}
