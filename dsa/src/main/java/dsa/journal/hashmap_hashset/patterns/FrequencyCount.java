package dsa.journal.hashmap_hashset.patterns;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCount {
    /*
        Pattern
            one pass, counting how many times each value appears

        Time Complexity
            O(n)

        Space Complexity
            O(k) where k = number of distinct characters

        Triggers
            anagram
            rearrange
            same characters
            permutation of
            can be constructed from
            any problem where you ask how many of each, or whether you have enough of each

        Invariant
            after i characters, count[x] equals the occurrences of x in s[0..i) minus those in t[0..i)
     */

    // Unicode & mixed case input
    private static Map<Character, Integer> hashMapFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>(); // map to count character frequencies

        // map character and frequency
        for(char c : s.toCharArray()) {
            freq.merge(c, 1, Integer::sum);
        } // for

        return freq;
    } // hashMapFrequency

    // breaks on Unicode input
    private static int[] arrayFrequency(String s) {
        int[] count = new int[26]; // array to hold frequencies

        // increase count at index that corresponds to the current char
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        } // for

        return count;
    } // arrayFrequency
    public static void main(String[] args) {
        String s = "thisisastringmadefortesting";

        Map<Character, Integer> m = hashMapFrequency(s);
        for(Map.Entry<Character, Integer> c : m.entrySet()) {
            System.out.println("Map Key: " + c.getKey() + " Value: " + c.getValue());
        } // for

        System.out.println();

        int[] a = arrayFrequency(s);
        for(int i = 0; i < a.length; i++) {
            if(a[i] > 0) System.out.println("Array Key: " + (char) ('a'+i)  + " Value: " + a[i]);
        } // for

    } // main

} // FrequencyCount
