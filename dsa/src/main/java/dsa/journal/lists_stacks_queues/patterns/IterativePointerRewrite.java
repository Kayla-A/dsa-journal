package dsa.journal.lists_stacks_queues.patterns;

import dsa.journal.lists_stacks_queues.practice.ListNode;

public class IterativePointerRewrite {
    /*
        Pattern
            one pass, pointer rewrite to reverse a linked list

        Time Complexity
            O(n)

        Space Complexity
            O(1)

        Triggers
            reverse
            in place
            any task that changes how existing nodes link without making new ones

        Invariant
            prev is the head of the already-reversed part, curr is the head of the unprocessed remainder
            and together they cover every node
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        } // while

        return prev;
    } // reverseList

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        ListNode reversed = reverseList(head);
        while(reversed != null) {
            System.out.print(reversed.getVal() + " ");
            reversed = reversed.getNext();
        } // while

        System.out.println();
    } // main

} // IterativePointerRewrite
