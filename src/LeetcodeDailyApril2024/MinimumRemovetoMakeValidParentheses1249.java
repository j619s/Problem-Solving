package LeetcodeDailyApril2024;

import java.util.ArrayDeque;

public class MinimumRemovetoMakeValidParentheses1249 {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
    }

    // Approach 1: Using stack.
    public static String minRemoveToMakeValid(String s){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++){
            char ch = arr[i];

            if(ch == '('){
                stack.push(i);
            } else if(ch == ')'){
                if(stack.isEmpty()){
                    arr[i] = '$';
                } else {
                    stack.pop();
                }
            }

        }

        while(!stack.isEmpty()){
            arr[stack.pop()] = '$';
        }

        StringBuilder res = new StringBuilder();
        for(char c : arr){
            if(c != '$'){
                res.append(c);
            }
        }
        return res.toString();
    }

    //Approach2: using count
    public static String minRemoveToMakeValidII(String s){
        int count = 0;

        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                count++;
            } else if(arr[i] == ')'){
                if(count == 0) arr[i] = '$';
                else count--;
            }
        }

        for(int i = arr.length - 1; i>= 0; i--){
            if(arr[i] == '(' && count > 0){
                arr[i] = '$';
                count--;
            }
        }

        StringBuilder res = new StringBuilder();
        for (char c : arr) {
            if (c != '$') {
                res.append(c);
            }
        }
        return res.toString();

    }



    }

