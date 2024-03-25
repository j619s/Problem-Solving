package LeetcodeDailyMarch2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','B','B'};
        System.out.println(leastInterval(tasks, 1));
    }

    public static int leastInterval(char[] tasks, int n) {
        //build the freq map
        int[] freq = new int[26];
        for(char c : tasks){
            freq[c- 'A']++;
        }
        //max heap to store frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < 26; i++){
            if(freq[i] >0){
                pq.offer(freq[i]);
            }
        }
        int time = 0;
        //process task until heap is empty
        while(!pq.isEmpty()){
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            //execute tasks in each cycle
            while(cycle-- > 0 && !pq.isEmpty()){
                int currFreq = pq.poll();
                if(currFreq > 1){
                    store.add(currFreq - 1);
                }
                taskCount++;
            }
            store.forEach(pq::offer);
            time += (pq.isEmpty() ? taskCount : n + 1);

        }
        return time;
    }
}
