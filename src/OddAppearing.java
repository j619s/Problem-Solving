public class OddAppearing {
    public static void main(String[] args) {
        int [] arr = {3, 4, 3, 4, 5, 4, 4, 6, 7, 7};
        oddAppearing(arr, arr.length);
    }

    public static void oddAppearing(int []arr, int n){
        int res1 = 0, res2 = 0;
        int xor = 0;
        for(int i = 0; i < n; i++){
            xor = xor ^ arr[i];
        }
        System.out.println(xor);
        System.out.println("xor - 1: " + (xor - 1));//
        System.out.println("xor & ~xor - 1: " + (xor & ~(xor - 1)));
        // Doing `xor - 1` will flip the rightmost set bit and all the bits after that.
        //Now, we will flip all the bits of ~`xor - 1`.
        //xor & ~(xor - 1), performing this operation will negate all the bits and only the rightmost set bit will remain.

        int sn = xor & ~(xor - 1);
        System.out.println("sn: " + sn);
        // After we have obtained the rightmost set bit, we will divide the array into two parts.
        // Part I: all the elements whose rightmost set bit is same as `sn`.
        // Part II: all the elements whose rightmost set bit is same as `sn`.
        // Thus, by performing xor operation will get the required numbers.
        for (int i = 0; i < n; i++) {
            if ((arr[i] & sn) != 0){
                res1 = res1 ^ arr[i];
            } else {
                res2 = res2 ^ arr[i];
            }
        }

        System.out.println("res1: " + res1);
        System.out.println("res2: " + res2);

    }
}
