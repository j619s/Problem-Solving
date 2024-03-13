public class Test {
    public static void main(String[] args) {
        int k = 235;
        String str = String.valueOf(k);
        System.out.println(str);
        int first = Integer.parseInt(String.valueOf(str.charAt(0)));
        System.out.println(first);
        int start = 0;
        while(k != 0){
            start = k % 10;
            k = k / 10;
        }
        System.out.println(start);
    }
}
