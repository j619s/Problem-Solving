package cses.sorting;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class RestaurantCustomers {
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
        RestaurantCustomers.Reader br = new RestaurantCustomers.Reader();

        int n = br.nextInt();

        TreeMap<Integer, Integer> frequency = new TreeMap<>();
        int res = 0;
        int ans = 0;
        while(n!=0){
            int in = br.nextInt();
            int out = br.nextInt();
            frequency.put(in, frequency.getOrDefault(in, 0) + 1);
            frequency.put(out, frequency.getOrDefault(out, 0) - 1);
            n--;
        }
        System.out.println(frequency);
        for(Map.Entry<Integer, Integer> val : frequency.entrySet()){
            ans += val.getValue();
            res = Math.max(ans, res);
        }
        System.out.println(res);

    }

    // 3 4 5
    // 5 9 8
}
