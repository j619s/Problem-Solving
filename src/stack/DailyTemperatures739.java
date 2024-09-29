package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperaturesII(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures){
        int len = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[len];
        for(int i = len - 1; i>=0; i--){
            int curr = temperatures[i];

            while(!st.isEmpty() && curr >= temperatures[st.peek()]){
                st.pop();
            }

            if(!st.isEmpty()){
                res[i] = st.peek() - i;
            }

            st.add(i);
        }
        return res;
    }

    public static int[] dailyTemperaturesII(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--]; // pop from stack
                ret[idx] = i - idx;
            }
            stack[++top] = i; //push to stack
        }
        return ret;
    }
}
