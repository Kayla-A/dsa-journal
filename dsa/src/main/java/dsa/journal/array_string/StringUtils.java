package dsa.journal.array_string;

public class StringUtils {

    

    public StringUtils() {} // StringUtils

    /*
        return the reversed string 
        (do it once with a char array swap, not StringBuilder.reverse)
     */
    static String reverse(String s) throws IllegalArgumentException {
        if(s == null) throw new IllegalArgumentException("Argument cannot be null");

        char[] arr = s.toCharArray();

        int l = 0, r = arr.length - 1;
        while(l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        } // while

        return new String(arr);
    } // reverse

    /*
        exact match, case-sensitive, 
        no cleanup
     */
    static boolean isPalindrome(String s) throws IllegalArgumentException {
        if(s == null) throw new IllegalArgumentException("Argument cannot be null");

        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;

        while(l < r) { 
            if(arr[l] != arr[r]) return false;
            l++;
            r--;
        } // while

        return true;
    } // isPalindrome

    /*
        handle both upper and lower case
     */
    static int countVowels(String s) throws IllegalArgumentException {
        if(s == null) throw new IllegalArgumentException("Argument cannot be null");

        int count = 0;
        String vowels = "AEIOUaeiou";
        char[] tmp = s.toCharArray();

        for(int i = 0; i < tmp.length; i++) {
            if(vowels.indexOf(tmp[i]) > -1) count ++;
        } // for

        return count;
    } // countVowels
} // StringUtils
