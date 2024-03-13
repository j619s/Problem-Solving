package LinkedList;

public class OddEvenLinkedList {
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
        System.out.println(oddEvenList(head));

    }

    public static ListNode oddEvenList(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
