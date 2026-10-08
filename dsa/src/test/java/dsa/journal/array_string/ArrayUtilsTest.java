package dsa.journal.array_string;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dsa.journal.array_string.patterns.ArrayUtils;

public class ArrayUtilsTest {
    
    @BeforeEach
    void setUp() {
        System.out.println("--------Begining Test--------");
        System.out.println();
    } // setUp

    @AfterEach
    void finish() {
        System.out.println();
        System.out.println("--------Test Completed--------");
    } // setUp

    @Test
    void bothEmpty() {
        int[] res = ArrayUtils.mergeSorted(new int[]{}, new int[]{});

        assertArrayEquals(new int[]{}, res, "Two empty arrays should result in an empty array");
    } // bothEmpty

    @Test
    void oneEmptyEmpty() {
        int[] res = ArrayUtils.mergeSorted(new int[]{}, new int[]{2, 3, 5, 19, 21, 25});

        assertArrayEquals(new int[]{2, 3, 5, 19, 21, 25}, res, "Should return the non empty array");
    } // oneEmptyEmpty

    @Test
    void equalLength() {
        int[] res = ArrayUtils.mergeSorted(new int[]{1,3,5,7}, new int[]{2,4,6,8});

        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8}, res);
    } // equalLength

    @Test
    void differentLengths() {
        int[] res = ArrayUtils.mergeSorted(new int[]{1,3,5,7, 15, 19, 30}, new int[]{2,4,6,8});
        
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,15,19,30}, res);
    } // differentLengths

    @Test
    void duplicatesInArrays() {
        int[] res = ArrayUtils.mergeSorted(new int[]{1,1,3,6,8}, new int[]{2,3,4,4,4,10,10});
        
        assertArrayEquals(new int[]{1,1,2,3,3,4,4,4,6,8,10,10}, res);
    } // duplicatesInArrays

    @Test
    void negatives() {
        int[] res = ArrayUtils.mergeSorted(new int[]{-5,-5,-3, -2,0,5,7}, new int[]{-6,-4,-3,-1,1,4});
        
        assertArrayEquals(new int[]{-6,-5,-5,-4,-3,-3,-2,-1,0,1,4,5,7}, res);
    } // negatives

    @Test
    void sortedABeforeSortedB() {
        int[] res = ArrayUtils.mergeSorted(new int[]{1,4,6,8}, new int[]{9,10,15,17});
        
        assertArrayEquals(new int[]{1,4,6,8,9,10,15,17}, res);
    } // sortedABeforeSortedB

    @Test
    void sortedBBeforeSortedA() {
        int[] res = ArrayUtils.mergeSorted(new int[]{9,10,15,17}, new int[]{1,4,6,8});
        
        assertArrayEquals(new int[]{1,4,6,8,9,10,15,17}, res);
    } // sortedBBeforeSortedA

    @Test
    void interleavedValues() {
        int[] res = ArrayUtils.mergeSorted(new int[]{1,3,5,7,9,11}, new int[]{2,4,6,8,10});
        
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10,11}, res);
    } // interleavedValues

    @Test
    void bothNull() {
        int[] res = ArrayUtils.mergeSorted(new int[]{1,3,5,7,9,11}, null);
        
        assertArrayEquals(new int[]{1,3,5,7,9,11}, res);
    } // bothNull

    @Test
    void oneNull() {
        int[] res = ArrayUtils.mergeSorted(null, null);
        
        assertArrayEquals(new int[]{}, res);
    } // oneNull

} // ArrayUtilsTest
