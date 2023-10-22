package cses.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sequence {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
//        num.add(2);
//        num.add(1);
//        num.add(4);
//        num.add(3);
          num.add(2);
          num.add(2);
          num.add(2);

        System.out.println(getScoreDifference(num));
    }

    public static int getScoreDifference(List<Integer> numSeq) {
        // Write your code here
        int first = 0;
        int second = 0;

        // arr[] = 2, 1, 4, 3

        // first = 2,4 : second =3,1
        int n = numSeq.size();
        for(int i = 1; i <= n; i++){
            int ele = numSeq.get(0);

            if(i % 2 == 1){
                //for first
                first += ele;

            } else {
                //for second
                second += ele;
            }
            if(ele % 2 == 0){
                Collections.reverse(numSeq);
                numSeq.remove(numSeq.size() - 1);
            } else {
                numSeq.remove(0);
            }
        }
        


        return Math.abs(first - second);

    }
}
