package LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode n = new ListNode(4);
        n.next = new ListNode(5);

        ListNode n2 = new ListNode(3);
        n2.next = new ListNode(4);
        n2.next.next = new ListNode(5);

        System.out.println(addTwoLists(n, n2));
    }

    public static ListNode addTwoLists(ListNode first, ListNode second){
        ListNode res = new ListNode(0);
        ListNode curr = res;
        ListNode f = Reverse.reverse(first);
        ListNode s = Reverse.reverse(second);
        int carry = 0;

        while(f != null || s != null){
            int x = f != null ? f.val : 0;
            int y = s != null ? s.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(f != null) f = f.next;
            if(s != null) s = s.next;

        }

        if(carry > 0){
            curr.next = new ListNode(carry);
        }

        return Reverse.reverse(res.next);
    }
}
