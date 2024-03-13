package Strings;

public class RotateString {
    public static void main(String[] args) {
        String s = "clrwmpkwru";
        String t = "wmpkwruclr";
        System.out.println(rotateString(s, t));
    }
    static final int  d = 256;
    static final int p = 31;
    static final int m = (int)1e9 +9;
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        //we will use rabin-karp algorithm here.

        String str = s + s;
        int lenS = str.length();
        int lenG = goal.length();

        //calculating the power array
        long[] pPow = new long[Math.max(lenS, lenG)];
        pPow[0] = 1;

        for(int i = 1; i < pPow.length; i++){
            pPow[i] = (pPow[i - 1] * p) % m;
        }

        //calculate the hash value for the goal
        long h_g = 0;

        for(int i = 0; i < goal.length(); i++){
            h_g = (h_g + (goal.charAt(i) - 'a' + d) * pPow[i]) % m;
        }

        //calculate hash values for all the prefixes of the str ->

        long[] h_s = new long[lenS + 1];
        
        for(int i = 0; i< lenS; i++){

        }





        return false;
    }
}
