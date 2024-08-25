package LeetcodeDailyAugust2024;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] arr = {5,5,5,5,20,20,5,5,20,5};
        System.out.println(lemonadeChange(arr));
    }

    public static boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;

        for(int i = 0; i < bills.length; i++){
            int curr = bills[i];

            if(curr == 5){
                fiveCount++;
            } else if(curr == 10){
                if(fiveCount > 0){
                    fiveCount--;
                    tenCount++;
                } else {
                    return false;
                }
            } else {
                if(tenCount> 0 && fiveCount > 0){
                    tenCount--;
                    fiveCount--;
                } else if(fiveCount >= 3){
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
