package DynamicProgramming;
//Problem statement
//
//You are given an array/list of ‘N’ integers. You are supposed to return the maximum sum of the subsequence with the constraint that no two elements are adjacent in the given array/list.
//        Note:
//
//A subsequence of an array/list is obtained by deleting some number of elements (can be zero) from the array/list, leaving the remaining elements in their original order.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//
//        1 <= T <= 500
//        1 <= N <= 1000
//        0 <= ARR[i] <= 10^5
//
//Where 'ARR[i]' denotes the 'i-th' element in the array/list.
//
//Time Limit: 1 sec.
//
//Sample Input 1:
//
//        2
//        3
//        1 2 4
//        4
//        2 1 4 9
//
//Sample Output 1:
//
//        5
//        11
//
//Explanation to Sample Output 1:
//
//In test case 1, the sum of 'ARR[0]' & 'ARR[2]' is 5 which is greater than 'ARR[1]' which is 2 so the answer is 5.
//
//In test case 2, the sum of 'ARR[0]' and 'ARR[2]' is 6, the sum of 'ARR[1]' and 'ARR[3]' is 10, and the sum of 'ARR[0]' and 'ARR[3]' is 11. So if we take the sum of 'ARR[0]' and 'ARR[3]', it will give the maximum sum of sequence in which no elements are adjacent in the given array/list.
//
//Sample Input 2:
//
//        2
//        5
//        1 2 3 5 4
//        9
//        1 2 3 1 3 5 8 1 9
//
//Sample Output 2:
//
//        8
//        24
//
//Explanation to Sample Output 2:
//
//In test case 1, out of all the possibilities, if we take the sum of 'ARR[0]', 'ARR[2]' and 'ARR[4]', i.e. 8, it will give the maximum sum of sequence in which no elements are adjacent in the given array/list.
//
//In test case 2, out of all the possibilities, if we take the sum of 'ARR[0]', 'ARR[2]', 'ARR[4]', 'ARR[6]' and 'ARR[8]', i.e. 24 so, it will give the maximum sum of sequence in which no elements are adjacent in the given array/list.
//

import java.util.Arrays;
import java.util.List;

public class MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        List<Integer> nums = Arrays.stream(arr).boxed().toList();
        System.out.println(nums);
        System.out.println(maximumNonAdjacentSum(nums));
    }

    public static int maximumNonAdjacentSum(List<Integer> nums){
        //return subsequence(nums.size() - 1, nums);

        //int[] dp = new int[nums.size()];
        //Arrays.fill(dp, -1);
        //return subsequence(nums.size() - 1, nums, dp);

        //return subsequence(nums);
        return subsequence(nums, nums.size());
    }
    // 1. Recursive Solution
    private static int subsequence(int idx, List<Integer> nums){
        if(idx == 0) return nums.get(idx);
        if(idx < 0) return 0;

        int pick = nums.get(idx) + subsequence(idx - 2, nums);
        int notPick = subsequence(idx - 1, nums);

        return Math.max(pick, notPick);
    }

    // 2. Memoization top-down
    private static int subsequence(int idx, List<Integer> nums, int[] dp){
        if(idx == 0) return nums.get(0);
        if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];

        int pick = nums.get(idx) + subsequence(idx - 2, nums, dp);
        int notPick = subsequence(idx - 1, nums, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    // 3. Tabulation bottom-up
    private static int subsequence(List<Integer> nums){
        int[] dp = new int[nums.size()];
        dp[0] = nums.get(0);

        for(int i = 1; i < nums.size(); i++){
            int pick = nums.get(i);
            if(i > 1) pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.size() - 1];
    }

    // 4. Tabulation bottom-up space optimised
    //  .       .       .       .       .       .       .       .       .       .       .
    //             dp[i - 2] dp[i - 1] curr[i]
    //              prev2       prev    curr

    private static int subsequence(List<Integer> nums, int len){
        int prev2 = nums.get(0);
        int prev = 0;

        for(int i = 1; i < nums.size(); i++){
            int pick = nums.get(i) ;
            if(i > 1) pick += prev2;
            int notPick = prev;

            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;

        }
        return prev;
    }
    



}




























