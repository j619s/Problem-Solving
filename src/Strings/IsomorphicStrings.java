package Strings;
import java.util.*;
public class IsomorphicStrings {
    public static void main(String[] args) {
        //System.out.println(isIsomorphic("egt", "add"));
        System.out.println(isIsomorphicII("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t){
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Boolean> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map1.containsKey(ch1)){
                if(map1.get(ch1) != ch2){
                    return false;
                }
            } else {
                if(map2.containsKey(ch2)){
                    return false;
                } else {
                    map1.put(ch1,ch2);
                    map2.put(ch2,true);
                }
            }
        }
        return true;
    }

    public static boolean isIsomorphicII(String s, String t){
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            //check if previous mapping of ch1, ch2 present.
            // and if that mapping if different than the current ch1, ch2
            // return false;
            if(mapST.containsKey(ch1) && mapST.get(ch1) != ch2 || mapTS.containsKey(ch2) && mapTS.get(ch2) != ch1){
                return false;
            }

            mapST.put(ch1, ch2);
            mapTS.put(ch2, ch1);
        }
        return true;
    }
}
