package LeetcodeDailyJune2024;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        int[] difficulty = {66,1,28,73,53,35,45,60,100,44,59,94,27,88,7,18,83,18,72,63};
        int[] profit = {66,20,84,81,56,40,37,82,53,45,43,96,67,27,12,54,98,19,47,77};
        int[] worker = {61,33,68,38,63,45,1,10,53,23,66,70,14,51,94,18,28,78,100,16};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        Map<Integer, Integer> difficultyToProfitMap = new TreeMap<>();

        for(int i = 0; i < profit.length; i++){
            int max = Math.max(profit[i], difficultyToProfitMap.getOrDefault(difficulty[i], -1));
            difficultyToProfitMap.put(difficulty[i], max);
        }
        System.out.println(difficultyToProfitMap);
        int maxProfitTillHere = 0;
        for(Map.Entry<Integer, Integer> entry : difficultyToProfitMap.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            maxProfitTillHere = Math.max(maxProfitTillHere, val);
            difficultyToProfitMap.put(key, maxProfitTillHere);
        }
        System.out.println(difficultyToProfitMap);

        Arrays.sort(difficulty);
        for(int i = 0; i < worker.length; i++){
            int work = worker[i];
            if(difficultyToProfitMap.containsKey(work)){
                maxProfit += difficultyToProfitMap.get(work);
            } else {
                int closest = binarySearch(difficulty, work);
                if(closest != -1){
                    maxProfit += difficultyToProfitMap.get(difficulty[closest]);
                }
            }
        }

        return maxProfit;
    }

    public static int binarySearch(int[] difficulty, int ele){
        int start = 0;
        int end = difficulty.length - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(difficulty[mid] <= ele){
                ans = mid;
                start = mid + 1;
            } else if(difficulty[mid] > ele){
                end = mid - 1;
            }
        }
        
        return ans;
    }

    // Approach 2: Greedy and Two Pointers.
}
