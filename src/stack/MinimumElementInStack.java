package stack;

import java.util.Stack;

public class MinimumElementInStack {
    public static void main(String[] args) {
        //some logic.
        Stack<Integer> stack = new Stack<>();
        /*
        *  if(ele < minEle) then push 2 * ele - minEle
        *   while popping check if stack.peek() < minEle, then k = pop() from stack, and return minEle
        *    now previous minimum element can be obtained by , minEle = 2 * minEle - k.
        *
        * */
    }
}
