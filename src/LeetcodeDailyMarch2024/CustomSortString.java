package LeetcodeDailyMarch2024;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

    public static void main(String[] args) {
        String s = "abcd";
        String order = "cba";
        System.out.println(customSortString(order, s));
    }
    public static String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                int freq = map.get(ch);
                while(freq != 0){
                    res.append(ch);
                    freq--;
                }
                map.put(ch, freq);
            }
        }

        for(Map.Entry<Character, Integer> m : map.entrySet()){
            int freq = m.getValue();
            while(freq != 0){
                res.append(m.getKey());
                freq--;
            }
        }

        return res.toString();
    }
}
