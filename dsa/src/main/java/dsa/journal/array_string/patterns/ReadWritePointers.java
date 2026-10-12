package dsa.journal.array_string.patterns;

import java.util.Arrays;

public class ReadWritePointers {
    /*
        Other Names
            Slow/Fast 
            In-place compaction 
        
        Pattern
            Same-direction two pointers
            read always moves forward by one
            write moves forward only when you keep an element

        Time Complexity
            O(n)

        Space Complexity
            O(1)

        Triggers
            Do it in place / O(1) extra space
            Remove, filter, move, deduplicate elements from an array
            Return the new length 
            Keep the relative order of what remains
            The output is the same elements as the input, just fewer or rearranged

        Invariant

     */
    private static int removeElement(int[] nums, int val) {
        int write = 0; // write pointer, holds length without elemnts == val

        /*
            Walk through the array once with a read pointer that looks at every element
            Keep a write pointer that marks the next slot for a kept element
            When read finds an element worth keeping, copy it to write and advance write
            Skipped elements are never copied, so they get overwritten or left behind
            At the end, write equals the number of kept elements
         */
        for(int read = 0; read < nums.length; read++) {
            if(nums[read] != val) {
                nums[write] = nums[read]; // swap elements
                write++; // update write pointer
            } // if
        } // for

        return write; // new length
    } // removeElement

    public static void main(String[] args) {
        int[] nums = {4, -9, 5, 2, 6, -9, 8, 10, 394, -42, -9, 4, -9};
        int val = -9;

        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    } // main

} // ReadWritePointers
