package LeetcodeDailyMay2024;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int k = 3;
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k){
        // max heap
        PriorityQueue<double[]> pq  = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));

        for(int i = 0; i < arr.length; i++){
            pq.offer(new double[]{-1.0 *arr[i]/arr[arr.length - 1], i, arr.length - 1});
        }
        for(double[] d : pq){
            System.out.println(Arrays.toString(d));
        }
        while(--k > 0){
            double[] curr  = pq.poll();

            int numeratorIdx = (int) curr[1];
            int denominatorIdx = (int) curr[2] - 1;
            if(denominatorIdx > numeratorIdx){
                pq.offer(new double[]{
                   -1.0* arr[numeratorIdx] / arr[denominatorIdx],
                   numeratorIdx,
                   denominatorIdx
                });
            }

        }
        System.out.println("----------------------------------");
        for(double[] d : pq){
            System.out.println(Arrays.toString(d));
        }

        double[] result = pq.poll();
        return new int[]{arr[(int) result[1]], arr[(int) result[2]]};
    }
}
