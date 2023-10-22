import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Template {
    static class InputReader{
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream){
            reader = new BufferedReader(new InputStreamReader(stream),32768);
            tokenizer = null;
        }

        String next(){
            while(tokenizer == null || !tokenizer.hasMoreTokens()){
                try{
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        /*
        String word = r.next();
        String str = r.reader.readLine();
        int a = r.nextInt();
        long a = r.nextLong();
        double a = r.nextDouble();
        pw.print(str);
        pw.println(str);
        */
        int n = r.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(n!=0){
            int a = r.nextInt();
            int b = r.nextInt();
            map.put(a,b);
            n--;
        }
        pw.println(map);

        pw.close();
    }
}
