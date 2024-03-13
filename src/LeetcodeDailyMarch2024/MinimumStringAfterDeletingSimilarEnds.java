package LeetcodeDailyMarch2024;

public class MinimumStringAfterDeletingSimilarEnds {
    public static void main(String[] args) {
        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
        System.out.println(minimumLength(s));
    }

    public static int minimumLength(String s) {
        if(s.charAt(0) != s.charAt(s.length() - 1)){
            return s.length();
        }

        int size = 0;

        int leftPtr = 0;
        int rightPtr = s.length() - 1;

        while(leftPtr <= rightPtr){
            if(s.charAt(leftPtr) == s.charAt(rightPtr)){
                leftPtr++;
                rightPtr--;
            } else if(leftPtr != 0 && s.charAt(leftPtr) == s.charAt(leftPtr - 1)){
                leftPtr++;
            } else if(rightPtr != s.length() - 1 && s.charAt(rightPtr) == s.charAt(rightPtr + 1)){
                rightPtr--;
            } else {
                break;
            }
        }
        System.out.println("leftPtr" + leftPtr + ", rightPtr" + rightPtr);
        System.out.println(s.length());
        return  leftPtr > rightPtr ? 0 : rightPtr - leftPtr + 1;



    }
}
