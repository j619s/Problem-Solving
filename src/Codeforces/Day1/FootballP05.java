package Codeforces.Day1;

import java.io.*;
import java.util.*;


public class FootballP05 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -------------------------------------

      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      int result = 3*n;
      out.println(result);                    // print via PrintWriter
      */

        // Stop writing your solution here. -------------------------------------
        String s = sc.nextLine();
        int countOne = 0;
        int countZero = 0;
        int maxOneCount = Integer.MIN_VALUE;
        int maxZeroCount = Integer.MIN_VALUE;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                countOne++;
                maxZeroCount = Math.max(countZero, maxZeroCount);
                countZero = 0;
            } else {
                countZero++;
                maxOneCount = Math.max(maxOneCount, countOne);
                countOne = 0;
            }
        }

        maxOneCount = Math.max(maxOneCount, countOne);
        maxZeroCount = Math.max(maxZeroCount, countZero);

        if(maxOneCount >=7 || maxZeroCount >= 7){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


        out.close();
    }



    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    //--------------------------------------------------------
}
