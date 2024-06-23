package LeetcodeDailyJune2024;

import java.util.Arrays;

public class MinimumDaysToMakeMBouquets {

    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,13,11,12,7};
        int max = Arrays.stream(bloomDay).max().getAsInt();
        int min = Arrays.stream(bloomDay).min().getAsInt();
        int m = 2, k = 3;
        //brute force
//        for(int i = min; i<= max; i++){
//            if(possible(bloomDay, i, m, k)){
//                System.out.println(i);
//                break;
//            }
//        }

        //optimised using binary search
        int ans = -1;
        while(min <= max){
            int mid = min + (max - min) / 2;

            if(possible(bloomDay, mid, m, k)){
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(ans);
    }


//    public int minDays(int[] bloomDay, int m, int k) {
//        return possible(bloomDay, 12, 2, 3);
//    }


    public static boolean possible(int[] days, int day, int m, int k){
        int count = 0;
        int res = 0;
        for(int i = 0; i < days.length; i++){
            if(days[i] <= day){
                count++;
            } else {
                res += (count / k);
                count = 0;
            }
        }
        res += (count / k);
        return res >= m;
    }
}
