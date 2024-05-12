package Strings;

public class MergeStringAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab","pqrs"));
    }

    public static String mergeAlternately(String word1, String word2){
        StringBuilder str = new StringBuilder();

        int len1 = word1.length();
        int len2 = word2.length();
        int idx1 = 0;
        int idx2 = 0;
        boolean flag = false;
        while(idx1 < len1 || idx2 < len2){
            if(flag && idx2 < len2){
                str.append(word2.charAt(idx2++));
                flag = false;
            } else if(!flag && idx1 < len1){
                str.append(word1.charAt(idx1++));
                flag = true;
            } else {
                break;
            }
        }

        while(idx1 < len1){
            str.append(word1.charAt(idx1++));
        }

        while(idx2 < len2){
            str.append(word2.charAt(idx2++));
        }

        return str.toString();
    }

}
