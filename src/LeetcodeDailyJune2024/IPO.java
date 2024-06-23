package LeetcodeDailyJune2024;
import java.util.*;
public class IPO {
    public static void main(String[] args) {
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 2};
        int k = 3;
        int w = 3;
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital){
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(projects));
        int idx = 0;
        PriorityQueue<Integer> maxCapital = new PriorityQueue<>(Collections.reverseOrder());
        while(k-- > 0){
            while(idx < n && projects[idx][0] <= w){
                maxCapital.offer(projects[idx][1]);
                idx++;
            }

            if(maxCapital.isEmpty()){
                break;
            }

            w += maxCapital.poll();
        }

        return w;
    }
}
