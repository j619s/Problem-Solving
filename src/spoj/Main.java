package spoj;

import java.io.*;
import java.util.*;

class Main {
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
    static InputReader sc = new InputReader(System.in);
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

        int V = sc.nextInt();
        int E = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }

        boolean[] visited = new boolean[V + 1];
        //writing the code for topological sort.
        List<Integer> res = new ArrayList<>();
        topsort(adj, V, res);
        if(res.isEmpty()){
            pw.print("Sandro fails.");
        }

        for(int i = 0; i < res.size(); i++){
            pw.print(res.get(i) + " ");
        }
        pw.close();
    }

    public static void topsort(List<List<Integer>> adj, int V, List<Integer> res){
        int[] indegree = new int[V + 1];
        for(int u = 1; u <= V; u++){
            for(int v : adj.get(u)){
                indegree[v]++;
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 1; i <= V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            res.add(u);
            for(int v : adj.get(u)){
                if(--indegree[v] == 0){
                    q.add(v);
                }
            }
        }
    }


    public static void addEdge(List<List<Integer>> adj, int u, int v){
        adj.get(u).add(v);
    }


}