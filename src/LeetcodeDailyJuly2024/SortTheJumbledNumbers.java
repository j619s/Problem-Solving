package LeetcodeDailyJuly2024;
import java.util.*;
public class SortTheJumbledNumbers {

    public static void main(String[] args) {
        int[] arr = {13160};
        int[] mapping = {9,7,0,6,2,3,1,4,5,8};
        System.out.println(Arrays.toString(sortJumbled(mapping, arr)));
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> originalToNew = new LinkedHashMap<>();
        int len = nums.length;

        for(int i = 0; i < len; i++){
            int ele = nums[i];
            int place = 1;
            int mappedValue = 0;

            if(ele == 0){
                originalToNew.put(ele, mapping[ele]);
                continue;
            }

            while (ele != 0) {
                mappedValue = place * mapping[ele % 10] + mappedValue;
                place *= 10;
                ele /= 10;
            }
            originalToNew.put(nums[i], mappedValue);

        }
        System.out.println(originalToNew);
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(originalToNew.entrySet());
        Collections.sort(list, (a, b) ->{
            return Integer.compare(a.getValue(), b.getValue());
        });

        int[] res = new int[len];
        int idx = 0;
        for(Map.Entry<Integer, Integer> m : list){
            res[idx++] = m.getKey();
        }

        return res;

    }
}
