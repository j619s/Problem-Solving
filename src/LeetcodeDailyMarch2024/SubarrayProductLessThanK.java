package LeetcodeDailyMarch2024;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] arr = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(arr, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        //we will use the sliding window concept here.

        // if the product till a subarray[L..R] is less than k
        // then for all the subarrays before R, it will be less than k

        int count = 0;
        int start = 0;
        int prefixProd = 1;

        for(int end = 0; end < nums.length; end++){
            prefixProd *= nums[end];

            while(start < end && prefixProd >= k){
                prefixProd /= nums[start];
                start++;
            }

            count += end - start + 1;
        }
        return count;
    }
}
