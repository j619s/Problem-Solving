package LeetcodeDailyJune2024;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HandOfStraights846 {
    public static void main(String[] args) {
        int[] hand = {3, 2, 1, 5, 6, 7, 7, 8, 9};
        int groupSize = 3;
        System.out.println(isNStraightHandII(hand, groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize){
        int len = hand.length;
        if(len % groupSize != 0) return false;

        Map<Integer, Integer> map = new TreeMap<>();
        for(int x : hand){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        while(map.size() > 0){
            int curr = map.entrySet().iterator().next().getKey();
            System.out.println(curr);
            for(int i = 0;i < groupSize; i++){
                if(!map.containsKey(curr + i)) return false;
                map.put(curr + i, map.get(curr + i) - 1);

                if(map.get(curr + i) == 0) map.remove(curr + i);
            }
        }
        return false;
    }

    public static boolean isNStraightHandII(int[] hand, int groupSize){
        if(hand.length% groupSize != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int x : hand){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(int card : hand){
            int start = card;
            while(map.getOrDefault(start - 1, 0) > 0){
                start--;
            }

            while(start <= card){
                while(map.getOrDefault(start, 0) > 0){
                    for(int nextCard = start; nextCard < start + groupSize; nextCard++){
                        if(map.getOrDefault(nextCard, 0) == 0){
                            return false;
                        }
                        map.put(nextCard, map.get(nextCard) - 1);
                    }
                }
                start++;
            }
        }
        return true;
    }
}
