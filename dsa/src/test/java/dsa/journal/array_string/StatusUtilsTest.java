package dsa.journal.array_string;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatusUtilsTest {
    long min, max;
    double average;
    long[] minMax;

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
    void singleElement() {
        min = StatusUtils.min(new int[]{1});
        max = StatusUtils.max(new int[]{1});
        average = StatusUtils.average(new int[]{1});
        minMax = StatusUtils.minMax(new int[]{1});

        assertEquals(1, min);
        assertEquals(1, max);
        assertEquals(1.0, average);
        assertArrayEquals(new long[]{1, 1}, minMax);
    } // singleElement

    @Test
    void allEqualValues() {
        min = StatusUtils.min(new int[]{2, 2, 2, 2, 2, 2, 2});
        max = StatusUtils.max(new int[]{2, 2, 2, 2, 2, 2, 2});
        average = StatusUtils.average(new int[]{2, 2, 2, 2, 2, 2, 2});
        minMax = StatusUtils.minMax(new int[]{2, 2, 2, 2, 2, 2, 2});

        assertEquals(2, min);
        assertEquals(2, max);
        assertEquals(2.0, average);
        assertArrayEquals(new long[]{2, 2}, minMax);
    } // allEqualValues

    @Test
    void negativeValues() {
        min = StatusUtils.min(new int[]{-1, -5, -3, -19, -10, -3, -120});
        max = StatusUtils.max(new int[]{-1, -5, -3, -19, -10, -3, -120});
        average = StatusUtils.average(new int[]{-1, -5, -3, -19, -10, -3, -120});
        minMax = StatusUtils.minMax(new int[]{-1, -5, -3, -19, -10, -3, -120});

        assertEquals(-120, min);
        assertEquals(-1, max);
        assertEquals(-23.0, average);
        assertArrayEquals(new long[]{-120, -1}, minMax);
    } // negativeValues

    @Test
    void resultAtFirstPosition() {
        min = StatusUtils.min(new int[]{0, 3, 10, 55, 1, 350});
        max = StatusUtils.max(new int[]{350, 3, 10, 55, 0, 1});
        minMax = StatusUtils.minMax(new int[]{0, 350, 3, 10, 55, 1});

        assertEquals(0, min);
        assertEquals(350, max);
        // assertEquals(, average);
        assertArrayEquals(new long[]{0, 350}, minMax);
    } // resultAtFirstPosition

    @Test
    void resultAtLastPosition() {
        min = StatusUtils.min(new int[]{350, 3, 10, 55, 1, 0});
        max = StatusUtils.max(new int[]{1, 3, 10, 55, 0, 350});
        minMax = StatusUtils.minMax(new int[]{3, 10, 55, 1, 350, 0});

        assertEquals(0, min);
        assertEquals(350, max);
        assertArrayEquals(new long[]{0, 350}, minMax);
    } // resultAtLastPosition

    @Test
    void emptyArray() {
        assertThrows(IllegalArgumentException.class, () -> { StatusUtils.min(new int[]{}); });
        assertThrows(IllegalArgumentException.class, () -> { StatusUtils.max(new int[]{}); });
        assertThrows(IllegalArgumentException.class, () -> { StatusUtils.average(new int[]{}); });
        assertThrows(IllegalArgumentException.class, () -> { StatusUtils.minMax(new int[]{}); });
    } // emptyArray

    // finish
    @Test
    void overFlow() {
        min = StatusUtils.min(new int[]{Integer.MIN_VALUE, 3, 5, Integer.MIN_VALUE + Integer.MIN_VALUE});
        max = StatusUtils.max(new int[]{Integer.MAX_VALUE, 3, 5, Integer.MAX_VALUE + Integer.MAX_VALUE});
        average = StatusUtils.average(new int[]{Integer.MIN_VALUE + Integer.MIN_VALUE, 3, 5, Integer.MAX_VALUE + Integer.MAX_VALUE});
        minMax = StatusUtils.minMax(new int[]{Integer.MIN_VALUE + Integer.MIN_VALUE, 3, 5, Integer.MAX_VALUE + Integer.MAX_VALUE});

        assertEquals(Integer.MIN_VALUE + Integer.MIN_VALUE, min);
        assertEquals(Integer.MAX_VALUE + Integer.MAX_VALUE, max);
        assertEquals((((Integer.MIN_VALUE + Integer.MIN_VALUE) + 3 + 5 + (Integer.MAX_VALUE + Integer.MAX_VALUE)) / 4), average);
        assertArrayEquals(new long[]{Integer.MIN_VALUE + Integer.MIN_VALUE, Integer.MAX_VALUE + Integer.MAX_VALUE}, minMax);
    } // overFlow



} // StatusUtilsTest
