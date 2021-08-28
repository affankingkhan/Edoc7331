// https://binarysearch.com/problems/Collecting-Coins
import java.util.*;

class Solution {
    public int solve(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                int top = 0;
                if (i >= 1) {
                    top = dp[i - 1][j];
                }

                int left = 0;
                if (j >= 1) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = val + Math.max(top, left);
            }
        }

        return dp[m - 1][n - 1];
    }
}