package hashing;
import java.util.HashMap;
import java.util.Map;

public class SubArraysWithEqual0sand1s {
    public static void main(String[] args) {
        int[] arr = {1,0,0,1,0,1,1};
        System.out.println(countSubArrayWithEqualZeroAndOnes(arr, arr.length));
    }

    static int countSubArrayWithEqualZeroAndOnes(int[] arr, int n){
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            prefixSum += arr[i];
            if(prefixSum == 0){
                count++;
            }

            if(map.containsKey(prefixSum)){
                count += map.get(prefixSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
