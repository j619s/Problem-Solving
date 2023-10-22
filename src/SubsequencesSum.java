import java.util.ArrayList;

public class SubsequencesSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int k = 10;
        ArrayList<Integer> list = new ArrayList<>();
        SubsequencesSum sum = new SubsequencesSum();
        int count = sum.subsequenceSum(0, list, arr, 6, k, 0);
        System.out.println("count: " + count);
    }

    public int subsequenceSum(int index, ArrayList<Integer> list, int [] arr, int len, int k, int sum) {

        if(index == len){
            if(sum == k) {
                System.out.println(list);
                return 1;
            }
            return 0;
        }

        sum += arr[index];
        list.add(arr[index]);
        int left = subsequenceSum(index + 1, list, arr, len , k, sum); //considering the element.
        sum -= list.get(list.size() - 1);
        list.remove(list.size() - 1);
        int right = subsequenceSum(index + 1, list, arr, len, k, sum);  //leaving the element.

        return left + right;
    }
}
