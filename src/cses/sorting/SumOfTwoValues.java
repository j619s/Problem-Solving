package cses.sorting;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
public class SumOfTwoValues {
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
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
        SumOfTwoValues.Reader br = new SumOfTwoValues.Reader();

        int n = br.nextInt();
        int x = br.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < n; i++){
            int ele = br.nextInt();
            arr[i] = ele;
            hash.put(ele, i);
        }
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        boolean f = false;
        while(left != right){
            int sum = arr[left] + arr[right];
            if(sum ==  x){
                int a = hash.get(arr[left]) + 1;
                int b = hash.get(arr[right]) + 1;
                System.out.println(a + " " + b);
                f = true;
                break;
            } else if(sum > x){
                right--;
            } else {
                left++;
            }

        }

        if(!f) {
            System.out.println("IMPOSSIBLE");
        }

    }
}
