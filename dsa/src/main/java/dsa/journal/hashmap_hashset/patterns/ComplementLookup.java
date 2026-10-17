package dsa.journal.hashmap_hashset.patterns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComplementLookup {
    /*
        Pattern
            one pass
            for each element, ask “has the partner I need already appeared?” before recording this element

        Time Complexity
            O(n)

        Space Complexity
            O(n) 

        Triggers
            two numbers that add up to 
            pair with a given sum or difference
            return indices
            the input is unsorted
            general shape: each element has exactly one partner determined by a formula

        Invariant
            before processing index i, the map holds every value in nums[0..i) with its index
     */

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // value -> index

        for(int i = 0; i < nums.length; i++) {
            int need = target - nums[i]; // compliment currently needed

            // check for compliment
            if(seen.containsKey(need)) return new int[] {seen.get(need), i};
            
            seen.put(nums[i], i); // record after checking
        } // for

        return new int[] {}; // result DNE
    } // twoSum

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 66, 3, 9, 12};
        int target = 10;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    } // main

} // ComplementLookup
