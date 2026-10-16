package dsa.journal.hashmap_hashset.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyHashMapTest {
    MyHashMap map = new MyHashMap();

    @BeforeEach
    void setUp() {
        System.out.println("--------Begining Test--------");
        System.out.println();
        map = new MyHashMap();
    } // setUp

    @AfterEach
    void finish() {
        System.out.println();
        System.out.println("--------Test Completed--------");
    } //finish

    @Test
    @DisplayName("Add One Element")
    void putThenGet() {
        map.put(0, 1);
        assertEquals(true, map.containsKey(0));
        assertEquals(1, map.size());
        assertEquals(1, map.get(0));
    } // putThenGet

    @Test
    @DisplayName("Override Key")
    void overrideKey() {
        map.put(0, 1);
        assertEquals(1, map.get(0));
        assertEquals(true, map.containsKey(0));
        assertEquals(1, map.size());

        map.put(0, 10);
        assertEquals(10, map.get(0));
        assertEquals(true, map.containsKey(0));
        assertEquals(1, map.size());
    } // overrideKey

    @Test
    @DisplayName("Get Then Remove")
    void getThenRemove() {
        map.put(0, 1);
        assertEquals(1, map.size());
        assertEquals(null, map.get(1));
        assertEquals(null, map.remove(1));
        assertEquals(1, map.size());
    } // putThenGet

    @Test
    @DisplayName("Remove Return Value")
    void removeReturnsOldValue() {
        map.put(0, 1);
        assertEquals(1, map.get(0));
        assertEquals(1, map.remove(0));
        assertEquals(0, map.size());
    } // getReturnsOldValue

    @Test
    @DisplayName("Check 0 Stored")
    void storingValueZero() {
        map.put(9, 0);
        assertEquals(0, map.get(9));
        assertEquals(1, map.size());
    } // storingValueZero

    @Test
    @DisplayName("Collisions")
    void forcedCollisions() {
        // add 1
        map.put(1, 1);
        assertEquals(1, map.size());

        // add 17
        map.put(17, 17);
        assertEquals(2, map.size());

        // add 33
        map.put(33, 33);
        assertEquals(3, map.size());

        // add -15
        map.put(-15, -15);
        assertEquals(4, map.size());

        // add -31
        map.put(-31, -31);
        assertEquals(5, map.size());

        // override 17
        map.put(17, 170);
        assertEquals(170, map.get(17));
        assertEquals(5, map.size());

        // override -31
        map.put(-31, -3100);
        assertEquals(-3100, map.get(-31));
        assertEquals(5, map.size());

        assertEquals(3,map.bucketLength(1));
        assertEquals(2,map.bucketLength(15));

        // remove 17
        map.remove(17);
        assertEquals(4, map.size());

        // remove -31
        map.remove(-31);
        assertEquals(3, map.size());

        assertEquals(2,map.bucketLength(1));
        assertEquals(1,map.bucketLength(15));

    } // forcedCollisions
    

} // MyHashMapTest
