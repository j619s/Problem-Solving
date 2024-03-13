package LinkedList;

public class RemoveNthNodeFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(removeNthFromEnd(head,1));

    }
    //Approach 1: getting the length of linked list.

    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode curr = head;
        int count = 0;

        while(curr != null){
            count++;
            curr = curr.next;
        }

        if(count == n){
            head = head.next;
            return head;
        }

        curr = head;
        ListNode prev = null;


        for(int i = 0; i < count - n; i++){
            prev = curr;
            curr = curr.next;
        }
        if(prev == null){
            return prev;
        }

        prev.next = curr.next;

        System.out.println(prev);
        System.out.println(curr);
        System.out.println(count);



        return head;
    }




}
