package sorting;

import LinkedList.ListNode;

public class InsertionSortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode res = insertSortList(node1);

        while(res != null){
            System.out.println(res.val);
            res  = res.next;
        }
    }

    public static ListNode insertSortList(ListNode head){
        ListNode temp = new ListNode();
        ListNode curr = head;

        while (curr != null){

            ListNode prev = temp;

            while(prev.next != null && prev.next.val <= curr.val){
                prev = prev.next;
            }

            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next  = curr;
            curr = next;

        }
        return temp.next;
    }
}
