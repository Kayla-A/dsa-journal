package dsa.journal.lists_stacks_queues.patterns;

import dsa.journal.lists_stacks_queues.practice.ListNode;

public class DummyHead {
    /*
        Pattern
            put a fake node (sentinal node) in front of the real head so the head gets no special case
            then look one node ahead (curr.next)

        Time Complexity
            O(n)

        Space Complexity
            O(1)

        Triggers
            the head might be removed/changed
            return the new head
            delete nodes that match a condition

        Invariant
            everything up to and including curr is final, and curr.next is the next node to examine
    */
    private static ListNode removeElement(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.setNext(head);

        ListNode curr = dummy;
        while(curr.getNext() != null) {
            if(curr.getNext().getVal() == val) curr.setNext(curr.getNext().getNext());
            else curr = curr.getNext();
        } //while

        return dummy.getNext();
    } // removeElement

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        ListNode removed = removeElement(head, 2);
        while(removed != null) {
            System.out.print(removed.getVal() + " ");
            removed = removed.getNext();
        } // while

        System.out.println();
    } // main

} // DummyHead