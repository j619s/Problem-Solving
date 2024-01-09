package Strings;

public class CheckIfAStringIsSubsequenceOfOther {

    public static void main(String[] args) {
        boolean res = isSubSeqIter("ABC", "AC", 3, 2);
        System.out.println(res);
    }

    //Approach: Recursive.
    //pick and not pick
    static boolean isSubSeqRec(String s1, String s2, int n, int m){
        if(m == 0) return true;
        if(n == 0) return false;

        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
            return isSubSeqRec(s1, s2, n - 1, m - 1);
        } else {
            return isSubSeqRec(s1, s2, n - 1, m);
        }
    }

    static boolean isSubSeqIter(String s1, String s2, int n, int m){
        int i = 0;
        int j = 0;

        while(i < n && j < m){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            } else {
                i++;
            }
        }
        if(j == m) return true;

        return false;
    }

}
