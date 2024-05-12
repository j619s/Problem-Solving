package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NearestGreaterToLeft {
    public static void main(String[] args) {
        int[] arr = {1,0,2,0,0};
        System.out.println(ngl(arr));
    }
    /*
    *  input: arr[] = [1, 3, 2, 4]
    * output: arr[] = [-1, -1, 3, -1]
    * */
    public static List<Integer> ngl(int[] arr){
        List<Integer> res = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0;i < arr.length; i++){
            if(stack.isEmpty()){
                res.add(-1);
            } else if(!stack.isEmpty() && stack.peek() > arr[i]){
                res.add(stack.peek());
            } else if(!stack.isEmpty() && stack.peek() < arr[i]){
                while(!stack.isEmpty() && stack.peek()< arr[i]){
                    stack.poll();
                }
                if(stack.isEmpty()){
                    res.add(-1);
                } else {
                    res.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }

        return res;
    }
}
