package LeetcodeDailyJune2024;

public class MinimumNumberOfKConsecutiveBitFlips {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1,0,0,0,0};
        int k = 1;
        System.out.println(minKBitFlips(nums, k));
    }

    public static int minKBitFlips(int[] nums, int k){
        int flips = 0;

        int i = 0, j = 0;
        int len = nums.length;
        boolean hasZero = false;

        while(i < len && j < len){
            if(nums[j] == 0){
                hasZero = true;
            }
            if(hasZero && (j - i + 1) == k){
                flips++;
                hasZero = false;
                i = ++j;
            } else if(!hasZero &&(j - i + 1) == k){
                i = ++j;
            } else {
                j++;
            }
        }

        return flips == 0 ? -1 : flips;
    }
}
