package LeetcodeDailyMarch2024;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums){
        int len = nums.length;

        int[] leftProd = new int[len];
        leftProd[0] = 1;
        int[] rightProd = new int[len];
        rightProd[len - 1] = 1;

        for(int i = 1; i < len; i++){
            leftProd[i] = leftProd[i - 1] * nums[i - 1];
            rightProd[len - i - 1] = rightProd[len - i] * nums[len - i];
        }

        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            res[i] = leftProd[i] * rightProd[i];
        }
        return res;
    }
}
