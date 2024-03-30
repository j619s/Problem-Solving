package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 75,85};
        int n = price.length;
        System.out.println(Arrays.toString(calculateSpan(price, n)));
    }
    // we will use the concept of nearest greater to left...

    
    public static int[] calculateSpan(int[] prices, int n){
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && prices[stack.peek()] <= prices[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = i + 1;
            } else {
                res[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}
