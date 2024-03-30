package Strings;

public class MaximumLengthSubstringWithTwoOccurrences3090 {
    public static void main(String[] args) {
        System.out.println(maximumLengthSubstring("aaaa"));
    }

    public static int maximumLengthSubstring(String s) {
        int maxLen = 0;
        int[] freq = new int[26];
        int start = 0;

        for(int end = 0; end < s.length(); end++){
            freq[s.charAt(end) - 'a']++;

            while(freq[s.charAt(end) - 'a'] > 2){
                freq[s.charAt(start) - 'a']--;
                start++;
            }

            maxLen =  Math.max(maxLen, end  - start + 1);

        }

        return maxLen;
    }

}
