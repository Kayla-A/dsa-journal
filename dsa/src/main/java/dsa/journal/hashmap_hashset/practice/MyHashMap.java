package dsa.journal.hashmap_hashset.practice;

public class MyHashMap {
    private MapNode[] buckets;
    private int size;

    
    public MyHashMap() {
        buckets = new MapNode[16];
        size = 0;

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new MapNode();
        } // for
    } // MyHashMap

    private int hash(int key) {
        return Math.abs(key % buckets.length);
    } // hash

    // replace value key if exist
    public void put(int key, int value) {
        int index = hash(key);
        MapNode curr = buckets[index];

        // iterate to the end of the nodes in the bucket
        while(curr.getNextNode() != null && curr.getNextNode().getKey() != key) {
            curr = curr.getNextNode();
        } // while

        // add node with key & update size
        if(curr.getNextNode() == null) {
            curr.setNextNode(new MapNode(value, key));
            size++;
        } else curr.getNextNode().setValue(value);
    } // put

    // return null if absent
    public Integer get(int key) {
        int index = hash(key);
        MapNode curr = buckets[index].getNextNode();

        while(curr != null && curr.getKey() != key) {
            curr = curr.getNextNode();
        } // while

        return curr == null ? null : curr.getValue();
    } // get 

    // return old value, null if not there
    public Integer remove(int key) {
        int index = hash(key);
        MapNode parent = buckets[index];
        MapNode curr = parent.getNextNode();

        if(curr == null) return null; // no elements return null

        // iterate through nodes in bucket 
        while(curr != null && curr.getKey() != key) {
            curr = curr.getNextNode();
            parent = parent.getNextNode();
        } // while

        if(curr == null) return null; // key not found return false

        // remove element & update pointers/size
        parent.setNextNode(curr.getNextNode());
        size--;

        return curr.getValue();
    } // remove

    public boolean containsKey(int key) {
        int index = hash(key);
        MapNode curr = buckets[index].getNextNode();

        while(curr.getNextNode() != null && curr.getKey() != key) {
            curr = curr.getNextNode();
        } // while

        return curr == null ? false : true;
    } // containsKey

    public int size() {
        return this.size;
    } // size

    int bucketLength(int index) {
        int length = 0;
        MapNode curr = buckets[index].getNextNode();

        while(curr != null) {
            length++;
            curr = curr.getNextNode();
        } // while

        return length;
    } // bucketLength

} // MyHashMap
