package dsa.journal.array_string;

public class WordUtils {
    
    public WordUtils() {} // WordUtils

    /*
        count words separated by any amount of whitespace. 
        Scan once with an inWord boolean: when you move from a 
        space to a non-space, add one.
     */
    public static int countWords(String s) throws IllegalArgumentException {        
        if(s == null) throw new IllegalArgumentException("Parameter cannot be null");

        int count = 0;
        boolean inWord = false;

        for(int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i))) {
                inWord = true;
                count += 1;
            } // if

            while(i < s.length() &&inWord) {
                if(!Character.isLetter(s.charAt(i))) {
                    inWord = false; 
                } // if
                i++;
            } // while
        } // for

        return count;
    } // countWords

    /*
        uppercase the first letter of each word, lowercase the 
        rest, and keep the original spacing. Convert to a char[], 
        loop with a startOfWord flag, then return new String(chars).
     */
    public static String capitalizeWords(String s) throws IllegalArgumentException {
        if(s == null) throw new IllegalArgumentException("Parameter cannot be null");

        boolean startOfWord = false;
        char[] capitalized = s.toCharArray();

        for(int i = 0; i < capitalized.length; i++) {
            if(Character.isLetter(capitalized[i])) {
                capitalized[i] = Character.toUpperCase(capitalized[i]);
                startOfWord = true;
                i++;
            } // if
            // THIS SENTENCE IS CAPS
            while(i < capitalized.length && startOfWord) {
                if(!Character.isLetter(capitalized[i])) {
                    startOfWord = false;
                } else {
                    capitalized[i] = Character.toLowerCase(capitalized[i]);
                    i++;
                } // if
            } // while
        } // for

        return new String(capitalized);
    } // capitalizeWords

} // WordUtils
