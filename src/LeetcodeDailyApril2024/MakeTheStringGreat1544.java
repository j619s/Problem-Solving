package LeetcodeDailyApril2024;

import java.util.ArrayDeque;

public class MakeTheStringGreat1544 {
    public static void main(String[] args) {
        System.out.println(makeGood("abBAcC"));
    }

    public static String makeGood(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder str = new StringBuilder();
        for(int i = s.length() - 1; i >= 0 ; i--){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && (stack.peek() == (char)(ch + 32) || (char)(stack.peek() + 32) == ch)){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }

        return str.toString();

    }

}
