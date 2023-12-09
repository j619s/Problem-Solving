package sorting;

import java.util.Arrays;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        Interval[] arr = { new Interval(5,10),new Interval(3,15),new Interval(18,30),
                new Interval(2,7) };

        int n = arr.length;

        mergeIntervals(arr, n);
    }

    // Algorithm:
    // 1. Sort the pairs by their start time(in increasing order) or their end time(in decreasing order).
    // 2. Check if end time of pair > start time of other pair.
    // 3. Merge these intervals.

    public static void mergeIntervals(Interval[] arr, int n){
        Arrays.sort(arr);
        int res = 0;

        for(int i = 1; i< arr.length; i++){
            if(arr[res].end >= arr[i].start){
                arr[res].end = Math.max(arr[res].end, arr[i].end);
                arr[res].start = Math.min(arr[res].start, arr[i].start);
            } else {
                res++;
                arr[res] = arr[i];
            }
        }

        for(int i = 0; i <= res; i++){
            System.out.print(  "[" + arr[i].start + ", " + arr[i].end + "] ");
        }
    }


}

class Interval implements Comparable<Interval>{
    int start, end;

    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int compareTo(Interval a){
        return this.start - a.start;
    }
}
