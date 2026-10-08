package dsa.journal.array_string.patterns;

import java.util.Arrays;

public class TargetSum {
    /*
        Pattern:
            Two pointers start at both ends and move toward each other.
            The pointer that move inward at each iteration depends on the current sum.
        Target:
            sorted order determines which pointer to move
     */

    private static int[] targetSum(int[] nums, int target) {
        int l = 0; // left pointer, starts at beginning of elements
        int r = nums.length - 1; // right pointer, starts at end of elements

         /*
            loop to find the indecies of the elements that result in the target sum

            conditon (l < r)
            prevents pointers from crossing over each other 

            l -> = bigger sum
            since the elements are sorted in non-acsending order, the smaller elements are
                on the left and the bigger element are on the right
            moving the left pointer right adds increasingly bigger elements to the sum resulting in
                a bigger sum

            r -> left = smaller sum
            since the elements are sorted in non-acsending order, the smaller elements are
                on the left and the bigger element are on the right
            moving the left pointer right adds increasingly smaller elements to the sum resulting in
                a smaller sum
        */
        while(l < r) {
            int sum = nums[l] + nums[r]; // calculates sum of current elements
            if(sum == target) return new int[] {l + 1, r + 1}; // found target sum, return indecies 
            else if(sum < target) l++; // sum too small, move pointer left to make sum bigger
            else r--; // sum too big, move pointer right to make sum smaller
        } // while

        return new int[0];  // tagert not found
    } // targetSum

    public static void main(String[] args) {
        int[] nums = {0, 3, 4, 9, 12, 25};
        int target = 21;

        System.out.println(Arrays.toString(TargetSum.targetSum(nums, target)));

    } // main
} // TargetSum
