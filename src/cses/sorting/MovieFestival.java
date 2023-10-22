package cses.sorting;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class MovieFestival {
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }
    }
    public static void main(String[] args) throws IOException {
        MovieFestival.Reader br = new MovieFestival.Reader();

        int n = br.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        while(n != 0){
            int begin = br.nextInt();
            int end = br.nextInt();
            map.put(end, begin);

            n--;
        }
        System.out.println(map);
        int ans = 0;
        int currentEventEnd = -1;
        for(Map.Entry<Integer, Integer> val : map.entrySet()){
            if(val.getValue() >= currentEventEnd){
                currentEventEnd = val.getKey();
                ans++;
            }
        }

        System.out.println(ans);




    }
    
}
