package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        //String[] str = {"abcd","abcde","abcdef","ab"};
        String[] str = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix3(str));

    }
    //https://leetcode.com/problems/longest-common-prefix/editorial/
    public static String longestCommonPrefix(String[] str){
        String lcp = "";
        if(str.length == 0) return lcp;

        int index = 0;
        for(char c: str[0].toCharArray()){
            for(int i = 1; i < str.length; i++){
                if(index >= str[i].length() || c != str[i].charAt(index)){
                    return lcp;
                }
            }
            lcp += c;
            index++;
        }

        return lcp;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }


}
