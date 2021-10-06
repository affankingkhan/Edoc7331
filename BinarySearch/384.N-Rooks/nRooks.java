// https://binarysearch.com/problems/N-Rooks
import java.util.*;

class Solution {
    public int solve(int n) {
        if (n == 1)
            return 1;
        int fac = 1;

        for (int i = 2; i <= n; i++) {
            fac *= i;
        }
        return fac;
    }
}