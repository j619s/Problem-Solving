package cses.sorting;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CollectingNumbers {
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
        CollectingNumbers.Reader br = new CollectingNumbers.Reader();

        int n = br.nextInt();
        int ans = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] arr = new int[n];
        int index = 0;
        while(n != 0){
            int ele = br.nextInt();
            arr[index] = ele;
            map.put(ele, index++);
            n--;
        }
        int tempIndex = -1;
        for(Map.Entry<Integer, Integer> val : map.entrySet()){
            if(val.getValue() < tempIndex){
                ans++;
            }
            tempIndex = val.getValue();
        }
        System.out.println(ans);
        System.out.println(Arrays.toString(arr));
        System.out.println(map);
    }
}
