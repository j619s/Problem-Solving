package LinkedList;

import java.util.Arrays;

public class SplitLinkedListInParts725 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//        ListNode five = new ListNode(5);
//        ListNode six = new ListNode(6);
//        ListNode seven = new ListNode(7);
//        ListNode eight = new ListNode(8);
//        ListNode nine = new ListNode(9);
//        ListNode ten = new ListNode(10);
          head.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
//        five.next = six;
//        six.next = seven;
//        seven.next = eight;
//        eight.next = nine;
//        nine.next = ten;
        System.out.println(Arrays.toString(splitListToParts(head, 2)));
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        // if(len == 1){
        //     arr[0] = head;
        // }
        int quotient = len / k;
        int remainder = len % k;
        //System.out.println(len + ", " + quotient + ", " + remainder);
        int idx = 0;
        curr = head;
        if(len < k){
            while(curr != null){
                arr[idx++] = new ListNode(curr.val);
                curr = curr.next;
            }
        } else {
            ListNode next = curr;
            ListNode prev = curr;
            idx = 0;
            int temp = remainder;
            while(temp != 0){
                for(int i = 0; i < quotient + 1; i++){
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = null;
                arr[idx++] = next;
                next = curr;
                temp--;
            }

            // int count = quotient - 1;
            while(curr != null){
                for(int i = 0; i < quotient; i++){
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = null;
                arr[idx++] = next;
                if(curr != null){
                    next = curr;
                } else {
                    break;
                }
                //count--;
            }
        }

        return arr;
    }
}
