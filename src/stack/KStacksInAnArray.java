package stack;

public class KStacksInAnArray {
    int[] arr;
    int[] top;  // stores the top index of `k` stacks
    int[] next; // stores next entry in all stacks and free list

    int n, k;
    int free; // To store beginning index of free list

    public KStacksInAnArray(int k1, int n1) {
        k = k1;
        n = n1;
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        // initialize all stacks as empty
        for (int i = 0; i < k; i++)
            top[i] = -1;

        //initialize all spaces as free
        free = 0;
        for(int i = 0; i < n - 1; i++){
            next[i] = i + 1;
        }
        next[n - 1] = -1; // -1 is used to indicate end of free list

    }

    boolean isFull(){
        return (free == -1);
    }

    void push(int item, int sn){


        if(isFull()){
            System.out.println("Stack overflow...");
            System.exit(1);
        }

        int i = free;   //store index of first free slot

        // update index of free slot to index of next slot in free list
        free = next[i];

        // update next of top and then top for stack number `sn`
        next[i] = top[sn];
        top[sn] = i;

        //put the item in array
        arr[i] = item;

    }

    int pop(int sn){
        if(isEmpty(sn)){
            System.out.println("Stack undeflow...");
            return Integer.MAX_VALUE;
        }

        //Find index of top item in stack number `sn`
        int i = top[sn];

        top[sn] = next[i]; // change top to store next of previous top

        //attach the previous top to the beginning of free list
        next[i] = free;
        free = i;

        // return the previous top item
        return arr[i];
    }

    boolean isEmpty(int sn){
        return top[sn] == -1;
    }

    public static void main(String[] args) {
        int k = 3, n = 10;
        KStacksInAnArray ks = new KStacksInAnArray(k, n);



        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        ks.push(15, 2);
        ks.push(45, 2);



        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));

    }
}
