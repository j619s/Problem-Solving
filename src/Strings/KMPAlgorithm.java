package Strings;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String needle = "abc";
        String haystack = "abcabcd";
//        System.out.println(Arrays.toString(prefixFunction(needle)));

        int i = 0; //ptr for haystack
        int j = 0; // ptr for needle
        int[] lps = prefixFunction(needle);
        int res = -1;
        while (i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            } else {
                if(j == 0)
                    i+= 1;
                else {
                    j = lps[j - 1];
                }
            }

            if (j == needle.length()){
                res = i - needle.length();
                break;
            }
        }

        System.out.println(res);

    }

    public static int[] prefixFunction(String needle){
        int[] lps = new int[needle.length()];

        if(needle.equalsIgnoreCase("")){
            return lps;
        }

        int prevLPS = 0;
        int i = 1;

        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(prevLPS)){
                lps[i] = prevLPS + 1;
                prevLPS += 1;
                i += 1;
            } else if(prevLPS == 0){
                lps[i] = 0;
                i += 1;
            } else {
                prevLPS = lps[prevLPS - 1];
            }
        }

        return lps;
    }



}
