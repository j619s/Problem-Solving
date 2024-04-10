package LeetcodeDailyApril2024;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets2073 {
    public static void main(String[] args) {
        int[] tickets = {5,2,2,2};
        int k = 0;
        //System.out.println(timeRequiredToBuy(tickets, k));
       // System.out.println(timeRequiredToBuyII(tickets, k));
        System.out.println(timeRequiredToBuyIII(tickets, k));
    }
    // Approach I: Simulating using Queue
    public static int timeRequiredToBuy(int[] tickets, int k){
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        for(int i = 0; i < tickets.length; i++){
            q.add(i);
        }

        while(!q.isEmpty()){

            time++;
            int front = q.poll();
            tickets[front]--;

            if(front == k && tickets[front] == 0){
                return time;
            }

            if(tickets[front] != 0){
                q.add(front);
            }
        }

        return time;
        //T.C. = O(n.m) len of tickets * max no. tickets
    }

    // Approach II:  Without using constant space.
    public static int timeRequiredToBuyII(int[] tickets, int k) {
        int ele = tickets[k];
        int time = 0;
        while(ele != 0){
            for(int i = 0; i < tickets.length; i++){
                if(tickets[i] != 0 && i == k){
                    time++;
                    tickets[i]--;
                    ele--;
                } else if(tickets[i] != 0) {
                    time++;
                    tickets[i]--;
                }

                if(ele == 0){
                    return time;
                }
            }
        }

        return time;
    }

    // Approach III: Using constant space.

    public static int timeRequiredToBuyIII(int[] tickets, int k) {
        int time = 0;

        for(int i = 0; i < tickets.length; i++){
            if(i <= k){
                time += Math.min(tickets[k], tickets[i]);
            } else {
                time += Math.min(tickets[k] - 1, tickets[i]);
            }
        }

        return time;
    }




    /*The above two solutions explicitly simulated the process of buying tickets for each person in the queue. However, we can develop a more efficient approach because we know how many tickets the kth person needs. That is, we can directly calculate the time required based on the number of tickets each person needs without explicitly modeling the entire sequential process of buying tickets.

We can break down the entire problem into two cases:

    Case 1: The current person is before or at the desired person k.
    Case 2: The current person is after k.

By considering these two cases, we can directly calculate the time required for the kth person to buy all their tickets.

Case 1: If the current person is before or at the desired person k:

    We will buy the minimum number of tickets between what the kth person needs and what the current person needs.
    For example: If the kth person needs 3 tickets, and the current person needs 2 tickets, we will buy 2 tickets for the current person. Similarly, if the kth person needs 2 tickets, and the current person needs 4 tickets, we will buy 2 tickets for the current person.
    This is because we want to ensure that the kth person gets the tickets they need, and people before the kth person will only have the opportunity to buy up to tickets[k] tickets.

Case 2: If the current person (i) is after kth person i.e, i > k:

    We buy the minimum of (tickets needed by person k - 1) and the current person.
    People after k in line will have fewer opportunities to buy tickets than person k does. If they need fewer than tickets[k] tickets, they will be able to purchase them all. Otherwise, they will purchase tickets[k] - 1 tickets.
    For example: If the kth person needs 3 tickets (tickets[k] = 3), and the current person needs 1 ticket, we will buy 1 ticket for the current person. Conversely, if the current person needs 3 tickets, we will buy 2 tickets for the current person. The current person will only have the opportunity to buy 2 tickets before person k has purchased all of their tickets.

In simpler terms, when the current person is before or at the kth person, we buy the minimum number of tickets needed by both people. When we are at a person after the kth person, we know the current person will only have the opportunity to buy tickets[k] - 1 tickets, so we buy the minimum between that and the current person's needed tickets.*/
}
