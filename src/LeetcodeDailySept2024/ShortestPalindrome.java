package LeetcodeDailySept2024;

public class ShortestPalindrome {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abc"));
    }

    public static String shortestPalindrome(String s){
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();

        for(int i = 0; i < s.length(); i++){
            // check if prefix of s == suffix of rev
            if(s.substring(0, s.length() - i).equals(rev.substring(i))){
                return rev.substring(0, i) + s;
            }
        }

        return rev.toString() + s;
    }
}
