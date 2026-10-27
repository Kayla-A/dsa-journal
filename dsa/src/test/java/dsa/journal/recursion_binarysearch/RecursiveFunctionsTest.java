package dsa.journal.recursion_binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dsa.journal.recursion_binarysearch.practice.RecursiveFunctions;

public class RecursiveFunctionsTest {
 
    @Test
    @DisplayName("Factorial 0, 1, negative, overflow")
    void factorial() {
        assertEquals(1L, RecursiveFunctions.factorial(0));
        assertEquals(1L, RecursiveFunctions.factorial(1));
        assertThrows(InvalidParameterException.class, () -> { RecursiveFunctions.factorial(-5); });
        assertEquals(6227020800L, RecursiveFunctions.factorial(13));
    } // factorial

    @Test
    @DisplayName("Sum Digits 0 & negatives")
    void sumDigits() {
        assertEquals(0, RecursiveFunctions.sumDigits(0));
        assertEquals(4, RecursiveFunctions.sumDigits(121));
        assertEquals(2, RecursiveFunctions.sumDigits(-121));
    } // sumDigits

    @Test
    @DisplayName("Fibbonaci 0, 1 & negatives")
    void fibonnaci() {
        assertEquals(0, RecursiveFunctions.fib(0));
        assertEquals(1, RecursiveFunctions.fib(1));
        assertEquals(55, RecursiveFunctions.fib(10));
        assertEquals(2, RecursiveFunctions.fib(-3));
        assertEquals(-1, RecursiveFunctions.fib(-2));
        assertEquals(-8, RecursiveFunctions.fib(-6));
    } // fib

    @Test
    @DisplayName("Power 0 exponent, negative base & negative exponent")
    void power() {
        assertEquals(1f, RecursiveFunctions.power(2, 0));
        assertEquals(9f, RecursiveFunctions.power(3, 2));
        assertEquals(9f, RecursiveFunctions.power(-3, 2));
        assertEquals(16f, RecursiveFunctions.power(-4, 2));
        assertEquals(0.11111111f, RecursiveFunctions.power(3, -2));
        assertEquals(0.1111111111111111f, RecursiveFunctions.power(-3, -2));
        assertEquals(-0.037037037037037f, RecursiveFunctions.power(-3, -3));
    } // power

    @Test
    @DisplayName("Is Palindrome \"\", \" \" & valid input ")
    void palindrome() {
        assertEquals(true, RecursiveFunctions.isPalindrome("", 0, 0));
        assertEquals(true, RecursiveFunctions.isPalindrome(" ", 0, 0));
        assertEquals(true, RecursiveFunctions.isPalindrome("racecar", 0, 6));
        assertEquals(false, RecursiveFunctions.isPalindrome("racekcar", 0, 7));
    } // palindrome

    @Test
    @DisplayName("Reverse String \"\", \" \" & valid input ")
    void reverseString() {
        assertEquals("", RecursiveFunctions.reverseString("", 0, 0));
        assertEquals(" ", RecursiveFunctions.reverseString(" ", 0, 0));
        assertEquals("ruhtrAalyaK", RecursiveFunctions.reverseString("KaylaArthur", 0, 10));
    } // reverseString




} // RecursiveFunctionsTest
