package LeetcodeDailyJanuary2024;

import java.util.Arrays;

public class ClimbingStairs {
    int[] memo = new int[46];
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(45));
        System.out.println(Arrays.toString(climbingStairs.memo));
    }

    public int climbStairs(int n) {
        if(memo[n] == 0){
            int res;
            if(n == 1 || n == 2){
                return n;
            } else {
                res = climbStairs(n - 1) + climbStairs(n - 2);
            }

            memo[n] = res;
        }
        return memo[n];
    }
}
