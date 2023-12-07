package sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class SortByAbsoluteDifference {
    public static void main(String[] args) {

    }

    static void sortABS(List<Integer> list, int n, int k){

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y){
                return (int)(Math.abs(x - k) - Math.abs(y - k));
            }
        });
//        Collections.sort(list, new Comparator<Integer>() {
//            public int compare(Integer x, Integer y){
//                return (int)(Math.abs(x - k) - Math.abs(y - k));
//            }
//        });
    }
}
