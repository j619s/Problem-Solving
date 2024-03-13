package LinkedList;

public class Reverse {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(n1);
        ListNode rev = reverse(n1);
        System.out.println(rev);
    }

    static ListNode reverse(ListNode head){
        if(head == null) return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
