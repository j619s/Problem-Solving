package LeetcodeDailyJuly2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindTheWinnerOfTheCircularGame1823 {
    public static void main(String[] args) {
        int n = 11;
        int k = 3;
        System.out.println(findTheWinner(n, k));
    }

    public static int findTheWinner(int n, int k){
        List<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            arr.add(i);
        }

        int idx = 0;
        while(arr.size() > 1){
            int removeIdx = (idx + k - 1) % arr.size();
            arr.remove(removeIdx);
            idx = removeIdx;
        }

        return arr.get(0);
    }

    public static int findTheWinnerII(int n, int k){

        // Initialize queue with n friends
        Queue<Integer> circle = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        // Perform eliminations while more than 1 player remains
        while (circle.size() > 1) {
            // Process the first k-1 friends without eliminating them
            for (int i = 0; i < k - 1; i++) {
                circle.add(circle.remove());
            }
            // Eliminate the k-th friend
            circle.remove();
        }

        return circle.peek();
    }

}
