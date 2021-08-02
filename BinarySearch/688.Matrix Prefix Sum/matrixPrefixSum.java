// https://binarysearch.com/problems/Matrix-Prefix-Sum
import java.util.*;

class Solution {
    public int[][] solve(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return matrix;
        int n = matrix[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r = i - 1;
                int c = j - 1;
                int left = c >= 0 ? ans[i][c] : 0;
                int top = r >= 0 ? ans[r][j] : 0;
                int back = r >= 0 && c >= 0 ? ans[r][c] : 0;
                ans[i][j] = matrix[i][j] + left + top - back;
            }
        }
        return ans;
    }
}