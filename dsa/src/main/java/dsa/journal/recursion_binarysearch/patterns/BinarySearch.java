package dsa.journal.recursion_binarysearch.patterns;

public class BinarySearch {
    /*
        Pattern
            keep a range [lo, hi]
            compare the middle element to the target
            discard the half that can’t contain it

        Time Complexity
            O(log n)

        Space Complexity
            O(1)

        Triggers
           sorted
           O(log n)
           find the position
           insertion point
           first/last occurrence 

        Invariant
            if the target is in the array, it is within [lo, hi]
    */
    private static int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        } // while

        return -1;
    } // binarySearch

    private static int firstBadVersion(int n, int bad) {
        int low = 0, high = n;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(mid == bad) high = mid;
            else low = mid + 1;
        } // while

        return high;
    } // firstBadVersion

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 7, 10, 20, 23, 25, 330};

        System.out.println(binarySearch(nums, 7));
    } // main

} // BinarySearch
