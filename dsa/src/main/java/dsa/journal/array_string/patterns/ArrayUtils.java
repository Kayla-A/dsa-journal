package dsa.journal.array_string.patterns;

import java.util.Arrays;

public class ArrayUtils {
    
    // null returns empty array
    public static int[] mergeSorted(int[] a, int[] b) {
        if(a == null && b == null) return new int[]{};

        int res[];

        if(a != null && b == null) {
            res = new int[a.length];
            for(int i = 0; i < a.length; i++) {
                res[i] = a[i];
            } // for

            return res;
        } else if(a == null && b != null) {
            res = new int[b.length];
            for(int i = 0; i < b.length; i++) {
                res[i] = b[i];
            } // for
            
            return res;
        } // if

        res = new int[a.length + b.length];

        int pa = 0, pb = 0, i = 0;
        while(i < res.length) {
            if(pa < a.length && pb >= b.length) {
                res[i] = a[pa];
                pa++;
                i+=1;
            } else if(pa < a.length && a[pa] <= b[pb]) {
                res[i] = a[pa];
                pa++;
                i+=1;
            } // if

            if(pb < b.length && pa >= a.length) {
                res[i] = b[pb];
                pb++;
                i+=1;
            } else if(pb < b.length && b[pb] < a[pa]) {
                res[i] = b[pb];
                pb++;
                i+=1;
            } // if

        } // while

        return res;
    } // mergeSorted

} // ArrayUtils
