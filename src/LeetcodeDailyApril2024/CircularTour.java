package LeetcodeDailyApril2024;

public class CircularTour {
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println(tourII(petrol, distance));

    }
    //brute
    public static int tour(int[] petrol, int[] distance){
        int len = petrol.length;
        int start = 0;
        int end = 1;

        int currPet = petrol[start] - distance[start];

        while(end != start || currPet < 0){

            while(end != start && currPet < 0){
                currPet -= petrol[start] - distance[start];
                start = (start + 1) % len;
            }

            currPet += petrol[end] - distance[end];
            end = (end + 1) % len;
        }

        return start;
    }

    public static int tourII(int[] petrol, int[] distance)
    {
        if(arrSum(petrol) < arrSum(distance)) return -1;

        int total = 0;
        int start = 0;
        for(int i = 0; i < petrol.length; i++){
            total += (petrol[i] - distance[i]);

            if(total < 0){
                total = 0;
                start = i + 1;
            }
        }
        return start;


    }

    public static int arrSum(int[] arr){
        int sum = 0;
        for(int x : arr){
            sum += x;
        }
        return sum;
    }
}
