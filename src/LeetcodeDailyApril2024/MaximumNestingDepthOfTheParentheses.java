package LeetcodeDailyApril2024;

import java.util.ArrayDeque;

public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push('(');
                res = Math.max(res, stack.size());
            } else if(ch == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        return res;
    }
}
