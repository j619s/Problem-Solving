package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeftmostRepeatingCharacter {
    public static void main(String[] args) {
        //String str = "geeksforgeeks";
        String str = "eabcda";
        System.out.println(leftMostRepeatingOptimised2(str));

    }

    //best - 2
    public static int leftMostRepeatingOptimised2(String s){
        boolean[] visited = new boolean[256];
        int res = -1;

        for(int i = s.length() - 1; i >= 0; i--){
            if(visited[s.charAt(i)]){
                res = i;
            } else {
                visited[s.charAt(i)] = true;
            }
        }

        return res;

    }


    //best
    public static int leftMostRepeatingOptimised(String s){
        int[] fIndex = new int[256];
        Arrays.fill(fIndex, -1);
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++){
            int fi = fIndex[s.charAt(i)];

            if(fi == -1){
                fIndex[s.charAt(i)] = i;
            } else {
                res = Math.min(res, fi);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;

    }



    //better
    public static int leftMostRepeating(String s){
        Map<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) + 1);
        }
        System.out.println(hash);
        int leftMost = -1;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(hash.get(ch) > 1){
                leftMost = i;
                break;
            }
        }

        return leftMost;
    }

    // String str = "geeksforgeeks
    // output: 0

    //String str = "abbcc"
    // output: 1

    //String str = "abcd"
    //output = -1
}
