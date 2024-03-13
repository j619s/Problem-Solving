package LeetcodeDailyFebruary2024;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow(s, t));
    }
    public String minWindow(String s, String t){
        if(s.length() == 0 || t.length() == 0){
            return "";
        }

        //dictionary which keeps a count of all the unique characters in t
        Map<Character, Integer> dicT = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            dicT.put(t.charAt(i), dicT.getOrDefault(t.charAt(i), 0) + 1);
        }

        //number of unique characters in t, which need to be present in the desired window.
        int required = dicT.size();

        int l = 0, r = 0;

        //formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        //e.g. if t i s "AABC" then the window must have two A's, one B and one C
        //Thus, formed would be = 3 when all these conditions are met.
        int formed = 0;

        //Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();

        int[] ans = {-1, 0, 0};

        while(r < s.length()){
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if(dicT.containsKey(c) && windowCounts.get(c) == dicT.get(c)){
                formed++;
            }

            while(l <= r && formed == required){
                c = s.charAt(l);

                if(ans[0] == -1 || r - l + 1 < ans[0]){
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if(dicT.containsKey(c) && windowCounts.get(c) < dicT.get(c)){
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }


}
