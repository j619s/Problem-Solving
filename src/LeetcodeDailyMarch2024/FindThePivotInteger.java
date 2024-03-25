package LeetcodeDailyMarch2024;

public class FindThePivotInteger {
    public static void main(String[] args) {
        System.out.println(pivot(8));
    }
    //Approach 1: Two pointers.
    public static int pivot(int n){
        int left = 1;
        int right = n;
        int leftSum = left;
        int rightSum = right;

        while(left < right){
            if(leftSum < rightSum){
                leftSum += ++left;
            } else {
                rightSum += --right;
            }

            if(leftSum == rightSum && left + 1 == right - 1){
                return left + 1;
            }
        }

        return -1;
    }

    //Approach 2: totalSum - curr = tempSum; for curr to be pivot.
    public static int pivot2(int n){
        int sum = 0;
        for(int i = 1; i <= n ; i++){
            sum += i;
        }

        int temp = 0;
        for(int i = 1; i <= n; i++){
            sum -= i;
            if(sum == temp){
                return i;
            } else {
                temp += i;
            }

        }
        return -1;
    }
}
