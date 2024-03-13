package Strings;

public class LexicographicRankOfAString {
    static final int CHAR = 256;

    public static void main(String[] args) {
        System.out.println(lexRank("bsdk"));
    }

    static int lexRank(String s){
        int res = 1;
        int n = s.length();
        int mul = fact(n);

        int[] count = new int[CHAR];
        //get the freq of all the characters in the string.
        for(int i = 0; i < n; i++){
            count[s.charAt(i)]++;
        }

        // get the cumulative sum for each character freq.
        // this will help to get the smallest characters present before i-th char.
        for(int i = 1; i < CHAR; i++){
            count[i] += count[i - 1];
        }

        // calculate count of all the permutations of string smaller than the input string.
        for(int i = 0;i < n - 1; i++){
            mul = mul / (n - i);
            res = res + count[s.charAt(i) - 1] * mul;
            for(int j = s.charAt(i); j < CHAR; j++){
                count[j]--;
            }
        }

        return res;
    }

    public static int fact(int n){
        if(n <= 1){
            return 1;
        }
        int res = 1;
        for(int i = 2; i <= n; i++){
            res = res * i;
        }

        return res;

    }

}
