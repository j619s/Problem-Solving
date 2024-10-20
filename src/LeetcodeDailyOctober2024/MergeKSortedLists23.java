package LeetcodeDailyOctober2024;

import LinkedList.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists23 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(6);
        l7.next = l8;

        ListNode[] arr = {l1, l4, l7};
        System.out.println(mergeKLists(arr));


    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < len; i++){
            ListNode curr = lists[i];
            while(curr != null){
                pq.offer(curr.val);
                curr = curr.next;
            }
        }

        System.out.println(pq);

        return new ListNode(0);

    }
}
