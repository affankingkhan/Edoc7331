// https://binarysearch.com/problems/Make-Lists-Same-with-Sublist-Sum-Operations
import java.util.*;

class Solution {
    public int solve(int[] l0, int[] l1) {
        int i = 0, j = 0, m = l0.length, n = l1.length;
        int ans = 0;

        while (i < m && j < n) {
            if (l0[i] == l1[j]) {
                i++;
                j++;
                ans++;
            } else if (l0[i] < l1[j]) {
                i++;
                if (i == m)
                    break;
                l0[i] += l0[i - 1];
            } else {
                j++;
                if (j == n)
                    break;
                l1[j] += l1[j - 1];
            }
        }
        if (i != m || j != n)
            return -1;
        return ans;
    }
}