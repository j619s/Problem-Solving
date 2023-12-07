package sorting;

import java.util.HashSet;

public class TripletSum {
    public static void main(String[] args) {
        int[] arr = {1,2,4,3,6};
        int X = 10;
        System.out.println(triplet(arr, arr.length, X));
    }

    public static boolean triplet(int[] arr, int n, int X){
        for(int i = 0; i < n - 2; i++){ // here n - 2 as we require 3 numbers
            HashSet<Integer> hash = new HashSet<>();
            int curr = X - arr[i];
            for(int j = i + 1; j < n; j++){
                int required = curr - arr[j];
                if(hash.contains(required)){
                    return true;
                }
                hash.add(arr[j]);
            }
        }
        return false;
    }
}
