package dsa.journal.array_string.patterns;


public class RunningMin {
    /*
        Pattern:
            single pass with a running min (or max) 
            walk the array once and carry one value that summarizes 
            everything before the current element

        Trigger:
            order constraint between two elements
            need the best earlier value
     */

    private static int maxProfit(int[] arr) {
        int min = Integer.MAX_VALUE; // current minimum value
        int best = 0; // current best value

        /*
            loop to maximize the difference between two values in the array

            condition (for every p in arr)
            checks every element to get the highest difference (profit)

            why only lowest seen so far?
            best sell today is torday's price - cheapest earlier price
            remembering one number replaces a nested loop
         */
        for(int p : arr) {
            if(p < min) min = p; // check for new min price
            else best = Math.max(best, p - min); // update best value
        } // for

        return best;
    } // maxProfit

    public static void main(String[] args) {
        int best = maxProfit(new int[]{100, 9, 11, 350, 20});

        System.out.println(best);
    } // main
} // MaxProfit
