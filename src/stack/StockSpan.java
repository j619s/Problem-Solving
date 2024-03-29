package stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 75,85};
        int n = price.length;
        System.out.println(calculateSpan(price, n));
    }
    // we will use the concept of neagrest greater to left...

    
    public static List<Integer> calculateSpan(int[] prices, int n){
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0;i < n; i++){
            if(stack.isEmpty()){
                res.add(1);
            } else if (stack.peek() > prices[i]) {
                res.add(stack.peek());
            } else if(!stack.isEmpty() && stack.peek() <= prices[i]){
                while(!stack.isEmpty() && stack.peek() <= prices[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res.add(1);
                } else {
                    res.add(stack.peek());
                }

            }
            stack.push(prices[i]);
        }
        
        
        return res;
    }
}
