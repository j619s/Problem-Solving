package com.java.concepts.deque;

import java.util.ArrayDeque;

public class Deque {

    public static void main(String[] args) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(1);
        dq.offerLast(2);
        dq.offerLast(3);
        dq.offerLast(4);
        dq.offerLast(5);
        eraseAt(dq, 2);
        System.out.println(dq);
    }

    public static void eraseAt(ArrayDeque<Integer> dq, int x){

        for(int i = 0; i < x; i++){
            dq.offerLast(dq.pollFirst());
        }

        for(int i = 0; i < x; i++){
            dq.offerLast(dq.pollLast());
        }



    }

    public static void eraseInRange(ArrayDeque<Integer> dq , int start, int end)
    {
        for(int i = 0; i < start; i++){
            dq.offerLast(dq.pollFirst());
        }

        for(int i = start; i < end; i++){
            dq.pollFirst();
        }

        for(int i = 0; i < start; i++){
            dq.offerFirst(dq.pollLast());
        }
    }

    public static void eraseAll(ArrayDeque<Integer> dq )
    {
        while(!dq.isEmpty()) {
            dq.poll();
        }
    }

}
