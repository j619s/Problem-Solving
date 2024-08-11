package LeetcodeDailyJuly2024;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        Stack<Integer> openParenthesesIndices = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char currentChar : s.toCharArray()) {
            if (currentChar == '(') {
                // Store the current length as the start index for future reversal
                openParenthesesIndices.push(result.length());
            } else if (currentChar == ')') {
                int start = openParenthesesIndices.pop();
                // Reverse the substring between the matching parentheses
                reverse(result, start, result.length() - 1);
            } else {
                // Append non-parenthesis characters to the processed string
                result.append(currentChar);
            }
        }

        return result.toString();
    }

    private static void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

    public static String reverseParenthesesII(String s){
        int len = s.length();
        Stack<Integer> openParenthesisIdx = new Stack<>();
        int[] pair = new int[len];

        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '('){
                openParenthesisIdx.push(i);
            } else if (s.charAt(i) == ')') {
                int j = openParenthesisIdx.pop();
                pair[i] = j;  // swapping the positions of '(' and  ')'
                pair[j] = i;
            }
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0, direction = 1; i < len; i += direction){
            char ch = s.charAt(i);
            if(ch == '(' || ch == ')'){
                i = pair[i];
                direction = -direction;
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
