package dsa.journal.array_string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

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
    @DisplayName("Empty string should return empty string")
    void reverseEmptyString() {
        String res = StringUtils.reverse("");

        assertEquals("", res, "Empty string reversed should be an empty string");
    } // reverseEmptyString

    @Test
    @DisplayName("Reverse single character should return single character")
    void reverseSingleCharacter() {
        String res = StringUtils.reverse("k");

        assertEquals("k", res, "String of length 1 shold be same reversed");
    } // reverseSingleCharacter

    @Test
    @DisplayName("String should be reversed")
    void reverseValidString() {
        String res = StringUtils.reverse("This string should be REVERSED!");

        assertEquals("!DESREVER eb dluohs gnirts sihT", res, "String did not reverse correctly");
    } // reverseValidString

    @Test
    @DisplayName("Null string should trow IllegalArgumentException")
    void reverseNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.reverse(null);
        });

        assertEquals("Argument cannot be null", e.getMessage());
    } // reverseNull

    @Test
    @DisplayName("Empty string palindrome: should return true")
    void palindromeEmptyString() {
        boolean res = StringUtils.isPalindrome("");

        assertEquals(true, res, "Empty string should be a palindrome");
    } // palindromeEmptyString

    @Test
    @DisplayName("Length 1 string: should return true")
    void palindromeSingleCharacter() {
        boolean res = StringUtils.isPalindrome("A");

        assertEquals(true, res, "String of length one should be a palindrome");
    } // palindromeSingleCharacter

    @Test
    @DisplayName("Palindrome: should return true")
    void palindromeValidString() {
        boolean res = StringUtils.isPalindrome("racecar");

        assertEquals(true, res, "String is a valid palindrome");
    } // palindromeValidString

    @Test
    @DisplayName("Not Palindrome: should return false")
    void palindromeInvalidString() {
        boolean res = StringUtils.isPalindrome("Madam, I'm Adam!");

        assertEquals(false, res, "String is NOT be a valid palindrome");
    } // palindromeValidString

    @Test
    @DisplayName("Null string should trow IllegalArgumentException")
    void palindromeNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.isPalindrome(null);
        });

        assertEquals("Argument cannot be null", e.getMessage());
    } // palindromeNull

    @Test
    @DisplayName("Count Vowels Empty String: should return 0")
    void vowelsEmptyString() {
        int res = StringUtils.countVowels("");

        assertEquals(0, res, "Empty string has no vowels");
    } // vowelsEmptyString

    @Test
    @DisplayName("Count Vowels Single Vowel: should return 1")
    void vowelseSingleCharacter() {
        int res = StringUtils.countVowels("A");

        assertEquals(1, res, "String with single vowel should return 1");
    } // vowelseSingleCharacter

    @Test
    @DisplayName("Count Vowles Valid String Lower Case: should return 8")
    void vowelsLowerCase() {
        int res = StringUtils.countVowels("mmadam, i'm adam! help us out?");

        assertEquals(9, res, "Incorrect number of vowels");
    } // vowelsMixedCase

    @Test
    @DisplayName("Count Vowles Valid String Upper Case: should return 8")
    void vowelsUpperCase() {
        int res = StringUtils.countVowels("MMADAM, I'M ADAM! HELP US OUT?");

        assertEquals(9, res, "Incorrect number of vowels");
    } // vowelsMixedCase

    @Test
    @DisplayName("Count Vowles Valid String Mixed Case: should return 8")
    void vowelsMixedCase() {
        int res = StringUtils.countVowels("Mmadam, I'm Adam! Help us out?");

        assertEquals(9, res, "Incorrect number of vowels");
    } // vowelsValidString

    @Test
    @DisplayName("Count Vowles Valid String: should return 0")
    void noVowels() {
        int res = StringUtils.countVowels("Mmdm, 'm dm! Hlp s t?");

        assertEquals(0, res, "Incorrect number of vowels");
    } // vowelsValidString

    @Test
    @DisplayName("Null string should trow IllegalArgumentException")
    void vowelsNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.countVowels(null);
        });

        assertEquals("Argument cannot be null", e.getMessage());
    } // vowelsNull
    
} // StringUtilsTest
