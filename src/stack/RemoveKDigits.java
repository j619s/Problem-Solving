package stack;

import java.util.ArrayDeque;

public class RemoveKDigits {
    //learn problems based on monotonic stack or monotonic array...

    public static void main(String[] args) {
        String str =  "10200";
        System.out.println(removeKDigits(str, 3));
    }
    // Take 402. Remove K Digits (Medium) for example, since we are looking for lexigraphically smallest subsequence,
    // we should use mono-increasing stack.

    public static String removeKDigits(String str, int k){
        int len = str.length();

        //if(len == k) return "0";

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < len; i++){

            char ch = str.charAt(i);

            while(k > 0 && !stack.isEmpty() && stack.peek() > ch){
                stack.pop();
                k--;
            }

            stack.push(ch);

        }
        System.out.println(stack);

        while(k != 0){
            stack.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res.reverse();
        while(res.length() > 1 && res.charAt(0) == '0'){
            res.deleteCharAt(0);
        }
        return res.toString();

    }


}
