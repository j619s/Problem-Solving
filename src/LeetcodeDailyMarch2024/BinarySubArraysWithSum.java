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



}
