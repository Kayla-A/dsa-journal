package dsa.journal.lists_stacks_queues.practice;

public class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;
    
    public MyLinkedList() {
        this.size = 0;
        head = null;
        tail = null;;
    } // MyLinkedList

    public ListNode getHead() {
        return head;
    } // getHead

    public void setHead(ListNode head) {
        this.head = head;
    } // setHead

    public ListNode getTail() {
        return tail;
    } // getTail

    public void setTail(ListNode tail) {
        this.tail = tail;
    } // setTail

    // adds to the end of the list
    public boolean add(int val) {
        ListNode node = new ListNode(val);
        ListNode curr = head;

        if(size == 0) {
            head = node;
        } else {
            while(curr != null && curr.getNext() != null) {
                curr = curr.getNext();
            } // while

            curr.setNext(node);
        } // if

        tail = node;
        size++;
    
        return tail == node;
    } // add
    
    // adds to the front of the list
    public void addFirst(int val) {
        ListNode node = new ListNode(val), tmp = head;

        head = node;
        node.setNext(tmp);

        if(size == 0) tail = node;

        size++;
    } // addFirst

    // returns removed element or null otherwise
    public Integer remove(int val) {
        ListNode dummy = new ListNode(-100000000);
        dummy.setNext(head);

        ListNode curr = dummy;

        while(curr.getNext() != null) {
            if(curr.getNext().getVal() == val) {
                head = curr.getNext() == head ? curr.getNext().getNext() : head;
                
                if(curr.getNext() == tail && size == 1) tail = null;
                else if(curr.getNext() == tail) tail = curr;

                ListNode removed = curr.getNext();
                curr.setNext(curr.getNext().getNext());

                size--;
                return removed.getVal();
            } // if

            curr = curr.next;
        } // while

        return null;
    } // remove

    public boolean contains(int val) {
        ListNode curr = head;

        while(curr != null) {
            if(curr.getVal() == val) return true;
            curr = curr.getNext();
        } // while

         return false;
    } // contains

    public int size() {
        return size;
    } // size

    public int get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        
        if(index == 0) return head.getVal();
        if(index == size - 1) return tail.getVal();

        ListNode curr = head;

        for(int i = 0; i < index; i++) {
            curr = curr.getNext();
        } // for

        return curr.getVal();
    } // get

    public void reverse() {
        tail = head;

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        } // while

        head = prev;
    } // reverse

    @Override
    public String toString() {
        String s = "MyLinkedList [";
        ListNode curr = head;

        for(int i = 0; i < size; i++) {
            if(i == size - 1) s += curr.getVal();
            else s += curr.getVal() + ", ";
            curr = curr.getNext();
        }
        s += "]";

        return s;
    } // toString

} // MyLinkedList
