package LeetcodeDailyMarch2024;

public class CountSubarraysWhereMaxElementAppearsatLeastKTimes {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 3};
        int k  = 2;
        System.out.println(countSubarrays(arr, k));

    }

    public static long countSubarrays(int[] nums, int k) {
        int maxEle = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] > maxEle){
                maxEle = nums[i];
            }
        }

        int start = 0; long res = 0;
        int kCount = 0;
        for(int end = 0; end < nums.length; end++){

            if(nums[end] == maxEle){
                kCount++;
            }

            if(kCount == k){
                res += len - end + 1;
                while(start <= end && kCount >= k){
                    if(nums[start] == maxEle){
                        kCount--;
                    }
                    start++;
                }
            }


        }

        return res;

    }
}
