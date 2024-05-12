package LeetcodeDailyApril2024;

import java.util.ArrayDeque;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "10";
        System.out.println(removeKdigits(num, 2));
    }
    // Approach1: Monotonic Increasing Stack.

    public static String removeKdigits(String num, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < num.length();i++){
            char ch = num.charAt(i);

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
        System.out.println(res.isEmpty());
        return String.valueOf(Integer.parseInt(res.reverse().toString()));
    }
}
