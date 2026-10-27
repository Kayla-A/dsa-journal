package dsa.journal.recursion_binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dsa.journal.recursion_binarysearch.practice.MyBinarySearch;

public class MyBinarySearchTest {
    int[] a = {1, 2, 4, 5, 5, 7, 9, 10, 12, 24, 33, 33};
    int[] b = {1, 2, 4, 5, 5, 7, 9, 10, 12, 24, 33};
    int[] c = {-12, -10, -5, -4, -2, -2 ,-1, 2, 4, 5, 5, 7, 9};
    int[] d = {-5, -4, -1, 2, 4, 5, 5, 7, 9, 10, 12, 24, 33, 33};

    @Test
    @DisplayName("Iterative indexOf()")
    void iterativeIndexOf() {
        assertEquals(-1, MyBinarySearch.indexOf(new int[]{}, 1));
        assertEquals(0, MyBinarySearch.indexOf(new int[]{1}, 1));
        assertEquals(-1, MyBinarySearch.indexOf(new int[]{0}, 1));
        assertEquals(0, MyBinarySearch.indexOf(a, 1));
        assertEquals(10, MyBinarySearch.indexOf(a, 33));
        assertEquals(-1, MyBinarySearch.indexOf(a, 0));
        assertEquals(-1, MyBinarySearch.indexOf(a, 34));
        assertEquals(7, MyBinarySearch.indexOf(b, 10));
        assertEquals(3, MyBinarySearch.indexOf(a, 5));
        assertEquals(3, MyBinarySearch.indexOf(b, 5));
        assertEquals(1, MyBinarySearch.indexOf(c, -10));
        assertEquals(4, MyBinarySearch.indexOf(c, -2));
        assertEquals(0, MyBinarySearch.indexOf(c, -12));
        assertEquals(-1, MyBinarySearch.indexOf(c, -13));
    } // iterativeIndexOf

    @Test
    @DisplayName("Recursive indexOf()")
    void recursiveIndexOf() {
        assertEquals(-1, MyBinarySearch.indexOf(new int[]{}, 1, 0, 0));
        assertEquals(0, MyBinarySearch.indexOf(new int[]{1}, 1, 0, 0));
        assertEquals(-1, MyBinarySearch.indexOf(new int[]{0}, 1, 0 ,0));
        assertEquals(0, MyBinarySearch.indexOf(a, 1, 0, a.length - 1));
        assertEquals(10, MyBinarySearch.indexOf(a, 33, 0, a.length - 1));
        assertEquals(-1, MyBinarySearch.indexOf(a, 0, 0, a.length - 1));
        assertEquals(-1, MyBinarySearch.indexOf(a, 34, 0, a.length - 1));
        assertEquals(7, MyBinarySearch.indexOf(b, 10, 0, b.length - 1));
        assertEquals(3, MyBinarySearch.indexOf(a, 5, 0, a.length - 1));
        assertEquals(3, MyBinarySearch.indexOf(b, 5, 0, b.length - 1));
        assertEquals(1, MyBinarySearch.indexOf(c, -10, 0, c.length - 1));
        assertEquals(4, MyBinarySearch.indexOf(c, -2, 0, c.length - 1));
        assertEquals(0, MyBinarySearch.indexOf(c, -12, 0, c.length - 1));
        assertEquals(-1, MyBinarySearch.indexOf(c, -13, 0, c.length - 1));
    } // recursiveIndexOf

    @Test
    @DisplayName("insertPosition()")
    void insertPosition() {
        assertEquals(0, MyBinarySearch.insertPosition(new int[]{}, 1));
        assertEquals(0, MyBinarySearch.insertPosition(new int[]{1}, 1));
        assertEquals(1, MyBinarySearch.insertPosition(new int[]{0}, 1));
        assertEquals(3, MyBinarySearch.insertPosition(d, 1));
        assertEquals(12, MyBinarySearch.insertPosition(d, 32));
        assertEquals(3, MyBinarySearch.insertPosition(d, 0));
        assertEquals(14, MyBinarySearch.insertPosition(d, 34));
        assertEquals(0, MyBinarySearch.insertPosition(d, -6));
        assertEquals(2, MyBinarySearch.insertPosition(d, -3));
    } // insertPosition

} // MyBinarySearchTest
