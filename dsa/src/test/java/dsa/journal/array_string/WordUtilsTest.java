package dsa.journal.array_string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WordUtilsTest {
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
    @DisplayName("Count: Empty String")
    void countEmptyString() {
        int res = WordUtils.countWords("");

        assertEquals(0, res, "Empty string should be 0 words");
    } // countEmptyString

    @Test
    @DisplayName("Count: Only Spaces")
    void countOnlySpaces() {
        int res = WordUtils.countWords("            ");

        assertEquals(0, res, "Spaces should be 0 words");
    } // countOnlySpaces

    @Test
    @DisplayName("Count: One Word")
    void countOneWord() {
        int res = WordUtils.countWords("Word");

        assertEquals(1, res, "Should return 1");
    } // countOneWord

    @Test
    @DisplayName("Count: Multiple Spaces Between Words")
    void countMultipleSpacesBetweenWords() {
        int res = WordUtils.countWords("Multiple    spaces  between                words.");

        assertEquals(4, res, "Should return 4");
    } // countMultipleSpacesBetweenWords

    @Test
    @DisplayName("Count: Leading Spaces")
    void countLeadingSpaces() {
        int res = WordUtils.countWords("        This has words with leading spaces.");

        assertEquals(6, res, "Should be 6");
    } // countLeadingSpaces

    @Test
    @DisplayName("Count: Trailing Spaces")
    void countTrailingSpaces() {
        int res = WordUtils.countWords("This has words with leading spaces.           ");

        assertEquals(6, res, "Should be 6");
    } // countTrailingSpaces

    @Test
    @DisplayName("Count: Leading & Trailing Spaces")
    void countLeadingTrailingSpaces() {
        int res = WordUtils.countWords("          This has words with leading and trailing spaces.           ");

        assertEquals(8, res, "Should be 8");
    } // countLeadingTrailingSpaces

    @Test
    @DisplayName("Count: Tabs")
    void countTabs() {
        int res = WordUtils.countWords("    This one has    tabs in it  woah.");

        assertEquals(7, res, "Should be 7");
    } // counTabs

    @Test
    @DisplayName("Count: Null")
    void countNull() {
        assertThrows(
            IllegalArgumentException.class,
            () -> { WordUtils.countWords(null); }, 
            "Parameter cannot be null");
    } // countNull

    @Test
    @DisplayName("Capitalize: App Caps")
    void capitalizeAllCaps() {
        String res = WordUtils.capitalizeWords("THIS SENTENCE IS IN ALL CAPS");

        assertEquals("This Sentence Is In All Caps", res);
    } // capitalizeAllCaps

    @Test
    @DisplayName("Capitalize: Correctly Capitalized")
    void capitalizeAlreadyCapitalized() {
        String res = WordUtils.capitalizeWords("This Is Correctly Capitalized Already");

        assertEquals("This Is Correctly Capitalized Already", res);
    } // capitalizeAlreadyCapitalized

    @Test
    @DisplayName("Capitalize: Empty String")
    void capitalizeEmptyString() {
        String res = WordUtils.capitalizeWords("");

        assertEquals("", res);
    } // capitalizeEmptyString

    @Test
    @DisplayName("Capitalize: Only Spaces")
    void capitalizeOnlySpaces() {
        String res = WordUtils.capitalizeWords("            ");

        assertEquals("            ", res);
    } // capitalizeOnlySpaces

    @Test
    @DisplayName("Capitalize: One Word")
    void capitalizeOneWord() {
        String res = WordUtils.capitalizeWords("word");

        assertEquals("Word", res);
    } // capitalizeOneWord

    @Test
    @DisplayName("Capitalize: Multiple Spaces Between Words")
    void capitalizeMultipleSpacesBetweenWords() {
        String res = WordUtils.capitalizeWords("Multiple    spaces  between                words.");

        assertEquals("Multiple    Spaces  Between                Words.", res);
    } // capitalizeMultipleSpacesBetweenWords

    @Test
    @DisplayName("Capitalize: Leading Spaces")
    void capitalizeLeadingSpaces() {
        String res = WordUtils.capitalizeWords("        This has words with leading spaces.");

        assertEquals("        This Has Words With Leading Spaces.", res);
    } // capitalizeLeadingSpaces

    @Test
    @DisplayName("Capitalize: Trailing Spaces")
    void capitalizeTrailingSpaces() {
        String res = WordUtils.capitalizeWords("This has words with leading spaces.           ");

        assertEquals("This Has Words With Leading Spaces.           ", res);
    } // capitalizeTrailingSpaces

    @Test
    @DisplayName("Capitalize: Leading & Trailing Spaces")
    void capitalizeLeadingTrailingSpaces() {
        String res = WordUtils.capitalizeWords("          This has words with leading and trailing spaces.           ");

        assertEquals("          This Has Words With Leading And Trailing Spaces.           ", res);
    } // capitalizeLeadingTrailingSpaces

    @Test
    @DisplayName("Capitalize: Tabs")
    void capitalizeTabs() {
        String res = WordUtils.capitalizeWords("    This one has    tabs in it  woah.");

        assertEquals("    This One Has    Tabs In It  Woah.", res);
    } // capitalizeTabs

    @Test
    @DisplayName("Capitalize: Null")
    void capitalizeNull() {
        assertThrows(
            IllegalArgumentException.class,
            () -> { WordUtils.capitalizeWords(null); }, 
            "Parameter cannot be null");
    } // capitalizeNull

} // WordUtilsTest
