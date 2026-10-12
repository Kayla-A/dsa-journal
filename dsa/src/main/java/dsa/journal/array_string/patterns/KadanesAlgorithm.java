package dsa.journal.array_string.patterns;

public class KadanesAlgorithm {
     /* 
        Pattern
            single pass with a running state, where the state is the best result ending at the current index
            (form of 1D dynamic programming)

        Time Complexity
            O(n)

        Space Complexity
            O(1)

        Triggers
            contiguous subarray with a max or min sum or product
            decision at each element depending only on the best result ending at the previous one
            brute force is “try every start and end,” which means a nested loop is hiding a carried value

        Invariant
            after index i, cur is the maximum sum of any subarray ending exactly at i, 
            and best is the maximum over all earlier cur values

        Connection
            same family as RunningMin
            both carry a value that sumarizes everything before the current element
            this algorithm has choice built in that helps track best subarray ending

     */
    private static int maxSubarray(int[] nums) {
        int cur = nums[0]; // current sum
        int best = nums[0]; // maximum sum

        /*
            Walk left to right and keep one number, the best sum of a subarray 
            ending at the current element. At each element you choose: extend 
            the previous subarray, or start fresh here. Starting fresh wins when 
            the running sum has gone negative, since a negative prefix only hurts.
         */
        for(int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]); // extend or restart
            best = Math.max(best, cur);
        } // for

        return best;
    } // maxSubarray

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {1};

        System.out.println(maxSubarray(nums));
        System.out.println(maxSubarray(nums2));
    } // main

} // KadanesAlgorithm
