package dsa.journal.hashmap_hashset.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Pattern
        count first
        then index by count so you can read results from highest to lowest without a comparison sort

    Time Complexity
        O(n)

    Space Complexity
        O(n) 

    Triggers
        top k
        most frequent
        k most common
        where the thing you rank is a count

    Invariant
        buckets[c] holds exactly the values that appear c times, and counts are bounded by n
*/
public class FrequencyCountBucketSort {
    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>(); // map to count frequency

        for(int n : nums) freq.merge(n, 1, Integer::sum); // update frequency map

        List<Integer>[] buckets = new List[nums.length + 1]; // array to sort by frequency (increasing)

        // add elements to buckets based on frequency
        for(Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int count = e.getValue();
            if(buckets[count] == null) buckets[count] = new ArrayList<>();
            buckets[count].add(e.getKey());
        } // for

        int[] result = new int[k]; // top k elements
        int idx = 0; 

        // get/add top k elements to result
        for(int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if(buckets[i] == null) continue;

            for(int val : buckets[i]) {
                if(idx < k) result[idx++] = val;
            } // for
        } // for    

        return result;
    } // groupAnagrams

    public static void main(String[] args) {
        int[] nums = {1, 1, 5, 10, 3, 40, 5, 40, 3, 40, 40, 1, 2, -1};
        int k = 4;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    } // main
} // FrequencyCountBucketSort
