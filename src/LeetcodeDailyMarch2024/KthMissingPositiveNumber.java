package LeetcodeDailyMarch2024;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }
    /*
            You need few observations

            For.eg. array = [3,4,9,10,12,13] , k=4

            If no element was missing, indices of numbers would've been 1 less than the number.
            [1,2,3,4,5,6,7,8,9,10,11,12,13]. Here, index of 1 is 0, of 2 is 1, of 3 is 2 and so on.
            We can calculate total missing values to the left of any number in O(1) by subtracting its index
            in the array from index it would have in the array with no missing numbers.
            Obviously the difference is equal to the total missing numbers. For. eg,
                4 has 2 missing numbers to its left in the example array [1,2]. Calculation (4-1) - 1 = 2
                9 has 6 missing numbers to its left [1,2,5,6,7,8]. Calculation (9-1) - 2 = 6
            As we have a sorted array and we need to find two numbers between which we will find our missing number,
            we will use Binary search Technique

         */
    public static int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] - mid <= k){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + k;

    }


}
