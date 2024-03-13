package LeetcodeDailyMarch2024;

public class FindThePivotInteger {
    public static void main(String[] args) {
        System.out.println(pivot(8));
    }

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
}
