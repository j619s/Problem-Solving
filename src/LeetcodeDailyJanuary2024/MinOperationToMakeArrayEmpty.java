package LeetcodeDailyJanuary2024;

import java.util.HashMap;
import java.util.Map;

public class MinOperationToMakeArrayEmpty {
    public static void main(String[] args) {
        int[] nums = {14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        System.out.println(map);
        int minOperations = 0;
        int removed = 0;

        for(Map.Entry<Integer, Integer> m1: map.entrySet()){
            if(m1.getValue() == 1){
                return -1;
            }
            minOperations += Math.ceil((double)m1.getValue() / 3);
        }

        return minOperations;
    }
}
