package hashing;

import java.util.HashSet;

public class prefixOfAString {
    public static void main(String[] args) {

        int[] arr = {1,10,100};

        StringBuilder str = new StringBuilder();
        HashSet<String> hash = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            String s = String.valueOf(arr[i]);
            for(int j = 0;j < s.length(); j++){
                str.append(s.charAt(j));
                hash.add(str.toString());
            }
            str.setLength(0);
        }


        System.out.println(hash);

    }
    //[1, 100, 10]
    //[1, 100, 1000, 10]


}
