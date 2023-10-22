import java.util.Scanner;

public class PermutationsCSES {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder str = new StringBuilder();
        int value = 2;

        if(n == 2 || n == 3){
            System.out.println("NO SOLUTION");
        } else {
            while(value <= n){
                str.append(value).append(" ");
                value +=2;
            }
            value = 1;
            while(value <= n){
                str.append(value).append(" ");
                value +=2;
            }

            System.out.println(str);
        }


    }
}
