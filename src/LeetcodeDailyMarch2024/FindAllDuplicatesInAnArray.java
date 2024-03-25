package LeetcodeDailyMarch2024;

import java.util.List;
import java.util.ArrayList;

public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int pos = Math.abs(nums[i]) - 1;
            if(nums[pos] < 0){
                list.add(Math.abs(nums[i]));
            } else {
                nums[pos] = -nums[pos];
            }
        }

        return list;
    }
}
