// https://binarysearch.com/problems/Lexicographically-Largest-Mountain-List
import java.util.*;

class Solution {
    public int[] solve(int n, int lower, int upper) {
        if (2 * (upper - lower) + 1 < n)
            return new int[] {};

        int[] ret = new int[n];

        int lengthOfDecreasing = Math.min(upper - lower, n - 2);
        int lengthOfIncreasing = n - lengthOfDecreasing;

        int start = upper - lengthOfIncreasing + 1;

        for (int i = 0; i < lengthOfIncreasing; i++) {
            ret[i] = start;
            start++;
        }

        start = upper - 1;

        for (int i = n - lengthOfDecreasing; i < n; i++) {
            ret[i] = start;
            start--;
        }

        return ret;
    }
}