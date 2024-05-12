package LeetcodeDailyApril2024;

import java.util.ArrayList;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        int N = 5;
        ArrayList<String> res = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            res.add(generateBinary(i));
        }
        System.out.println(res);
    }

    public static String generateBinary(int N){
        StringBuilder str = new StringBuilder();
        while(N > 0){
            int res = N % 2;
            str.append(res);
            N /= 2;
        }
        str.reverse();
        return str.toString();
    }
}
