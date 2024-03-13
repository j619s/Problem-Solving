package LeetcodeDailyJanuary2024;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {

    }

    public int[][] divideArray(int[] nums, int k){
        int len = nums.length;
        Arrays.sort(nums);
        int[][] res = new int[len/ 3][3];

        for(int i = 0; i < nums.length; i+= 3){
            if(nums[i + 2] - nums[i] > k){
                return new int[0][0];
            }
            res[i / 3] = new int[]{nums[i],nums[i + 1], nums[i + 2]};
        }
        return res;
    }
}
