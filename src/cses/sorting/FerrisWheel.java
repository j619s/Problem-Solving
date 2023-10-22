package cses.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FerrisWheel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x = sc.nextInt();
        long[] weight = new long[n];

        for(int i = 0; i < n; i++){
            weight[i] = sc.nextLong();
        }
        sc.close();
        boolean [] gondola = new boolean[n];
        int answer = 0;
        int i = 0, j = n - 1;
        Arrays.sort(weight);

        while(i < j){
            if(weight[i] + weight[j] > x) {
                j--;
            } else {
                answer++;
                gondola[i] = gondola[j] = true;
                i++;
                j--;
            }
        }

        for(int k = 0; k < n; k++){
            if (gondola[k]) {
                continue;
            }
            answer++;
        }

        System.out.println(answer);


    }
}
