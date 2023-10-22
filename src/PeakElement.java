public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};

        System.out.println(binarySearch(arr));
    }

    public static int binarySearch(int @org.jetbrains.annotations.NotNull [] nums){

        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while(left < right){
            int mid = (left + right + 1) / 2;

            if(nums[mid - 1] > nums[mid]){
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return left;
    }
}
