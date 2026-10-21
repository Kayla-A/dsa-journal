package dsa.journal.lists_stacks_queues.patterns;

import dsa.journal.lists_stacks_queues.practice.ListNode;

public class FastSlowPointers {
    /*
        Pattern
            two pointers over the same list, one moving 1 step per turn and the other 2

        Time Complexity
            O(n)

        Space Complexity
            O(1)

        Triggers
            cycle
            loop
            detect without extra memory
            middle of the list” (when fast hits the end, slow is at the middle)
            k-th node from the end (start one pointer k steps ahead)

        Invariant
            if a cycle exists, the gap between the pointers inside the cycle shrinks by 1 each step
            so they must meet. if there’s no cycle, fast reaches null first
    */ 

    private static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if(slow == fast) return true;
        } // while

        return false;
    } // hasCycle

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(head);

        System.out.println(hasCycle(head));
    } // main
} // FastSlowPointers
