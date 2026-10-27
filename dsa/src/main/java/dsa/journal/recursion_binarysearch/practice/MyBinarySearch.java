package dsa.journal.recursion_binarysearch.practice;

public class MyBinarySearch {
    
    // iterative, -1 if not found, returns first index of duplicate
    public static int indexOf(int[] a, int target) {
        int low = 0, high = a.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(a[mid] == target) return mid;
            else if(a[mid] < target) low = mid + 1;
            else high = mid - 1;
        } // while

        return -1;
    } // indexOf

    // recursive, -1 if not found, returns first index of duplicate
    public static int indexOf(int[] a, int target, int low, int high) {
        if(low > high || a.length == 0) return -1;

        int mid = low + (high - low) / 2, res = -1;
        if(a[mid] == target) return mid;
        else if(a[mid] < target) res = indexOf(a, target, mid + 1, high);
        else res = indexOf(a, target, low, mid - 1);

        return res;
    } // indexOf

    public static int insertPosition(int[] a, int target) {
        int low = 0, high = a.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(a[mid] == target) return mid;
            else if(a[mid] < target) low = mid + 1;
            else high = mid - 1;
        } // while

        return low;
    } // insertPosition

} // MyBinarySearch
