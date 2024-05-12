package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToRight {
    public static void main(String[] args) {
            int[] arr = {1,4,3,3,2,2,1,9};
            int n = arr.length;
        System.out.println(ngr(arr, n));
    }
    /*
    *  Problem Statement:
    *   arr[] =  [1, 3, 2, 4]
    *   output:  [3, 4, 4, -1]
    *    find the greater element to the right of the current element
    * */
    public static List<Integer> ngr(int[] arr, int n){
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        for(int i = n - 1; i>= 0; i--){
            if(stack.isEmpty()){
                res.add(-1);
            } else if(!stack.isEmpty() && stack.peek() > arr[i]){
                res.add(stack.peek());
            } else if(!stack.isEmpty() && stack.peek() <= arr[i]){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res.add(-1);
                } else {
                    res.add(stack.peek());
                }
            }

            stack.push(arr[i]);
        }
        Collections.reverse(res);
        return res;
    }
}
