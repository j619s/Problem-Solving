package contest;

public class CountPrefixAndSuffixPairsI {
    public static void main(String[] args) {
        String[] words = {"pa","papa","ma","mama"};
        System.out.println(countPrefixSuffixPairs(words));
    }

    public static int countPrefixSuffixPairs(String[] words) {

        int res = 0;
        for(int i = 0; i < words.length - 1; i++){
            for(int j = i + 1; j < words.length; j++){
                if(isPrefixAndSuffix(words[i], words[j])){
                    res++;
                }
            }
        }
        return res;
    }

    public static boolean isPrefixAndSuffix(String s, String t){
        int lenS = s.length();
        int lenT = t.length();

        if(lenS > lenT){
            return false;
        }

        if(t.substring(0, lenS).equals(s) && t.substring(lenT-lenS, lenT).equals(s)){
            return true;
        }

        return false;
    }
}
