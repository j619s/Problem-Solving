package stack;

public class Implement2StacksInAnArray {
    int size;
    int top1, top2;
    int[] arr;

    public Implement2StacksInAnArray(int n) {
        size =  n;
        arr = new int[n];
        top1 = -1;
        top2 = size;
    }

    void push1(int x){
        if(top1 < top2 - 1){
            top1++;
            arr[top1] = x;
        } else  {
            System.out.println("Stack overflow....");
            System.exit(1);
        }

    }

    void push2(int x){
        if(top1 < top2 - 1){
            top2--;
            arr[top2] = x;
        } else {
            System.out.println("Stack overflow...");
            System.exit(1);
        }
    }

    int pop1(){
        if(top1 >= 0){
            int x = arr[top1];
            top1--;
            return x;
        } else {
            System.out.println("Stack Underflow...");
            System.exit(1);
        }
        return 0;
    }

    int pop2(){
        if(top2 < size){
            int x = arr[top2];
            top2++;
            return x;
        } else {
            System.out.println("Stack Underflow...");
            System.exit(1);
        }
        return 0;
    }

    public static void main(String[] args) {
        Implement2StacksInAnArray ts = new Implement2StacksInAnArray(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from"
                + " stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from"
                + " stack2 is " + ts.pop2());
    }

}
