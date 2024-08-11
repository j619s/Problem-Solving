package LeetcodeDailyJuly2024;

public class WaterBottles1518 {
    public static void main(String[] args) {
        int numBottles = 100;
        int numExchange = 2;
        System.out.println(numWaterBottles(numBottles, numExchange));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int empty = numBottles;
        int refill = 0;

        while(numBottles >= numExchange){
            refill = numBottles / numExchange; // 3
            empty += refill; // 12
            numBottles = refill + (numBottles - (refill * numExchange));
        }
        return empty;
    }
}
