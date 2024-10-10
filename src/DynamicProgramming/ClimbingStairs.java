package DynamicProgramming;

public class ClimbingStairs {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 40;
        int[] memo = new int[n + 1];
        System.out.println(climbStairsII(n, memo));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    public static int climbStairs(int n){
        if(n == 1 || n == 2) return n;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairsII(int n, int[] memo){
        if(memo[n] == 0){
            int res;
            if(n == 1 || n == 2){
                return n;
            } else {
                res = climbStairsII(n - 1, memo) + climbStairsII(n - 2, memo);
            }
            memo[n] = res;
        }
        return memo[n];
    }
    /*
    *  1. try to represent problem in terms of index
    *  2. do all possible operation on that index as per the problem statement
    *  3. Sum of all the operations, or take min or max of all operations as per the problem statement.
    * */

    public int climbStairsIII(int n){
        //dp bottom up

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

//    public int climbStairsIV(int n){
//        if(n <= 1) return 1;
//
//        int prev1 = 1;
//        int prev2 = 2;
//        int res = 1;
//        for(int i = 3; i <= n; i++){
//            res = prev
//        }
//    }
}
