package LeetcodeDailyOctober2024;

import java.util.PriorityQueue;

public class LongestHappyString1405 {
    public static void main(String[] args) {
        int a = 1, b = 1, c = 7;
        System.out.println(longestDiverseString(a, b, c));
    }

    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);
        pq.add(new Pair(a, 'a'));
        pq.add(new Pair(b, 'b'));
        pq.add(new Pair(c, 'c'));

        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int freq = curr.freq;
            char ch = curr.ch;

            // if three consecutive characters exist, pick the second most frequent character
            if(res.length() >= 2
                    && res.charAt(res.length() - 2) == ch
                    && res.charAt(res.length() - 1) == ch){
                if (pq.isEmpty()) break;

                Pair secondMost = pq.poll();
                res.append(secondMost.ch);
                if(secondMost.freq - 1 > 0){
                    pq.add(new Pair(secondMost.freq - 1, secondMost.ch));
                }
            } else {
                freq--;
                res.append(ch);
            }

            if(freq > 0){
                pq.add(new Pair(freq, ch));
            }

        }

        return res.toString();
    }
}
