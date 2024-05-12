package LeetcodeDailyApril2024;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(max_of_subarrays(arr, arr.length, 3));

    }

    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < k; i++){
            while(!dq.isEmpty()){
                if(arr[dq.peekLast()] <= arr[i]){
                    dq.pollLast();
                }
            }

            dq.offerLast(i);
        }

        for(int i = k; i < n; i++){
            res.add(arr[dq.peekFirst()]);

            while(!dq.isEmpty() &&  dq.peekFirst() <= i - k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        res.add(arr[dq.peekFirst()]);

        return res;
    }
}
