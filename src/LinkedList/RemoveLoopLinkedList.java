package LinkedList;

public class RemoveLoopLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(6);
        n1.next = n2;
        n2.next =  n3;
        n3.next = n1;
        removeLoop(n1);
    }

    public static void removeLoop(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            if(slow == fast){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;

        }

        if(slow == fast){
            slow = head;
            if(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;

        } else {
            while(fast.next != slow){
                fast = fast.next;
            }
            fast.next = null;
        }

        System.out.println(slow.val);
        System.out.println(fast.val);
    }
}
