package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeCharacters {
    public static void main(String[] args) {
        String res = rearrageCharacters("geeksforgeeks");
        System.out.println(res);
    }

    public static String rearrageCharacters(String s){
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int currCount = freq.getOrDefault(s.charAt(i), 0 ) + 1;
            if(currCount > (s.length() + 1) / 2){
                return "";
            }
            freq.put(s.charAt(i), currCount);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(Character c : freq.keySet()){
            pq.add(new int[]{c, freq.get(c)});
        }

        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(res.length() == 0 || curr[0] != res.charAt(res.length() - 1)){
                res.append((char) curr[0]);
                if(--curr[1] > 0){
                    pq.add(curr);
                }
            } else {
                int[] next = pq.poll();
                res.append((char) next[0]);

                if(--next[1] > 0){
                    pq.add(next);
                }
                pq.add(curr);
            }
        }

        return res.toString();

    }


}



