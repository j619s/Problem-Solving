import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 1;
        int max = 0;
        for(int i = 1; i < str.length(); i++){
            char ch = str.charAt(i);
            char ch1 = str.charAt(i - 1);
            //System.out.println("ch & ch1: " + ch+":"+ch1);
            if(ch == ch1){
                count++;
                max = Math.max(max, count);
            } else  {
                max = Math.max(count, max);
                count = 1;
            }
        }
        System.out.println(Math.max(max, count));
        //AAATCCGGGGTTAAACCCCC
        //ATTCGGGA
    }
}
