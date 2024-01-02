package hashing;

import java.util.HashMap;
import java.util.Map;
public class ZeroSumSubarrays {
    public static void main(String[] args) {
        long[] arr = {0,0,5,5,0,0};
        System.out.println(findSubarray(arr, arr.length));
    }

    public static long findSubarray(long[] arr, int n){
        Map<Long, Integer> map = new HashMap<>();
        long prefixSum = 0;
        long count = 0;

        for(long x : arr){
            prefixSum += x;

            if(prefixSum == 0){
                count++;
            }

            if(map.containsKey(prefixSum)){
                count += map.get(prefixSum);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
