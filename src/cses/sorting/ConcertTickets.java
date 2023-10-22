package cses.sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> price = new ArrayList<>();
        ArrayList<Integer> pay = new ArrayList<>();
        for(int i = 0; i < n; i++){
            price.add(sc.nextInt());
        }

        for(int i = 0; i < m; i++){
            pay.add(sc.nextInt());
        }

        ArrayList<Integer> res = concertTickets(price, pay);
        System.out.println(res);

    }

    public static ArrayList<Integer> concertTickets(ArrayList<Integer> price, ArrayList<Integer> pay){

        Collections.sort(price);

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < pay.size(); i++){
            ans.add(0);
        }
        for(int i = 0; i < pay.size(); i++){
            int temp = pay.get(i);

            int upper = upperBound(price, temp);

            if(upper == 0){
                ans.set(i, -1);
            } else {
                upper--;
                ans.set(i, price.get(upper));
                price.remove(upper);
            }
        }
        return ans;
    }
    // The upper bound will give us the iterator pointing to the first element
    // greater than the value passed as a parameter.
    public static int upperBound(ArrayList<Integer> arr, int k){
        //smallest index such that arr[ind] > k
        int low = 0;
        int high = arr.size() - 1;
        int ans = arr.size();

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr.get(mid) > k){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
    /*
        5 3
        5 3 7 8 5
        4 8 3

    */

}
