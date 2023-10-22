import java.util.HashSet;

public class KAvoidingArray {
    public static void main(String[] args) {
        int res = minimumSum(27,49);
        System.out.println(res);
    }
    public static int minimumSum(int n, int k) {
        int sum = 0;
        HashSet<Integer> hash = new HashSet<>();
        int i = 1;
        while(n!=0){
            if(!hash.contains(k - i)){
                hash.add(i);
                sum+=i;
                n--;
            }
            i++;
        }

        return sum;
    }
}
