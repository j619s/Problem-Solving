package LeetcodeDailyApril2024;

import java.util.Arrays;

public class MaximumNestingDepthOfTwoValidParenthesisStrings {

    /*
        Given a VPS seq, split it into two disjoint subsequences A and B,
        such that A and B are VPS's (and A.length + B.length = seq.length).

        Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value.
        Return an answer array (of length seq.length) that encodes such a choice of A and B:
        answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.
        Note that even though multiple answers may exist, you may return any of them.

        Example 1:

        Input: seq = "(()())"
        Output: [0,1,1,1,1,0]

        Example 2:

        Input: seq = "()(())()"
        Output: [0,0,0,1,1,0,1,1]


     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxDepthAfterSplit("()(())()")));
    }

    public static int[] maxDepthAfterSplit(String seq) {
        int depth = -1;
        int i = 0;
        int len =seq.length();
        int[] res = new int[len];

        while(i < len){
            if(seq.charAt(i)=='('){
                depth++;
                res[i]=depth % 2;
            }
            else{
                res[i] = depth % 2;
                depth--;
            }
            i++;
        }
        return res;
    }

}
