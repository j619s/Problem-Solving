package LeetcodeDailyMay2024;

import java.util.Arrays;

public class BoatsToSavePeople881 {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1,2,2,3}, 3));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        if(len == 1) return 1;

        Arrays.sort(people);
        int idx = 1;
        int count = 0;
        while(idx < len){
            if(people[idx - 1]  + people[idx] <= limit){
                count++;
            } else {
                count+=2;

            }
            idx+=2;
        }

        return count;
    }
}
