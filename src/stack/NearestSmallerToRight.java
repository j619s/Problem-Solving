package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NearestSmallerToRight {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println(nsr(arr));
    }

    //INPUT: arr[] = {4, 5, 2, 10, 8}
    //OUTPUT: arr[] = {2, 2, -1, 8, -1}

    public static List<Integer> nsr(int[] arr){
        List<Integer> res = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = arr.length - 1; i >= 0; i--){
            if(stack.isEmpty()){
                res.add(-1);
            } else if(stack.peek() < arr[i]){
                res.add(stack.peek());
            } else if(stack.peek() > arr[i]){
                while(!stack.isEmpty() && stack.peek() > arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res.add(-1);
                } else if(stack.peek() < arr[i]){
                    res.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(res);
        return res;
    }
}
