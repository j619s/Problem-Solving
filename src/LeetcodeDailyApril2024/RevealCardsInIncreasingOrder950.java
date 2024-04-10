package LeetcodeDailyApril2024;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder950 {
    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};

        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }

    //approach1: using queue and simulating what is told in the question itselt.

    public static int[] deckRevealedIncreasing(int[] deck){
        int len = deck.length;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < len; i++){
            q.add(i);
        }
        Arrays.sort(deck);
        int[] res = new int[len];

        for(int i = 0; i < len; i++){
            if(!q.isEmpty()){
                res[q.poll()] = deck[i];
            }
            q.add(q.poll());
        }
        return res;
    }




    //approach 2: using two pointers to simulate a queue
    public static int[] deckRevealedIncreasingII(int[] deck){
        int len = deck.length;
        int[] res = new int[len];
        boolean skip = false;
        int indexInDeck = 0;
        int indexInRes = 0;

        Arrays.sort(deck);

        while(indexInDeck < len){
            if(res[indexInRes] == 0){
                if(!skip){
                    res[indexInRes] = deck[indexInDeck];
                    indexInDeck++;
                }

                skip = !skip;
            }

            indexInRes = (indexInRes + 1) % len;
        }

        return res;
    }
}
