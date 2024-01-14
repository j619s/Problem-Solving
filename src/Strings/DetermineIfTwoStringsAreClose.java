package Strings;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
//        String word1 = "abbzzca";
//        String word2 = "babzzcz";
        String word1 = "abbca";
        String word2 = "babcz";
        System.out.println(closeStrings(word1, word2));
    }

    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(int i = 0; i < word1.length(); i++){
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(freq1[i] == 0 && freq2[i]!= 0 || freq1[i] != 0 && freq2[i] == 0) {
                return false;
            }
        }
//        not every character of word1 should occur in word 2.
//        word1 may have extra elements that can be converted in something to get correct answer
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int i = 0; i < 26; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }

        return true;

    }


//    sort the frequencies and compare.
//
//    Since we need to replace all the frequencies of certain character,
//    so we care only that the frequency of that character is same as the other
//    character we need to convert to in the other word
//
//    ie: aaabbc -> zzzddf, they are close since the frequencies vector will be 3, 2, 1
//    for both of them
//    but is such case abbbbc -> zzzddf, here we can not say that they are close,
//    since we have frequency list {3,2,1} and the other is {4,1,1}.
//    so here what we should do.
//
//    sort both freqencies vectors.
//    iterate over the alphabet length
//        if the corresponding frequencies are not the same
//            return false.
//                    return true.

}
