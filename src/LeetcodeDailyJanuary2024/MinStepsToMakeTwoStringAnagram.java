package LeetcodeDailyJanuary2024;

import java.util.Arrays;

public class MinStepsToMakeTwoStringAnagram {
    public static void main(String[] args) {
        //System.out.println(minSteps("bab","aba"));
        System.out.println(minSteps("leetcode","practice"));
    }
//    To find the minimum characters required to make t and s anagrams,
//    we can find the count of characters in t which are not present in s.
    static int minSteps(String s, String t){
        int count = 0;
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            freq[t.charAt(i) - 'a']--;
        }
        System.out.println(Arrays.toString(freq));
        for(int i: freq){
            count += Math.max(0, i);
        }
        return count;
    }
//
//    To find this, we can record the frequency of each character in both strings s and t,
//    and calculate the frequency difference of each character (freq in t - freq in s).
//    One important thing to note is that this difference can be positive or negative,
//    for example, if s = bba and t = baa, the frequency difference of a is 1
//    (t has 2 occurrences of a while s has 1, 2 - 1 = 1) and
//    the frequency difference of b is -1 (t has 1 occurrence of b while s has 2, 1 - 2 = -1).
//    However, we only need to focus on the positive value which implies that there are more instances of this character in t, why?
//
//    This is because the two values (the sum of the positive and negative differences)
//    are equal in absolute value! The positive value comes from the character in t that
//    needs to be replaced, the negative value comes from the character in s that
//    waits for the corresponding replacement in t.
//
//    Since t and s are of equal length, and both remain the same after modifying t to
//    make it an anagram of s, the absolute values of the two positive and negative
//    values must be equal. Therefore, we can either sum only the negative differences
//    or only the positive differences, and the result is the same for both.
}
