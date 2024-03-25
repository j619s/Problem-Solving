package LeetcodeDailyMarch2024;

import LinkedList.ListNode;

public class MergeInBetweenLinkedLists {
    public static void main(String[] args) {
        //[0,1,2,3,4,5,6,7,8,9]
        ListNode  list1 = new ListNode(0);
        ListNode curr = list1;
        for(int i = 1; i <= 9; i++){
            curr.next = new ListNode(i);
            curr = curr.next;
        }


        //[1000000,1000001,1000002,1000003,1000004,1000005,1000006]
        ListNode list2 = new ListNode(1000000);
        ListNode current = list2;
        for (int i = 1; i <= 6; i++) {
            current.next = new ListNode(1000000 + i);
            current = current.next;
        }
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(mergeInBetween(list1, 3, 5, list2));
    }
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode startA = list1;
        ListNode endB = null;

        while(a > 1){
            a--;
            startA = startA.next;
        }
        System.out.println("endA: "+startA.val);
        endB = list1;
        if(startA.next == null){
            startA.next = list2;
        } else {
            int endPtr = b + 1;
            while(endPtr > 0){
                endB = endB.next;
                endPtr--;
            }

            ListNode endList2 = list2;
            while(endList2.next != null){
                endList2 = endList2.next;
            }
            System.out.println("endB: " + endB.val);
            startA.next = list2;
            endList2.next = endB;
        }

        return list1;

    }
}
