package LeetcodeDailyJune2024;
//Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
//
//A good subarray is a subarray where:
//
//its length is at least two, and
//the sum of the elements of the subarray is a multiple of k.
//
//Note that:
//
//A subarray is a contiguous part of the array.
//An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
//

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        System.out.println(checkSubarraySum(nums, k));
    }

    public static boolean checkSubarraySum(int[] nums, int k){
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++){
            prefix = (prefix + nums[i]) % k;

            if(map.containsKey(prefix)){
                if(i - map.get(prefix) > 1) return true;   // length is atleast 2
            } else {
                map.put(prefix, i);
            }
        }

        return false;
    }

}
