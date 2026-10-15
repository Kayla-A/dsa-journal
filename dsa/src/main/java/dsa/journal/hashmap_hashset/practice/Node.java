package dsa.journal.hashmap_hashset.practice;

public class Node {

    private Integer value;
    private Node nextNode;
    
    public Node() {
        this.value = null;
        this.nextNode = null;
    } // Node  

    public Node(int value) {
        this.value = value;
        this.nextNode = null;
    } // Node

    public Node(int value, Node child) {
        this.value = value;
        this.nextNode = child;
    } // Node

    public int getValue() {
        return value;
    } // getValue

    public void setValue(int value) {
        this.value = value;
    } // setValue

    public Node getNextNode() {
        return nextNode;
    } // getNextNode

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    } // setNextNode

    public boolean isParent() {
        return nextNode != null;
    } // isParent

} // Node
