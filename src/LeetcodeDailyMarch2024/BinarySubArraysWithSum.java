package LeetcodeDailyMarch2024;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArraysWithSum {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int goal = 3;
        System.out.println(numSubarrayWithSum(nums, goal));
    }


    //Approach 1: Using PREFIX_SUM
    public static int numSubarrayWithSum(int[] nums, int goal){
        int prefSum = 0;
        int count = 0;
        Map<Integer, Integer> prefSumFreq = new HashMap<>();
        prefSumFreq.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            prefSum += nums[i];

            if(prefSumFreq.containsKey(prefSum - goal)){
                count += prefSumFreq.get(prefSum - goal);
            }

            prefSumFreq.put(prefSum, prefSumFreq.getOrDefault(prefSum, 0) + 1);

        }

        return count;
    }

    // Approach 2: Sliding Window
    // Helper function to count the number of subarrays with sum at most the given goal
    private static int slidingWindowAtMost(int[] nums, int goal) {
        int start = 0, currentSum = 0, totalCount = 0;

        // Iterate through the array using a sliding window approach
        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];

            // Adjust the window by moving the start pointer to the right
            // until the sum becomes less than or equal to the goal
            while (start <= end && currentSum > goal) {
                currentSum -= nums[start++];
            }

            // Update the total count by adding the length of the current subarray
            totalCount += end - start + 1;
        }
        return totalCount;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
    }


}
