import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] intersect(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums1){
                map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int j : nums2){
            if(map.containsKey(j) && map.get(j) >= 1){
                list.add(j);
                map.put(j, map.get(j) - 1);
            }
        }
        int[] res = new int[list.size()];
        int pos = 0;
        for(int i : list){
            res[pos++] = i;
        }
        return res;
    }
}
