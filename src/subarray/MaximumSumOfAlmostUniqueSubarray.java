package subarray;

import java.util.*;

public class MaximumSumOfAlmostUniqueSubarray {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,2,3));
        System.out.println(maxSumII(nums, 3, 3));
    }
    public static long maxSum(List<Integer> nums, int m, int k) {
        long maxSum = 0;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++){
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            sum += nums.get(i);
        }

        int start = 0;
        for(int i = k; i < nums.size(); i++){
            map.put(nums.get(start), map.getOrDefault(nums.get(start), 0) - 1);
            sum -= nums.get(i);
            if(map.get(nums.get(start)) == 0){
                map.remove(nums.get(start));
            }
            start++;
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            sum += nums.get(i);

            if(map.size() >= m){
                maxSum = Math.max(sum, maxSum);
            }
        }
        return sum;
    }

    public static long maxSumII(List<Integer> nums, int m, int k) {
        long sum = 0;
        long maxSum = 0;
        int start = 0;
        Map<Integer, Integer> hash = new HashMap<>();

        for(int i = 0; i < k; i++){
            sum += nums.get(i);
            hash.put(nums.get(i), hash.getOrDefault(nums.get(i), 0) + 1);
        }

        if(hash.size() >= m){
            maxSum = Math.max(sum, maxSum);
        }
        for(int i = k; i <nums.size(); i++){
            while((i - start) == k){
                sum -= nums.get(start);
                hash.put(nums.get(start), hash.getOrDefault(nums.get(start), 0) - 1);
                if(hash.get(nums.get(start)) == 0){
                    hash.remove(nums.get(start));
                }
                start++;
            }

            sum += nums.get(i);
            hash.put(nums.get(i), hash.getOrDefault(nums.get(i), 0) + 1);
            if(hash.size() >= m){
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}
