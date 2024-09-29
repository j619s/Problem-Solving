package Strings;

public class FindTheLongestSubstringContainingVowelsInEvenCounts1371 {
    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
    }

    public static int findTheLongestSubstring(String s) {

        int i = 0;
        int j = i;
        int[] freq = new int[26];
        int count = 0;
        int ans = 0;
        while(j < s.length()){
            char ch = s.charAt(j);

            if(ch == 'a' || ch == 'e' || ch == 'i' ||  ch == 'o' || ch == 'u'){
                freq[ch - 'a']++;
                count++;

                if(count % 2 == 0){
                    ans = Math.max(ans, j - i + 1);
                }
            }

            while(count > 1 && count % 2 != 0){
                if(freq[s.charAt(i) - 'a'] > 0){
                    freq[s.charAt(i) - 'a']--;
                    count--;
                    i++;
                }
            }
            j++;

        }

        return ans;

    }
}
