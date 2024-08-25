package LeetcodeDailyAugust2024;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MaximumDistanceInArrays {
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(new ArrayList<>(Arrays.asList(1, 4)));
        arrays.add(new ArrayList<>(Arrays.asList(0, 5)));
//        System.out.println(arrays);
        System.out.println(maxDistance(arrays));
    }

    public static int maxDistance(List<List<Integer>> arrays){
        int maxEle = arrays.get(0).get(arrays.get(0).size() - 1);
        int minEle = arrays.get(0).get(0);
        int maxDistance = Integer.MIN_VALUE;

        for(int i = 1; i < arrays.size(); i++){
            List<Integer> curr = arrays.get(i);
            int currMax = curr.get(curr.size() - 1);
            int currMin = curr.get(0);

            maxDistance = Math.max(maxDistance, Math.max(Math.abs(currMax - minEle), Math.abs(maxEle - currMin)));
            maxEle = Math.max(maxEle, currMax);
            minEle = Math.min(minEle, currMin);

        }
        return maxDistance;
    }
}
