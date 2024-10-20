package LeetcodeDailyOctober2024;

public class MaximumSwap670 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(maximumSwap(num));
    }

    public static int maximumSwap(int num) {
        int[] leftMin =  new int[2];
        leftMin[0] = Integer.MAX_VALUE;
        int[] rightMax = new int[2];
        rightMax[0] = Integer.MIN_VALUE;

        int digitCount =  (int)Math.floor(Math.log10(num) + 1);
        int[] arr = new int[digitCount];
        for(int i = digitCount - 1; i >= 0; i--){
            int ele = num % 10;
            arr[i] = ele;
            num /= 10;

            if(ele > rightMax[0] && i != 0){
                rightMax[0] = ele;
                rightMax[1] = i;
            }

            if(ele < leftMin[0] && i != digitCount - 1){
                leftMin[0] = ele;
                leftMin[1] = i;
            }

        }
        if(leftMin[1] < rightMax[1]){
            arr[leftMin[1]] = rightMax[0];
            arr[rightMax[1]] = leftMin[0];
        }


        StringBuilder res = new StringBuilder();
        for(int i = 0;i < digitCount; i++){
            res.append(arr[i]);
        }
        return Integer.parseInt(res.toString());
    }
}
