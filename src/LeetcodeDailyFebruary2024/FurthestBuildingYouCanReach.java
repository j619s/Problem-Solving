package LeetcodeDailyFebruary2024;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        int[] heights = {14,3,19,3};
        System.out.println(furthestBuild(heights, 17, 0));
    }

    public static int furthestBuild(int[] heights, int bricks, int ladders){
        //using priority queue to keep track of maximum diff. between heights
        // as we will use ladders for max difference
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //Now, we will use a greedy approach.
        // We will subtract bricks by default for all the heights no matter the difference.
        // and as bricks < 0,
        //      ->    decrement the ladder.
        //      ->    poll() from max-heap which gives the largest difference
        //      ->   add it to bricks.

        for(int i = 0; i < heights.length - 1; i++){
            int diff = heights[i+1] - heights[i];
            if(diff < 0) continue;

            bricks -= diff;
            pq.add(-diff);

            if(bricks < 0){
                if(ladders == 0){
                    return i;
                }
                ladders -= 1;
                bricks += -pq.poll();
            }

        }
        return heights.length - 1;
    }
}
