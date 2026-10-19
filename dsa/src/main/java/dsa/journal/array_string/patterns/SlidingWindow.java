package dsa.journal.array_string.patterns;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

    // no duplicates
    private static int longestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int best = 0;

        for(int right = 0; right < s.length(); right++) {
            while(window.contains(s.charAt(left))) {
                left++;
            } // while

            window.add(s.charAt(right));
            best = Math.max(best, right - left + 1);
        } // for

        return best;
    } // longestSubstring
    public static void main(String[] args) {
        String s = "sirnfkfoiwbrnvcksksnfcdnssfi";

        System.out.println(longestSubstring(s));
    } // main
} // SlidingWindow
