// https://binarysearch.com/problems/Crush-Consecutive-Numbers
import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        int n = nums.length;
        if ((n - 1) % (k - 1) != 0)
            return -1;

        int[] suff = new int[n+1];
        for (int i = n - 1; i >= 0; i--) {
            suff[i] = nums[i] + suff[i + 1];
        }

        int[][] dp = new int[n][n];
        for (int sz = k; sz <= n; sz++) {
            for (int l = 0, r = sz - 1; r < n; l++, r++) {
                dp[l][r] = Integer.MAX_VALUE;
                // merge [l, i] into one pile, and the rest as much as possible
                for (int i = l; i < r; i += k - 1) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][i] + dp[i + 1][r]);
                }

                // after doing the above split, the interval [l, r] will be reduced to a size <= k
                // if it's reduced to k, we reduce it again to 1 by adding the final cost
                if ((r - l) % (k - 1) == 0) {
                    dp[l][r] += suff[l] - suff[r + 1];
                }
            }
        }

        return dp[0][n - 1];
    }
}