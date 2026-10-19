package dsa.journal.hashmap_hashset.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Pattern
        compute a key that’s identical for everything that belongs together
        then collect into a map of lists

    Time Complexity
        O(n*klogk) with sorted keys
        O(n*k) with count keys

    Space Complexity
        O(n*k) 

    Triggers
        group
        same letters
        anagram
        any problem where items are equal under some transformation (sorting, counting, normalizing)

    Invariant
        after i words, each map entry holds exactly the words from strs[0..i) whose key matches
*/

public class GroupByKey {
    // derived canonical key
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>(); // word sorted -> list of matching anagrams

        for(String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            groups.computeIfAbsent(new String(cs), k -> new ArrayList<>()).add(s);
        } // for

        return new ArrayList<>(groups.values());
    } // groupAnagrams

    public static void main(String[] args) {
        String[] strs = {
            "post",
            "pots",
            "cat",
            "act",
            "aloof",
            "loofa"
        };

        System.out.println(groupAnagrams(strs).toString());
    } // main
} // GroupByKey
