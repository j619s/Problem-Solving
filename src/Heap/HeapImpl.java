package Heap;

public class HeapImpl {
    public int[] arr;
    public int size, capacity;

    HeapImpl(int cap){
        size = 0;
        capacity = cap;
        arr = new int[cap];
    }

    public static void main(String[] args) {

    }

    public void extractMin(){
        
    }


    public void minHeapify(int i){
        int left = left(i);
        int right = right(i);
        int smallest = i;

        if(left < size && arr[i] < arr[left]){
            smallest = left;
        }
        if(right < size && arr[right] < arr[smallest]){
            smallest = right;
        }

        if(smallest != i){
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(smallest);

        }


    }

    public int parent(int i){
        return (i - 1) / 2;
    }

    public int left(int i){
        return 2 * i + 1;
    }
    public int right(int i){
        return 2 * i - 2;
    }
}
