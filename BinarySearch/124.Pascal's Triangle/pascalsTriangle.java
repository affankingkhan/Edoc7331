// https://binarysearch.com/problems/Pascal's-Triangle
import java.util.*;

class Solution {
    public int[] solve(int n) {
        return pascal(n);
    }

    private int[] pascal(int n) {
        if (n == 0)
            return new int[] {1};
        if (n == 1)
            return new int[] {1, 1};

        int[] prev = pascal(n - 1);

        int[] ret = new int[n + 1];
        ret[0] = 1;
        ret[n] = 1;
        for (int i = 1; i < n; i++) {
            ret[i] = prev[i] + prev[i - 1];
        }
        return ret;
    }
}