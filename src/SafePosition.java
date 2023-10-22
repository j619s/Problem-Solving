import java.util.ArrayList;
import java.util.List;

public class SafePosition {
    public static void main(String[] args) {
        int res = safePos(2,1);
        System.out.println(res);
    }
    static int safePos(int n, int k) {
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i <n; i++){
            arr.add(i + 1);
        }

        return recur(arr, 0, k);

    }

    public static int recur(List<Integer> arr, int start, int k){
        if(arr.size() == 1){
            return arr.get(0);
        }

        start = ((start + k - 1) % arr.size());
        arr.remove(start);
        return recur(arr,start, k);
    }
}
