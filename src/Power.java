public class Power {
    public static void main(String[] args) {
        //System.out.println(power(9,9));

        String s = "abcdef";
        int a = s.charAt(0);
        char ch = s.charAt(4);
        System.out.println(a);
        System.out.println(ch - 'a');
    }

    static int power(int n, int p){
        int res = 1;

        while(p != 0){
            if(p % 2 == 1){
                res = res * n;
            }

            n = n * n;
            p = p / 2;
        }
        return res;
    }
}
