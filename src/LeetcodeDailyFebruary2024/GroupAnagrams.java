package LeetcodeDailyFebruary2024;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> charCountMap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(String s : strs){
            int[] count = new int[26];

            //getting the frequency of each string
            for(int i = 0; i < s.length(); i++){
                count[s.charAt(i) - 'a']++;
            }
            // will use the frequency string as key in hashmap
            // group similar frequency strings to the corresponding keys as values.
            String c = Arrays.toString(count);
            //mapping similar freq string to hashmap with 'freq' i.e. `c` as key!
            if(charCountMap.containsKey(c)){
                List<String> l = charCountMap.get(c);
                l.add(s);
                charCountMap.put(c, l);
            } else {
                List<String> ss = new ArrayList<>();
                ss.add(s);
                charCountMap.put(c, ss);
            }

        }
        System.out.println(charCountMap);
        for(Map.Entry<String, List<String>> m : charCountMap.entrySet()){
            res.add(m.getValue());
        }

        return res;
    }
}
