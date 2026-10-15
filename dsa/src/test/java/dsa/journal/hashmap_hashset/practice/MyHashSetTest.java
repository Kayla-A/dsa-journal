package dsa.journal.hashmap_hashset.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyHashSetTest {
    MyHashSet set = new MyHashSet();

    @BeforeEach
    void setUp() {
        System.out.println("--------Begining Test--------");
        System.out.println();
        set = new MyHashSet();
    } // setUp

    @AfterEach
    void finish() {
        System.out.println();
        System.out.println("--------Test Completed--------");
    } //finish

    @Test
    @DisplayName("Add One Element")
    void addElement() {
        boolean res = set.add(4);
        assertEquals(true, res);
        assertEquals(true, set.contains(4));
        assertEquals(1, set.size());
    } // addElement

    @Test
    @DisplayName("Add Duplicate Element")
    void addDuplicate() {
        boolean res = set.add(4);
        assertEquals(true, res);
        assertEquals(true, set.contains(4));
        assertEquals(1, set.size());

        for(int i = 0; i < 5; i++) {
            res = set.add(4);
            assertEquals(false, res);
            assertEquals(true, set.contains(4));
            assertEquals(1, set.size());
        } // for 
    } // addDuplicate

     @Test
    @DisplayName("Add One Negative Element")
    void addNegativeElement() {
        boolean res = set.add(-4);
        assertEquals(true, res);
        assertEquals(true, set.contains(-4));
        assertEquals(1, set.size());
    } // addNegativeElement

    @Test
    @DisplayName("Add Duplicate Negative Element")
    void addNegativeDuplicate() {
        boolean res = set.add(-4);
        assertEquals(true, res);
        assertEquals(true, set.contains(-4));
        assertEquals(1, set.size());

        for(int i = 0; i < 5; i++) {
            res = set.add(-4);
            assertEquals(false, res);
            assertEquals(true, set.contains(-4));
            assertEquals(1, set.size());
        } // for 
    } // addNegativeDuplicate

    @Test
    @DisplayName("Remove Existing Element")
    void removeElement() {
        set.add(4);
        assertEquals(1, set.size());

        boolean res = set.remove(4);
        assertEquals(true, res);
        assertEquals(false, set.contains(4));
        assertEquals(0, set.size());
    } // removeElement

    @Test
    @DisplayName("Remove Existing Negative Element")
    void removeNegativeElement() {
        set.add(-5);
        assertEquals(1, set.size());

        boolean res = set.remove(-5);
        assertEquals(true, res);
        assertEquals(false, set.contains(-5));
        assertEquals(0, set.size());
    } // removeNegativeElement

    @Test
    @DisplayName("Remove Missing Element")
    void removeMissingElement() {
        assertEquals(0, set.size());

        boolean res = set.remove(4);
        assertEquals(false, res);
        assertEquals(false, set.contains(4));
        assertEquals(0, set.size());
    } // removeMissingElement

    @Test
    @DisplayName("Remove Missing NegativeElement")
    void removeMissingNegativeElement() {
        assertEquals(0, set.size());

        boolean res = set.remove(-5);
        assertEquals(false, res);
        assertEquals(false, set.contains(-5));
        assertEquals(0, set.size());
    } // removeMissingNegativeElement

    @Test
    @DisplayName("Forced Collision")
    void forcedCollision() {
        // make private helper to check bucket length 
        // and make sure elements actually added

        // add 1
        assertEquals(true, set.add(1));
        assertEquals(1, set.size());
        assertEquals(true, set.contains(1));

        // add 17
        assertEquals(true, set.add(17));
        assertEquals(2, set.size());
        assertEquals(true, set.contains(17));

        // add 33
        assertEquals(true, set.add(33));
        assertEquals(3, set.size());
        assertEquals(true, set.contains(33));

        // add -31
        assertEquals(true, set.add(-31));
        assertEquals(4, set.size());
        assertEquals(true, set.contains(-31));

        // ad -15
        assertEquals(true, set.add(-15));
        assertEquals(5, set.size());
        assertEquals(true, set.contains(-15));

        // add duplicate
        assertEquals(false, set.add(1));
        assertEquals(3, set.size());
        assertEquals(true, set.contains(1));

        // remove 17
        assertEquals(true, set.remove(17));
        assertEquals(4, set.size());
        assertEquals(false, set.contains(17));
        assertEquals(true, set.contains(1));
        assertEquals(true, set.contains(33));

        // remove 33
        assertEquals(true, set.remove(33));
        assertEquals(3, set.size());
        assertEquals(false, set.contains(33));
        assertEquals(true, set.contains(1));

        // remove -15
        assertEquals(true, set.remove(-15));
        assertEquals(2, set.size());
        assertEquals(false, set.contains(-15));
        assertEquals(true, set.contains(-31));
        assertEquals(true, set.contains(1));

        // remove -31
        assertEquals(true, set.remove(-31));
        assertEquals(1, set.size());
        assertEquals(false, set.contains(-31));
        assertEquals(true, set.contains(1));

        // remove 1
        assertEquals(true, set.remove(1));
        assertEquals(0, set.size());
        assertEquals(false, set.contains(1));
        
    } // private
    
} // MyHashSetTest
