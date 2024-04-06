package LeetcodeDailyMarch2024;

public class CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 2, 7, 5};
        int minK = 1;
        int maxK = 5;
        System.out.println(countSubarrays(nums, minK, maxK));
    }

    public static long countSubarrays(int[] nums, int minK, int maxK){
        int len = nums.length;
        int start = 0;
        long res = 0;
        boolean minFlag = false;
        boolean maxFlag = false;

        int minStart = 0;
        int maxStart = 0;

        for(int end = 0; end < len; end++){
            if(nums[end] < minK || nums[end] > maxK){
                minFlag = false;
                maxFlag = false;
                start = end + 1;
            }

            if(nums[end] == minK){
                minFlag = true;
                minStart = end;
            }
            if(nums[end] == maxK){
                maxFlag = true;
                maxStart = end;
            }

            if(minFlag && maxFlag){
                res += Math.min(minStart, maxStart) - start + 1;
            }

        }
        return res;
    }
}







