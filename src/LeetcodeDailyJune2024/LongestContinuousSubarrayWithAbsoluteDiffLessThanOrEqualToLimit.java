package LeetcodeDailyJune2024;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    //Given an array of integers nums and an integer limit,
    // return the size of the longest non-empty subarray such that
    // the absolute difference between any two elements of this subarray is less than or equal to limit.
    public static void main(String[] args) {
        int[] arr= {8,5,6,16,3,9};
        int limit = 3;
        System.out.println(new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().longestSubarray(arr, limit));
    }


    // sliding window to find the valid subarray
    // inorder for it to be a valid subarray
    // we will check by subtracting the abs(minValue - maxValue) in that subarray
    // if its < limit, then it is valid
    // else we start removing the elements from left, until the array becomes valid.


    // Now, how to find the minValue and maxValue of a particular subarray,
    // when the elements from right are being added?


    //Approach 1: Using maxHeap and minHeap


    public int longestSubarray(int[] nums, int limit){
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[0] - a[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));


        int left = 0, maxLength = 0;

        for(int right = 0; right < nums.length; right++){
            maxHeap.offer(new int[]{nums[right], right});
            minHeap.offer(new int[]{nums[right], right});

            while(maxHeap.peek()[0] - minHeap.peek()[0] > limit){

                // move the left ptr until the condition is satisfied
                //If the absolute difference between these values exceeds the limit,
                //we move the left pointer to exclude the element with the lower index.
                // This removes the violating element from the window.
                left = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;

                while(maxHeap.peek()[1] < left){
                    maxHeap.poll();
                }
                while(minHeap.peek()[1] < left){
                    minHeap.poll();
                }

            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }







}
