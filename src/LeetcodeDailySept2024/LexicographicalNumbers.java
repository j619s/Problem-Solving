package LeetcodeDailySept2024;
import java.util.*;
public class LexicographicalNumbers {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(lexicalOrder(n));
        System.out.println(generatorIterative(n));
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i<10; i++){
            generatorDfs(n, i, res);
        }

        return res;
    }
    // generating numbers like 1, 10, 11, ...2, 20, 21,22....

    public static void generatorDfs(int n, int curr, List<Integer> res){
        if(curr > n){
            return;
        }
        res.add(curr);
        for(int i = 0; i < 10; i++){
            generatorDfs(n, curr * 10 + i, res);
        }
    }

    public static List<Integer> generatorIterative(int n){
        List<Integer> res = new ArrayList<>();
        int curr = 1;
        while(res.size() < n){
            res.add(curr);
            if(curr * 10 <= n){
                curr *= 10;
            } else {
                while(curr == n || curr % 10 == 9){
                    curr /= 10;
                }
                curr += 1;
            }

        }
        System.out.println(res.get(2));
        return res;
    }
}
