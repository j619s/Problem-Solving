import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {1,2,3};

        HashSet<Integer> hash = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i : nums1){
            hash.add(i);
        }

        for(int j: nums2){
            if(hash.contains(j)){
                list.add(j);
            }
        }

        int[] res = new int[list.size()];
        int pos = 0;
        for(int k : list){
            res[pos++] = k;
        }
    }
}
