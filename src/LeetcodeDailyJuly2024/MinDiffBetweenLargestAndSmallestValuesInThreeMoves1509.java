package LeetcodeDailyJuly2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinDiffBetweenLargestAndSmallestValuesInThreeMoves1509 {
    public static void main(String[] args) {
        int[] nums = {1,5,0,10,14};
        System.out.println(minDifference(nums));
    }

    public static int minDifference(int[] nums){
        int len = nums.length;
        if(len <= 4) return 0;

        // finding the four smallest element using fixed-size max heap.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int x : nums){
            maxHeap.offer(x);
            if(maxHeap.size() > 4){
                maxHeap.poll();
            }
        }

        List<Integer> smallestFour = new ArrayList<>(maxHeap);
        Collections.sort(smallestFour);

        //finding the four largest element using a fixed-size min heap

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int x : nums){
            minHeap.offer(x);;
            if(minHeap.size() > 4){
                minHeap.poll();
            }
        }

        List<Integer> largestFour = new ArrayList<>(minHeap);
        Collections.sort(largestFour);

        int minDiff = Integer.MAX_VALUE;

        // four scenarios to compute the min difference
        for(int i = 0; i < 4; i++){
            minDiff = Math.min(minDiff, largestFour.get(i) - smallestFour.get(i));
        }

        return minDiff;
    }
}
