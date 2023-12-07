import java.util.ArrayList;
import java.util.Collections;

public class UpperAndLowerBound {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(8);
        list.add(5);
        Collections.sort(list);
        int upperBound = upperBound(list, 3);
        System.out.println(list);
        System.out.println(upperBound);
    }

    // The upper bound will give us the iterator pointing to the first element
    // greater than the value passed as a parameter.
    public static int upperBound(ArrayList<Integer> arr, int k){
        //smallest index such that arr[ind] > k

        int low = 0;
        int high = arr.size() - 1;
        int ans = arr.size();

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr.get(mid) > k){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int[] twoNumberSum(){
        return new int[]{2,4};
    }
}
