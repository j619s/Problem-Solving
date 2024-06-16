package LeetcodeDailyJune2024;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {
    public static void main(String[] args) {
        int[] seats = {12,14,19,19,12};
        int[] students = {19,2,17,20,7};
        System.out.println(minMovesToSeat(seats, students));

    }

    public static int minMovesToSeat(int[] seats, int[] students){
        int maxPosition = Math.max(Arrays.stream(seats).max().getAsInt(),
                                    Arrays.stream(students).max().getAsInt());
        System.out.println(maxPosition);
        int[] differences = new int[maxPosition];

        for (int position : seats){
            differences[position - 1]++;
        }

        System.out.println(Arrays.toString(differences));

        for(int position : students){
            differences[position - 1]--;
        }


        System.out.println(Arrays.toString(differences));

        int moves = 0;
        int unmatched = 0;
        for (int difference : differences) {
            moves += Math.abs(unmatched);
            unmatched += difference;
        }

        return moves;

    }


}
