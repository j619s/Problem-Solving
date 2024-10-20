package LeetcodeDailyOctober2024;

import java.util.*;
public class MaximalScoreAfterApplyingKOperations { // leetcode 2530
    public static void main(String[] args) {
        int[]arr = {1, 10, 3, 3, 3};
        int k = 3;
        System.out.println(maxKelements(arr, k));
    }
    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // max heap
        long res = 0;
        for(int x : nums){
            pq.offer(x);
        }

        while(k != 0){
            int curr = pq.poll();
            System.out.print(curr+" ");
            res += curr;
            curr = (int)Math.ceil(((double)curr / 3));
            pq.add(curr);
            k--;
        }

        return res;
    }
}
