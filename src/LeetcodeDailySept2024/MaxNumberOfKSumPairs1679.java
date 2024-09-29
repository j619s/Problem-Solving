package LeetcodeDailySept2024;
import java.util.*;

public class MaxNumberOfKSumPairs1679 {
    public static void main(String[] args) {
        //int[] nums = {3,1,3,4,3};
        //int[] nums = {2,2,2,3,1,1,4,1};
        int[] nums = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k = 2;
        System.out.println(maxOperations(nums, k));
    }

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        System.out.println(map);
        //Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int ele = k - num;
            if(map.containsKey(ele) && map.containsKey(num)){
                if(num == ele && map.get(num).intValue() <= 1){
                    continue;
                }
                map.put(ele, map.get(ele).intValue() - 1);
                map.put(num, map.get(num).intValue() - 1);
                if(map.get(ele).intValue() == 0){
                    map.remove(ele);
                }
                if(map.get(num).intValue() == 0){
                    map.remove(num);
                }
                count++;
            }
        }

        return count;
    }
}
