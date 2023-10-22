import java.util.ArrayList;

public class Subsequences2 {
    public static int count = 0;
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9,0};

        printSubsequences(0, list, arr, arr.length);
        System.out.println("count of subsequences: " + count);
    }

    private static void printSubsequences(int index, ArrayList<Integer> list, int[] arr, int len){
        if(index == len){
            for(Integer element : list){
                //System.out.print(element + " ");
                count++;
            }

            if(list.size() == 0){
                //System.out.print("{}");
                count++;
            }
            //System.out.println();
            return;
        }
        list.add(arr[index]);
        printSubsequences(index + 1, list, arr, len);
        list.remove(list.size() - 1);

        printSubsequences(index + 1, list, arr, len);

    }
}
