package LeetcodeDailyJuly2024;

public class AverageWaitingTime {
    public static void main(String[] args) {
        int[][] customers = {{2,3},{6,3},{7,5},{11,3},{15,2},{18,1}};
        System.out.println(averageWaitingTime(customers));
    }

    public static double averageWaitingTime(int[][] customers){
        long totalDuration = 0;
        int prepTime = 0;
        for(int i = 0; i < customers.length; i++){
            int arrival = customers[i][0];
            int time = customers[i][1];

            if(i == 0){
                prepTime += (arrival + time);
                totalDuration += time;
            } else {
                if(arrival > prepTime){
                    totalDuration += time;
                    prepTime = (arrival + time);
                } else {
                    prepTime += time;
                    totalDuration += (prepTime - arrival);
                }
            }
            System.out.print(totalDuration +",");
        }

        return (double) totalDuration / customers.length;
    }
}
