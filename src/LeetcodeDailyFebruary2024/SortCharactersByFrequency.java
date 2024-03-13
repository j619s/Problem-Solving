package LeetcodeDailyFebruary2024;
import java.util.*;
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s){
        Map<Character, Integer> freq = new HashMap<>(); // char -> count
        for(int i = 0; i < s.length(); i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i),  0) + 1);
        }

        //create the buckets based on the frequency
        List<Character>[] buckets = new ArrayList[s.length() + 1]; // freq -> [char]
        
        for(Character c : freq.keySet()){
            if(buckets[freq.get(c)] == null){
                buckets[freq.get(c)] = new ArrayList<>();
            }
            buckets[freq.get(c)].add(c);
        }

        System.out.println(Arrays.toString(buckets));
        //using buckets to get the final result
        StringBuilder str = new StringBuilder();
        for(int i = buckets.length - 1; i >= 0; i--){
            if(buckets[i] != null){
                for(Character c : buckets[i]){
                    for(int j = 0; j < i; j++){
                        str.append(c);
                    }
                }
            }
        }

        return str.toString();
    }
}
