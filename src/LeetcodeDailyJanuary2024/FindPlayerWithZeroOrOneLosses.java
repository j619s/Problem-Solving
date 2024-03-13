package LeetcodeDailyJanuary2024;
import java.util.*;
public class FindPlayerWithZeroOrOneLosses {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        System.out.println(findWinners(arr));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        TreeMap<Integer, Integer> lossCount = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < matches.length; i++){
            int loss = matches[i][1];
            int win = matches[i][0];
            lossCount.put(loss, lossCount.getOrDefault(loss, 0) + 1);
            lossCount.put(win, lossCount.getOrDefault(win, 0));
        }

        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> m : lossCount.entrySet()){
            if (m.getValue() == 0){
                res.get(0).add(m.getKey());
            } else if (m.getValue() == 1) {
                res.get(1).add(m.getKey());
            }
        }
        return res;

    }
}
