public class CircularSubArraySum {
    public static void main(String[] args) {

    }

    int nomralKadane(int[] arr, int n){
        int res = arr[0];
        int maxSub = arr[0];

        for(int i = 1; i < n; i++){
            maxSub = Math.max(res, maxSub+arr[i]);
            res = Math.max(res, maxSub);
        }
        return res;
    }
}
