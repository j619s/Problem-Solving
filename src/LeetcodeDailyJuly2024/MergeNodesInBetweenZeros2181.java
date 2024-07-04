package LeetcodeDailyJuly2024;

import LinkedList.ListNode;

public class MergeNodesInBetweenZeros2181 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        ListNode res = new MergeNodesInBetweenZeros2181().mergeNodes(node1);
        while(res != null){
            System.out.print(res.val + ",");
            res = res.next;
        }

    }

    public ListNode mergeNodes(ListNode head){
        ListNode curr = head;
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        int sum = 0;
        curr = curr.next;
        while(curr != null){
            if(curr.val != 0){
                sum += curr.val;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
                sum = 0;
            }
            curr = curr.next;
        }
        return res;
    }
    public ListNode mergeNodesII(ListNode head) {
        ListNode prev = head.next;
        ListNode curr = prev;
        int sum = 0;
        while(curr != null){
            if(curr.val != 0){
                sum += curr.val;
                curr = curr.next;
            } else {
                prev.val = sum;
                curr = curr.next;
                prev.next = curr;
                prev = prev.next;
                sum = 0;
            }
        }
        return head.next;
    }
}
