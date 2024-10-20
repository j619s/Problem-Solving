package DynamicProgramming;

import java.util.Arrays;

public class FrogJumpKDistance {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(jumpFrog(arr.length, arr, dp, arr.length - 1, 2));
        System.out.println(jumpFrogII(arr.length, arr, 2));
    }
    // bottom-up memoization
    public static int jumpFrog(int n, int[] heights, int[] dp, int idx, int k){
        if(idx == 0) return 0;

        if(dp[idx] != -1){
            return dp[idx];
        }

        int minSteps = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++){
            if(idx - j >= 0){
                int jump = jumpFrog(n, heights, dp, idx - j, k) + Math.abs(heights[idx - j] - heights[idx]);
                minSteps = Math.min(minSteps, jump);

            }
        }
        dp[idx] = minSteps;
        return dp[idx];
    }

    //top-down dp
    public static int jumpFrogII(int n, int[] heights, int k){
        int[] dp = new int[n];
        dp[0] = 0;

        for(int i = 1; i < n; i++){
            int minSteps = Integer.MAX_VALUE;

            for(int j = 1; j <= k; j++){
                if(i - j >= 0){
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }

        return dp[n - 1];
    }

}
