package LeetcodeDailyOctober2024;
import java.util.*;
public class TheNumberOfTheSmallestUnoccupiedChair1942 {
    public static void main(String[] args) {
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        int target = 1;
        System.out.println(smallestChair(times, target));
    }

//    Store the arrivalTime of targetFriend, since all the the arrival times are distinct
//    this can be used to identify the targetFriend in sorted array.
//    Store all the available seats(one for each friend) in minHeap as available.
//    Sort the times array based on arrival time.
//    Maintain another minHeap to store leavingTime and occupiedSeat.
//    loop through sorted array
//        remove all the friends from the heap whose leavingTime is less than or equal to current arraival time and add the occupied seats back to available heap.
//        if the current start is equal to targetStart return the min available seat.
//        else add the current leaving time and min available seat to heap.

    public static int smallestChair(int[][] times, int target){
        int targetStart = times[target][0];
        Arrays.sort(times, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for(int i = 0; i < times.length; i++){
            availableChairs.add(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int i = 0; i < times.length; i++){
                                // departure <= arrival
            while(!pq.isEmpty() && pq.peek()[0] <= times[i][0]){
                availableChairs.add(pq.poll()[1]); // add the empty chair to the available chairs
            }

            if(times[i][0] == targetStart){
                break;
            }

            pq.add(new int[]{times[i][1], availableChairs.poll()});
        }

        return availableChairs.peek();
    }
}
