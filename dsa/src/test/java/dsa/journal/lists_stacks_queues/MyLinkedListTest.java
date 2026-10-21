package dsa.journal.lists_stacks_queues;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dsa.journal.lists_stacks_queues.practice.MyLinkedList;

public class MyLinkedListTest {
    MyLinkedList list;
    
    @BeforeEach 
    void setUp() {
        list = new MyLinkedList();
    } // setUp

    @Test
    @DisplayName("Empty List")
    void emptyList() {
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.size());
        assertEquals(false, list.contains(0));

        System.out.println(list.toString());
    } // emptyList

    @Test
    @DisplayName("One element")
    void oneElement() {
        assertEquals(0, list.size());

        // add element
        assertEquals(true, list.add(0));
        System.out.println(list.toString());

        // check list added element
        assertEquals(0, list.getHead().getVal());
        assertEquals(0, list.getTail().getVal());
        assertEquals(1, list.size());
        assertEquals(true, list.contains(0));

        // remove element
        assertEquals(0, list.remove(0));
        System.out.println(list.toString());

        // check list removed element
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.size());
        assertEquals(false, list.contains(0));

        // add element 
        list.addFirst(0);
        System.out.println(list.toString());

        // checl list added element
        assertEquals(0, list.getHead().getVal());
        assertEquals(0, list.getTail().getVal());
        assertEquals(1, list.size());
        assertEquals(true, list.contains(0));
    } // oneElement

    @Test
    @DisplayName("Many elements")
    void manyElements() {
        assertEquals(0, list.size());

        // add elements
        assertEquals(true, list.add(0));
        assertEquals(true, list.add(1));
        assertEquals(true, list.add(2));
        assertEquals(true, list.add(2));
        assertEquals(true, list.add(3));
        assertEquals(true, list.add(1));

        // check elements added
        assertEquals(0, list.getHead().getVal());
        assertEquals(1, list.getTail().getVal());
        assertEquals(6, list.size());
        
        // show list
        System.out.println(list.toString());
    } // manyElements

    @Test
    @DisplayName("Remove head, middle, tail")
    void removeElements() {
        assertEquals(true, list.add(0));
        assertEquals(true, list.add(1));
        assertEquals(true, list.add(2));
        assertEquals(true, list.add(2));
        assertEquals(true, list.add(3));
        assertEquals(true, list.add(1));

        assertEquals(0, list.remove(0));
        System.out.println(list.toString());

        assertEquals(2, list.remove(2));
        System.out.println(list.toString());

        assertEquals(1, list.remove(1));
        System.out.println(list.toString());
    } // removeElements

    @Test
    @DisplayName("Remove from one element list")
    void removeFromSizeOne() {
        assertEquals(0, list.size());

        // add element
        assertEquals(true, list.add(0));
        System.out.println(list.toString());

        // remove element
        assertEquals(0, list.remove(0));
        System.out.println(list.toString());

        // check list removed element
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.size());
        assertEquals(false, list.contains(0));
    } // removeFromSizeOne

    @Test
    @DisplayName("Remove missing value")
    void removeMissing() {
        assertEquals(0, list.size());

        // add element
        assertEquals(true, list.add(0));

        // remove element
        assertEquals(null , list.remove(10));
        assertEquals(1, list.size());
        System.out.println(list.toString());
    } // removeMissing

    @Test
    @DisplayName("Remove with duplicates")
    void removeWithDuplicates() {
        // add elements
        assertEquals(true, list.add(0));
        assertEquals(true, list.add(1));
        assertEquals(true, list.add(2));
        assertEquals(true, list.add(2));
        assertEquals(true, list.add(3));
        assertEquals(true, list.add(1));

        assertEquals(2, list.remove(2));
        System.out.println("removed 2 " + list.toString());

        assertEquals(1, list.remove(1));
        System.out.println("removed 1 " + list.toString());
        assertEquals(1, list.remove(1));
        assertEquals(3, list.getTail().getVal());
        System.out.println("removed 1 " + list.toString());

        assertEquals(2, list.remove(2));
        System.out.println("removed 2 " + list.toString());
        assertEquals(0, list.remove(0));
        System.out.println("removed 0 " + list.toString());

        assertEquals(3, list.getHead().getVal());
        assertEquals(3, list.getTail().getVal());
    } // removeWithDuplicates

    @Test
    @DisplayName("Get: empty, 1, many")
    void get() {
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(0);});

        assertEquals(true, list.add(10));
        assertEquals(10, list.get(0));
        System.out.println(list.toString());

        assertEquals(true, list.add(0));
        assertEquals(true, list.add(1));
        assertEquals(true, list.add(2));
        assertEquals(true, list.add(2));
        assertEquals(true, list.add(3));
        assertEquals(true, list.add(1));
        System.out.println("removed 2 " + list.toString());

        assertEquals(10, list.get(0));
        assertEquals(0, list.get(1));
        assertEquals(2, list.get(4));
        assertEquals(1, list.get(6));
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(7);});

        assertEquals(10, list.getHead().getVal());
        assertEquals(1, list.getTail().getVal());
    } // get

    @Test
    @DisplayName("Reverse: empty, 1, many, with add & remove")
    void reverse() {
        list.reverse();
        System.out.println("reversed empty " + list.toString());

        assertEquals(true, list.add(10));
        list.reverse();
        System.out.println("reversed one " + list.toString());

        assertEquals(true, list.add(0));
        assertEquals(true, list.add(1));
        assertEquals(true, list.add(2));
        assertEquals(true, list.add(2));
        assertEquals(true, list.add(3));
        assertEquals(true, list.add(1));
        list.reverse();
        System.out.println("reversed many " + list.toString());

        assertEquals(0, list.remove(0));
        assertEquals(true, list.add(7));
        assertEquals(true, list.add(100));
        list.addFirst(612);
        assertEquals(1, list.remove(1));
        assertEquals(2, list.remove(2));
        assertEquals(true, list.add(6));
        list.reverse();
        System.out.println("reversed add/remove " + list.toString());

        assertEquals(6, list.getHead().getVal());
        assertEquals(612, list.getTail().getVal());
    } // reverse

} // MyLinkedListTest
