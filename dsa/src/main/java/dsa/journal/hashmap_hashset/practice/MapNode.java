package dsa.journal.hashmap_hashset.practice;

public class MapNode extends Node {
    private Integer key;
    
    public MapNode() {
        super();
        this.key = null;
    } // MapNode

    public MapNode(Integer key) {
        this.key = key;
    } // MapNode

    public MapNode(int value, Integer key) {
        super(value);
        this.key = key;
    } // MapNode

    public MapNode(int value, Node child, Integer key) {
        super(value, child);
        this.key = key;
    } // MapNode

    public Integer getKey() {
        return key;
    } // getKey

    public void setKey(Integer key) {
        this.key = key;
    } // setKey

    public int getValue() {
        return super.getValue();
    } // getValue

    public void setValue(int value) {
        super.setValue(value);
    } // setValue

    public MapNode getNextNode() {
        return (MapNode) this.nextNode;
    } // getNextNode

    public void setNextNode(MapNode nextNode) {
        this.nextNode = nextNode;
    } // setNextNode
} // MapNode
