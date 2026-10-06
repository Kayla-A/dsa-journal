package dsa.journal.array_string.patterns;

public class OppositeEnds {
    /*
        Algorithm that processes only the alphanumeric characters in a string
     */
    public static void main(String[] args) {
        String s = "!Kay!*la0)"; // string to use in algorithm

        int l = 0; // left pointer, starts at the beginning og the string
        int r = s.length() - 1; // right pointer, starts at the end of the string
       
        /*
            loop to iterate over the string and do some work only on 
            alphanumeric characters

            condition(l < r):
            iterates over the string without iterating over already processed
            elements or iterating out of bounds
         */
        while(l < r) {
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++; // skip non alphanumeric characters heading to the right
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) r--; // skip non alphanumeric characters heading to the left
            
            // -------- do some processing or comparisson --------

            l++; // update left pointer 
            r--; // update right pointer
        } // while
        
    } // main

} // OppositeEnds
