package dsa.journal.hashmap_hashset.practice;

public class MyHashSet {
    // Fixed capacity of 16
    private int size;
    private Node[] buckets;

    public MyHashSet() {
        size = 0;
        buckets = new Node[16];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new Node();
        } // for
    } // MyHashSet

    private int hash(int key) {
        // hash by division
        return Math.abs(key % buckets.length);
    } // hash

    public boolean add(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        // iterate to the end of the nodes in the bucket
        while(curr.getNextNode() != null) {
            curr = curr.getNextNode();

            if(curr != null && curr.getValue() == key) return false; // value already in set -> return false
        } // while

        // add node with key & update size
        curr.setNextNode(new Node(key));
        size++;

        return true;
    } // add

    public boolean remove(int key) {
        int index = hash(key);
        Node parent = buckets[index];
        Node curr = parent.getNextNode();

        if(curr == null) return false; // no elements, key not found -> return false

        // iterate through nodes in bucket 
        while(curr != null && curr.getValue() != key) {
            curr = curr.getNextNode();
            parent = parent.getNextNode();
        } // while

        if(curr == null) return false; // key not found return false

        // remove element & update pointers/size
        parent.setNextNode(curr.getNextNode());
        size--;

        return true;
    } // remove

    public boolean contains(int key) {
        int index = hash(key);
        Node curr = buckets[index].getNextNode();

        while(curr != null && curr.getValue() != key) {
            curr = curr.getNextNode();
        } // while

        return curr != null && curr.getValue() == key;
    } // contains

    public int size() {
        return this.size;
    } // size

    int bucketLength(int index) {
        int length = 0;
        Node curr = buckets[index].getNextNode();

        while(curr != null) {
            length++;
            curr = curr.getNextNode();
        } // while

        return length;
    } // bucketLength

    void printSet() {
        for(int i = 0; i < buckets.length; i++) {
            Node curr = buckets[i].getNextNode();
            if(curr != null) System.out.print("INDEX " + i + ": ");
            while(curr != null) {
                System.out.print(curr.getValue() + ", ");
                curr = curr.getNextNode();
            } // while
        } // for
    } // printSet

} // MyHashSet
