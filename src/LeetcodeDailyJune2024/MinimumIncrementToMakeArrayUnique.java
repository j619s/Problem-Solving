package LeetcodeDailyJune2024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        int[] nums = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(nums));
    }
    //getting TLE
    public static int minIncrementForUnique(int[] nums){
        Arrays.sort(nums);
        Set<Integer> hash = new HashSet<>();
        int moves = 0;

        for(int i = 0; i < nums.length; i++){
             if(!hash.contains(nums[i])){
                 hash.add(nums[i]);
             } else {
                 int add = 1;
                 while(true){
                     if(hash.contains(nums[i] + add)){
                         add++;
                     } else {
                         hash.add(nums[i] + add);
                         moves += add;
                         break;
                     }
                 }
             }
        }

        return moves;
    }

    public static int minIncrementForUniqueII(int[] nums){
        Arrays.sort(nums);
        int moves = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i - 1]){
                moves += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }

        return moves;
    }

    //counting sort
    public static int minIncrementForUniqueIII(int[] nums){
        int max = Arrays.stream(nums).max().getAsInt();
        int moves = 0;
        int len = nums.length;

        int[] freq = new int[len + max];
        for(int x : nums){
            freq[x]++;
        }

        for(int i = 0; i < len; i++){
            if(freq[i] <= 1) continue;

            int duplicates = freq[i] - 1;
            freq[i + 1] += duplicates;
            freq[i] = 1;
            moves += duplicates;
        }

        return moves;
    }

}
