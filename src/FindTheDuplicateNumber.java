public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};
        int sum = 0;
        int sum2 = 0;
        for(int i : arr){
            sum += arr[i];
            sum2 += i;
        }
        System.out.println("Sum: " + sum + "\n\n" + "Sum2: " + sum2);
        /*

            1 2 3 4 5 = 15
                         -   =3 arr[3] = 2
            1 3 4 2 2 = 12



        */

    }
}
