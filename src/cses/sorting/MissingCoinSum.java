package cses.sorting;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MissingCoinSum {
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
        MissingCoinSum.Reader br = new MissingCoinSum.Reader();

        int n = br.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = br.nextInt();
        }
        Arrays.sort(arr);
        long res = 1;
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(arr[i] > res){
                System.out.println(res);
                flag = true;
                break;
            } else {
                res += arr[i];
            }
        }
        if(!flag){
            System.out.println(res);
        }

        /*

        Explanation:
            At any index i in a sorted array a, currSum represents sum(a[ 0...i ]).
            We can form every possible sum from 1...currSum, when we are at index i.
            So the next possible smallest sum at index i can be currSum+1.
            We can get currSum+1 as the answer if and only if a[i+1] > currSum + 1,
            otherwise we would be able to form subsets with sums from 1...(currSum + a[i+1])
            ( just add a[i+1] to all subsets which give sum 1...currSum to get subsets giving sum 1...currSum+a[i+1]).

            Try this on pen and paper and it will be more clear.

        */
    }
}
