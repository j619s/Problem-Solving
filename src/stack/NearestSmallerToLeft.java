package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NearestSmallerToLeft {
    public static void main(String[] args) {
        int[] arr = {1,4,3,3,2,2,1,9};

        System.out.println(nsl(arr));
    }
    // INPUT: arr[] = {4, 5, 2, 10, 8};
    // OUTPUT: arr[] = {-1, 4, -1, 2, 2}

    public static List<Integer> nsl(int[] arr){
        List<Integer> res = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < arr.length; i++){
            if(stack.isEmpty()){
                res.add(-1);
            } else if(!stack.isEmpty() && stack.peek() < arr[i]){
                res.add(stack.peek());
            } else if(!stack.isEmpty() && stack.peek() > arr[i]){
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
        return res;
    }
}
