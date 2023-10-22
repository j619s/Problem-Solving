public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,1,5};
        int xor1 = 0;
        int xor2 = 0;

        for (int j : arr) {
            xor2 = xor2 ^ j;
        }

        for(int i = 1; i <= 5; i++){
            xor2 = xor2 ^ i;
        }

        System.out.println(xor2);

    }

    //1 ^ 2 ^ 3 ^ 4 ^ 5 - 2^3^1^5 = ?
}
