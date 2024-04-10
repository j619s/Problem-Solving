package LeetcodeDailyApril2024;

import java.util.ArrayDeque;

public class ValidParenthesisString678 {
    public static void main(String[] args) {
        //System.out.println(checkValidString(")))(((****"));
        //System.out.println(checkValidString("(((((()*)(*)*))())())(()())())))((**)))))(()())()"));
        //System.out.println(checkValidStringII("(((((()*)(*)*))())())(()())())))((**)))))(()())()"));
        System.out.println(checkValidStringII("(((((*)))**"));

    }
    //Approach 1: Two Stacks.
    public static boolean checkValidString(String s) {
        ArrayDeque<Integer> openBrackets = new ArrayDeque<>();
        ArrayDeque<Integer> asterisks = new ArrayDeque<>();

        for(int i = 0; i< s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '('){
                openBrackets.push(i);
            } else if(ch == '*'){
                asterisks.push(i);
            } else {
                if(!openBrackets.isEmpty()){
                    openBrackets.pop();
                } else if(!asterisks.isEmpty()){
                    asterisks.pop();
                } else {
                    return false;
                }
            }
        }
        // Check if there are remaining open brackets and asterisks that can balance them
        while(!openBrackets.isEmpty() && !asterisks.isEmpty()){
            if(openBrackets.pop() > asterisks.pop()){
                return false;   // '*' before '(' which cannot be balanced.
            }
        }

        // If all open brackets are matched and there are no unmatched open brackets left, return true
        return openBrackets.isEmpty();
    }

    //Approach 2: Two pointers
    public static boolean checkValidStringII(String s){
        int openCount = 0;
        int closeCount = 0;
        int length = s.length() - 1;

        // Traverse the string from both ends simultaneously
        for (int i = 0; i <= length; i++) {
            // Count open parentheses or asterisks
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                openCount++;
            } else {
                openCount--;
            }

            // Count close parentheses or asterisks
            if (s.charAt(length - i) == ')' || s.charAt(length - i) == '*') {
                closeCount++;
            } else {
                closeCount--;
            }

            // If at any point open count or close count goes negative, the string is invalid
            if (openCount < 0 || closeCount < 0) {
                return false;
            }
        }

        // If open count and close count are both non-negative, the string is valid
        return true;
    }

}
