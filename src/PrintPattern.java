import java.util.*;

public class PrintPattern {
    public static void main(String[] args) {
        List<Integer> list = pattern(10);
        System.out.println(list);
    }

    static List<Integer> pattern(int N){
        List<Integer> list = new ArrayList<>();
        list.add(N);
        recur(list, N - 5, N, false);
        return list;
    }

    static void recur(List<Integer> list, int N, int temp, boolean flag){
        if(N == temp){
            list.add(N);
            return;
        }
        if(!flag){
            if(N <= 0){
                list.add(N);
                recur(list, N+5, temp, true);
            } else {
                list.add(N);
                recur(list, N - 5, temp, flag);
            }

        } else {
            list.add(N);
            recur(list, N + 5, temp, flag);
        }

    }
}
