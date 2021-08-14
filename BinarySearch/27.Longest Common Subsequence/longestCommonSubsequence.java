// https://binarysearch.com/problems/Longest-Common-Subsequence
import java.util.*;

class Solution {
    public int solve(String a, String b) {
        int m = a.length();
        int n = b.length();

        if (m == 0 || n == 0)
            return 0;

        int[][] mat = new int[m + 1][n + 1];

        char[] aCh = a.toCharArray();
        char[] bCh = b.toCharArray();

        for (int i = 1; i <= m; i++) {
            char x = aCh[i - 1];
            for (int j = 1; j <= n; j++) {
                char y = bCh[j - 1];
                int notAdd = Math.max(mat[i][j - 1], mat[i - 1][j]);
                if (x == y) {
                    mat[i][j] = Math.max(notAdd, mat[i - 1][j - 1] + 1);

                } else {
                    mat[i][j] = notAdd;
                }
            }
        }

        return mat[m][n];
    }
}