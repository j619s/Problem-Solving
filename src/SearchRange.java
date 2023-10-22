import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target = 3;
        System.out.println(Arrays.toString(new SearchRange().searchRange(arr, target)));
    }
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int pos = Arrays.binarySearch(nums, target);

        while(left <= right){

            int mid = left + (right - left) / 2;        //right = 4
            if(nums[mid] == target){
               // right = mid;
                if(mid == 0){
                    return new int[]{left, mid};
                }
                if(nums[mid - 1] != target){
                    return new int[]{mid, right};
                }
                right = mid;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[] {-1, -1};

    }
}
