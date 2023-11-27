package cses.sorting;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class CollectingNumbersI {
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
        CollectingNumbersI.Reader br = new CollectingNumbersI.Reader();

        int n = br.nextInt();
        int[] arr = new int[n];
        int[] pos = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = br.nextInt();
            arr[i]--;     //subtracting 1 to make it 0 based indexing.
            pos[arr[i]] = i;
        }
        int rounds = 1;
        for(int i = 1; i < n; i++){
            if (pos[i] < pos[i - 1]){
                rounds++;       //pos of value i is larger than pos of value i + 1 we increment the round.
            }
        }
        System.out.println(Arrays.toString(pos));
        System.out.println(rounds);
    }
}
