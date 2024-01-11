package Strings;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithm {

    public static void main(String[] args) {
        rabinKarp("abc","abcdefghabc");

    }

    static void rabinKarp(String s, String t){
        final int p = 31;
        final int m = (int) (1e9 + 9);
        int lenS = s.length();
        int lenT = t.length();

        Long[] pPow = new Long[Math.max(lenS, lenT)];   // Precomputed powers of 'p'
        pPow[0] = 1L;
        for(int i = 1; i < pPow.length; i++){
            pPow[i] = (pPow[i - 1] * p ) % m;
        }

        Long[] h = new Long[lenT + 1];      // Hash values for all prefixes of the text t
        h[0] = 0L;
        for(int i = 0; i <lenT; i++){
            h[i+1] = (h[i] + (t.charAt(i) - 'a' + 1) * pPow[i]) % m;
        }

        long h_s = 0;                       // calculate hash value for pattern s
        for(int i = 0; i < lenS; i++){
            h_s = (h_s  + (s.charAt(i) - 'a' + 1) * pPow[i]) % m;
        }

        List<Integer> occurrences = new ArrayList<>();
        for(int i = 0; i + lenS - 1 < lenT; i++){
            long curr_h = (h[i + lenS] + m - h[i]) % m;
            if(curr_h == h_s * pPow[i] % m){
                occurrences.add(i);
            }
        }

        System.out.println(occurrences);
    }
}
