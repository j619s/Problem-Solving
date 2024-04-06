package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class MaximumRectAreaInHistogram {
    public static void main(String[] args) {
        long n = 6l;
        //long[] arr = {6,2,5,4,5,1,6};
        long[] arr = {2,1,5,6,2,3};
        System.out.println(getMaxArea(arr, n));
    }

    public static long getMaxArea(long hist[], long n){
        // find the nearest smaller to left for every element
        // find the nearest smaller to right for every element
        // ans = ht of current element * (nsr - nsl - 1) * width;
        List<Integer> nsl = nsl(hist, n);
        List<Integer> nsr = nsr(hist, n);
        int k = Math.toIntExact(n);
        System.out.println("nsl: " + nsl);
        System.out.println("nsr: " + nsr);
        long res = 0l;
        for(int i = 0; i < n; i++){
            res = Math.max(res, (nsr.get((int)n - i - 1) - nsl.get(i) - 1) * hist[i]);
        }
        return res;
    }

    public static List<Integer> nsl(long[] hist, long n) {
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        List<Integer> nsl = new ArrayList<>();
        int pseudoIndex = -1;

        for (int i = 0; i < (int) n; i++) {
            if (stack.isEmpty()) {
                nsl.add(pseudoIndex);
            } else if (stack.peek().first < hist[i]) {
                nsl.add(stack.peek().second);
            } else if (stack.peek().first >= hist[i]) {
                while (!stack.isEmpty() && stack.peek().first >= hist[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    nsl.add(pseudoIndex);
                } else {
                    nsl.add(stack.peek().second);
                }
            }

            stack.push(new Pair(hist[i], i));
        }
        return nsl;
    }

    public static List<Integer> nsr(long[] hist, long n) {
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        List<Integer> nsr = new ArrayList<>();

        for (int i = (int)n - 1; i >= (int)0 ; i--) {
            if (stack.isEmpty()) {
                nsr.add((int)n);
            } else if (stack.peek().first < hist[i]) {
                nsr.add(stack.peek().second);
            } else if (stack.peek().first >= hist[i]) {
                while (!stack.isEmpty() && stack.peek().first >= hist[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    nsr.add((int) n);
                } else {
                    nsr.add(stack.peek().second);
                }
            }

            stack.push(new Pair(hist[i], i));
        }
       // Collections.reverse(nsr);
        return nsr;

    }
}

class Pair{
    long first;
    int second;

    public Pair(long first, int second){
        this.first = first;
        this.second = second;
    }
}
