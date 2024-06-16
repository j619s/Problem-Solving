package LeetcodeDailyMay2024;

import java.util.*;

public class MinimumCostToHireKWorkers {
    public static void main(String[] args) {
        int[] quality = {10,20,5};
        int[] wage = {70, 50, 30};
        System.out.println(mincostToHireKWorkers(quality, wage, 2));
    }

    public static double mincostToHireKWorkers(int[] quality, int[] wage, int k){
        int n = quality.length;
        double totalCost = Double.MAX_VALUE;
        double currentTotalQuality  = 0;

        List<Pair> wageToQuality = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            wageToQuality.add(new Pair((double) wage[i] / quality[i], quality[i]));
        }
//        wageToQuality.sort(new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                return o1.ratio.compareTo(o2.ratio);
//            }
//        });

        //wageToQuality.sort((o1, o2) -> o1.ratio.compareTo(o2.ratio));

        wageToQuality.sort(Comparator.comparing(o -> o.rate));

        PriorityQueue<Integer> highestQualityWorkers = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            highestQualityWorkers.add(wageToQuality.get(i).quality);
            currentTotalQuality += wageToQuality.get(i).quality;

            if(highestQualityWorkers.size() > k){
                currentTotalQuality -= highestQualityWorkers.poll();
            }

            // we remove the worker with the highest quality because,
            // the amount we pay is decided by the highest rate (wage/quality)
            // so, as our input is sorted based on rate.
            // which means that as we iterate over the array, the rate will be increasing
            // thus removing the worker with the highest quality,will make totalCost lower.

            if(highestQualityWorkers.size() == k){
                totalCost = Math.min(totalCost, currentTotalQuality * wageToQuality.get(i).rate);
            }
        }

        return totalCost;
    }
}

class Pair{
    Double rate;
    Integer quality;

    public Pair(Double ratio, Integer quality){
        this.rate = ratio;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "ratio=" + rate +
                ", quality=" + quality +
                '}';
    }
}


