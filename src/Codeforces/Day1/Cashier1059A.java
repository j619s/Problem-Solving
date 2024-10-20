package Codeforces.Day1;

import java.io.*;
import java.util.*;


public class Cashier1059A {
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
        int n = sc.nextInt();
        int L = sc.nextInt();
        int a = sc.nextInt();

        int[] t = new int[n];
        int[] l = new int[n];

        for(int i = 0; i < n; i++){
            t[i] = sc.nextInt();
            l[i] = sc.nextInt();
        }

        int start = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            res += (t[i] - start) / a;
            start = (t[i] + l[i]);
        }
        res += (L - start) / a;
        out.println(res);


        out.close();
    }

    // <-brk_1->         <-brk_2->           <-- brk_3 -->           <-- brk_4--->
    // 0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20  21
    //          x  x  x  x        y   y   y   y           z   z   z   z



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

