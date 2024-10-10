package LeetcodeDailyOctober2024;

import java.util.*;

public class MaximumWidthRamp962 {
    public static void main(String[] args) {
        int[] nums = {6, 0, 8, 2, 1, 5};
        System.out.println(maxWidthRampIII(nums));
    }

    public static int maxWidthRamp(int[] nums){
        int n = nums.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        System.out.println(Arrays.toString(rightMax));
        // as we need to keep in mind the ramp condition
        // so if nums[left] > righMax[right], ramp condition not met
        // therefore no need to calc the width for other indexes for this nums[left]

        //For 6 0 8 2 1 5, when I know that for 0, right end of the ramp (let’s call it idx2) is 5,
        //I needn’t calculate it for numbers occurring between 0 and 5 for the case of idx2=5,
        // since their distance to 5 would anyway be less than the one between 0 and 5.

        int left = 0;
        int right = 0;
        int res = 0;
        while(right < n){
            while(left < right && nums[left] > rightMax[right]){
                left++;
            }
            res = Math.max(res, right - left);
            right++;
        }
        return res;
    }

    public static int maxWidthRampII(int[] nums) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(new int[]{nums[i], i});
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);

        int res = 0;
        int minIdx = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++){
            res = Math.max(res, list.get(i)[1] - minIdx);
            minIdx = Math.min(minIdx, list.get(i)[1]);
        }
        return res;
    }

    public static int maxWidthRampIII(int[] nums){
        int len = nums.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < len; i++){
            if(st.isEmpty() || nums[st.peek()] > nums[i]){
                st.push(i);
            }
        }
        int res = 0;
        System.out.println(st);
        for(int j = len - 1; j >= 0; j--){

        }
        return res;
    }
}
