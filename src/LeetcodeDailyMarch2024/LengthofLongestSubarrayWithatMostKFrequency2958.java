package LeetcodeDailyMarch2024;

import java.util.HashMap;
import java.util.Map;

public class LengthofLongestSubarrayWithatMostKFrequency2958 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,3,1,2};
        int k = 2;
        System.out.println(maxSubarrayLength(arr, k));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
            int res  = 0;
            Map<Integer, Integer> freq = new HashMap<>();
            int start = 0;

            for(int end = 0; end < nums.length; end++){
                freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);

                while(freq.get(nums[end]) > k){
                    freq.put(nums[start], freq.get(nums[start]) - 1);
                    start++;
                }

                res = Math.max(res, end - start + 1);

            }

            return res;
    }
}