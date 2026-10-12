package dsa.journal.array_string;

public class StatusUtils {
    
    public static long min(int[] a) throws IllegalArgumentException {
        if(a == null || a.length == 0) throw new IllegalArgumentException();
        
        long min = Integer.MAX_VALUE;

        for(int i : a) {
            if(min > i) min = i;
        } // for

        return min;
    } // min

    public static long max(int[] a) throws IllegalArgumentException {
        if(a == null || a.length == 0) throw new IllegalArgumentException();

        long max = Integer.MIN_VALUE;

        for(int i : a) {
            if(max < i) max = i;
        } // for

        return max;
    } // max

    public static double average(int[] a) throws IllegalArgumentException {
        if(a == null || a.length == 0) throw new IllegalArgumentException();

        double avg = 0;

        for(int i : a) {
            avg += i;
        } // for

        return avg / a.length;
    } // average

    // [min, max]
    public static long[] minMax(int[] a) throws IllegalArgumentException {
        if(a == null || a.length == 0) throw new IllegalArgumentException();

        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        for(int i : a) {
            if(min > i) min = i;
            if(max < i) max = i;
        } // for

        return new long[]{min, max};
    } // minMax
} // StatusUtils
