package hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithSumK {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int k = 3;
        System.out.println(subArraySum(arr, arr.length, k));
    }

    static int subArraySum(int[] arr, int n, int k){
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int prefSum = 0;
        freq.put(0, 1);
        for(int x : arr){
            prefSum += x;

            if(freq.containsKey(prefSum - k)){
                count += freq.get(prefSum - k);
            }

            freq.put(prefSum, freq.getOrDefault(prefSum, 0) + 1);
            System.out.println(freq);
        }

        return count;
    }
}
