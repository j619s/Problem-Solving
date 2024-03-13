package LinkedList;

public class RotateLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(19);
        ListNode n5 = new ListNode(12);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(26);
        ListNode n8 = new ListNode(18);
        ListNode n9 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        System.out.println(n1);
        int k = 9;
        ListNode curr = n1;
        ListNode prevCurr = null;
        while(k != 0){
            prevCurr = curr;
            curr = curr.next;
            k--;
        }
        System.out.println(prevCurr);
        System.out.println(curr);
        ListNode last = curr;
        if(curr != null){
            while(last.next!=null){
                last = last.next;
            }
        }
        if(last != null){
            last.next = n1;
            prevCurr.next = null;
        } else {
            System.out.println(n1);
        }


        System.out.println(curr);

    }

}
