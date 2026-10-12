package dsa.journal.array_string.patterns;

public class OppositeEnds {
    /*
        Pattern:
            Two pointers start at both ends and move toward each other
        
        Trigger: 
            symmetric problem
            sorted order determines which pointer to move
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
            /*
                Inner loop conditions also l < r so pointers don't cross and read past
                the string
             */
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++; // skip non alphanumeric characters heading to the right
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) r--; // skip non alphanumeric characters heading to the left
            
            // -------- do some processing or comparisson --------

            l++; // update left pointer 
            r--; // update right pointer
        } // while
        
    } // main

} // OppositeEnds
