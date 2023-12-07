package cses.sorting;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashSet;

public class CollectingNumbersII {
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

    static class Pair<K, V> {
        K first;
        V second;

        public Pair(K first_value, V second_value) {
            first = first_value;
            second = second_value;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((first == null) ? 0 : first.hashCode());
            result = prime * result + ((second == null) ? 0 : second.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Pair<?, ?> other = (Pair<?, ?>) obj;
            if (first == null) {
                if (other.first != null)
                    return false;
            } else if (!first.equals(other.first))
                return false;
            if (second == null) {
                return other.second == null;
            } else return second.equals(other.second);
        }
    }
    public static void main(String[] args) throws IOException {
        CollectingNumbersII.Reader br = new CollectingNumbersII.Reader();

        int n = br.nextInt();
        int m = br.nextInt();
        int[] arr = new int[n+1];
        int[] pos = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = br.nextInt();
            pos[arr[i]] = i;
        }
        int rounds = 1;
        for(int i = 1; i < n; i++){
            if(pos[i] > pos[i + 1]){
                rounds++;
            }
        }
//        5 3
//        4 2 1 5 3
//        2 3
//        1 5
//        2 3
//
//  sorted:       1 2 3 4 5
//  pos:          3 2 5 1 4        arr: 4 2 1 5 3   (1 based indexing).


        HashSet<Pair<Integer, Integer>> updatedPairs = new HashSet<>();
        int l, r;

        while(m-- != 0){
            l = br.nextInt();
            r = br.nextInt();

            if(arr[l] + 1 <= n){
                Pair<Integer, Integer> pair = new Pair<>(arr[l], arr[l] + 1);
                updatedPairs.add(pair);
            }
            if(arr[l] - 1 >= 1){
                Pair<Integer, Integer> pair = new Pair<>(arr[l] - 1, arr[l]);
                updatedPairs.add(pair);
            }
            if(arr[r] + 1 >= 1){
                Pair<Integer, Integer> pair = new Pair<>(arr[r], arr[r] + 1);
                updatedPairs.add(pair);
            }
            if(arr[r] - 1 >= 1){
                Pair<Integer, Integer> pair = new Pair<>(arr[r] - 1, arr[r]);
                updatedPairs.add(pair);
            }

            for(Pair<Integer, Integer> p : updatedPairs){
                if(pos[p.first] > pos[p.second]){
                    rounds--;
                }
            }

            int temp  = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            pos[arr[l]] = l;
            pos[arr[r]] = r;

            for(Pair<Integer, Integer> swapped : updatedPairs){
                if(pos[swapped.first] > pos[swapped.second]){
                    rounds++;
                }
            }
            System.out.println(rounds);
            updatedPairs.clear();
        }


    }


}
