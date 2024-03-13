package LeetcodeDailyJanuary2024;
import java.util.*;
public class SetMismatch {
    public static void main(String[] args) {
        int[] arr = {1,1};
        System.out.println(findErrorNums(arr));
    }
    public static int[] findErrorNums(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for(int x : nums){
            if(hash.contains(x)){
                if(hash.contains(x - 1)){
                    return new int[]{x, x + 1};
                } else {
                    return new int[]{x, x - 1};
                }

            }
            hash.add(x);
        }

        return new int[]{};

    }
}
