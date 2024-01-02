package recursion;

public class Power {
    public static void main(String[] args) {
        int pow = recPower(2, 3);
        System.out.println(pow);
    }

    static int recPower(int n, int p){
        if(p == 0) return 1;

        int res = recPower(n, p / 2);
        res = res * res;

        if(p % 2 == 1){
            res = res * n;
        }

        return res;
    }
}
