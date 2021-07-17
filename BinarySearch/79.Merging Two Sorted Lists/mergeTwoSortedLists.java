// https://binarysearch.com/problems/Merging-Two-Sorted-Lists
import java.util.*;

class Solution {
    public int[] solve(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        if (m == 0) {
            return b;
        }
        if (n == 0) {
            return a;
        }

        int[] ret = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (j < m && k < n) {
            if (a[j] <= b[k]) {
                ret[i++] = a[j++];
            } else {
                ret[i++] = b[k++];
            }
        }

        while (j < m) {
            ret[i++] = a[j++];
        }

        while (k < n) {
            ret[i++] = b[k++];
        }

        return ret;
    }
} 