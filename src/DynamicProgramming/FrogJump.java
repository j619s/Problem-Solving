package DynamicProgramming;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        System.out.println(frogJump(arr.length, arr));
    }

    public static int frogJump(int n, int[] heights) {
        //return recur(n - 1, heights);
        int[] dp = new int[n];

        //return memo(n - 1, heights, dp);
        //return recurDp(n, heights, dp);
        return recurDpII(n, heights);
    }

    public static int recur(int idx, int[] heights){
        if(idx == 0) return 0;

        int oneStep = recur(idx - 1, heights) + Math.abs(heights[idx] - heights[idx - 1]);
        int twoStep = Integer.MAX_VALUE;

        if(idx > 1){
            twoStep = recur(idx - 2, heights) + Math.abs(heights[idx] - heights[idx - 2]);
        }

        return Math.min(oneStep, twoStep);
    }
    // dp top-down
    public static int memo(int idx, int[] heights, int[] dp){
        if(dp[idx] != -1){
            return dp[idx];
        }
        if(idx == 0) return 0;

        int oneStep = memo(idx - 1, heights, dp) + Math.abs(heights[idx] - heights[idx - 1]);
        int twoStep = Integer.MAX_VALUE;

        if(idx > 1){
            twoStep = memo(idx - 2, heights, dp) + Math.abs(heights[idx] - heights[idx - 2]);
        }

        dp[idx] = Math.min(oneStep, twoStep);

        return dp[idx];
    }

    //dp bottom up
    public static int recurDp(int n, int[] heights, int[] dp){
        dp[0] = 0;

        for(int i = 1; i < n; i++){
            int oneStep = Integer.MAX_VALUE;
            int twoStep = Integer.MAX_VALUE;
            oneStep = dp[i - 1] + Math.abs(heights[i - 1] - heights[i]);
            if(i > 1){
                twoStep = dp[i - 2] + Math.abs(heights[i - 2] - heights[i]);
            }

            dp[i] = Math.min(oneStep, twoStep);
        }
        return dp[n - 1];
    }

    // space optimised bottom up
    public static int recurDpII(int n, int[] heights){
        int prev1 = 0;
        int prev2 = 0;

        for(int i = 1; i < n; i++){
            int oneStep = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int twoStep = Integer.MAX_VALUE;
            if(i > 1)
                twoStep = prev2 + Math.abs(heights[i] - heights[i - 2]);

            int curr = Math.min(oneStep, twoStep);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;

    }



}
