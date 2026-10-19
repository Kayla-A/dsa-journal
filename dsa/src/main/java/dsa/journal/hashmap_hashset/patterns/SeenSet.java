package dsa.journal.hashmap_hashset.patterns;

import java.util.HashSet;
import java.util.Set;

public class SeenSet {
    /* 
        Pattern
            single pass with hashset

        Time Complexity
            O(n)

        Space Complexity
            O(n)

        Triggers
            “duplicate” 
            “appears twice” 
            “already seen” 
            “distinct” 
            “unique”
            any problem where the brute force is a nested loop asking “does a matching element exist?”
        
        Invariant
            before processing nums[i], seen contains exactly the values in nums[0..i)
     */

    private static boolean containsDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>(); // set to detect duplicates

        /*
            adds each element to the set, since sets cannont contain duplicates
            if a duplicate value is added the set will return false and the loop
            will return true
         */
        for(int n : nums) {
            if(!seen.add(n)) return true; // duplicate found
        } //for

        return false; // no duplicates found
    } // containsDuplicates

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 10, 100, 10, 3, 1, 4} ;

        containsDuplicates(nums);
    } // main 

} // ContainsDuplicates
