package LeetcodeDailyJune2024;
import java.util.*;
public class CountNumberOfNiceSubarrays1248 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(new CountNumberOfNiceSubarrays1248().numberOfSubarrays(nums, k));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int currSum = 0;
        int subArrayCount = 0;

        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(currSum, 1);

        for(int i = 0; i < nums.length; i++){
            currSum += nums[i] % 2;

            if(prefixSum.containsKey(currSum - k)){
                subArrayCount += prefixSum.get(currSum - k);
            }

            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        }
        return subArrayCount;
    }
}
