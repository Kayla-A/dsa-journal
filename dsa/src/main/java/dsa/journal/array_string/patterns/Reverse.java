package dsa.journal.array_string.patterns;

import java.util.Arrays;

public class Reverse {
    /* 
        Pattern:
            Two pointers start at opposite ends and conduct an 
            in place swap.
        
        Trigger:
            in place
            O(1) space
            reverse
            mirror

     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4}; // the array to reverse

        int l = 0; // pointer for the left side of the array
        int r = arr.length - 1; // pointer for the right side of the array

        /* 
            loop that reverses the array
            condition: l < r:
            when l >= r the middle element has been reachd or the last pair of elements has
            already been swapped and we can stop the loop
            why not l <= r: redundant swapping of middle element
        */
        while(l < r) {
            int temp = arr[l]; // temp variable to hold element at left pointer
            arr[l] = arr[r]; // moving right element to the left
            arr[r] = temp; // moving previously saved left element to the right
            l++; // adjust left pointer
            r--; // adjust right pointer
        } // while

        System.out.println(Arrays.toString(arr));

    } // main

} // ReverseArray
