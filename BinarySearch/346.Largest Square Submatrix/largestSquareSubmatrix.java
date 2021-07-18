// https://binarysearch.com/problems/Largest-Square-Submatrix
import java.util.*;

class Solution {
    public int solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int max = 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    int val = determineLargestSquare(matrix, dp, i, j, m, n);
                    dp[i][j] = val;
                    max = Math.max(max, val);
                }
            }
        }

        return max;
    }

    private int determineLargestSquare(int[][] matrix, int[][] dp, int i, int j, int m, int n) {
        int k = i + 1;
        int l = j + 1;
        if (k >= m || l >= n)
            return 1;
        int previousSmaller = dp[k][l];
        if (previousSmaller == 0)
            return 1;

        int dim = (int) Math.sqrt(previousSmaller);

        int a;
        for (a = 0; a <= dim; a++) {
            if (matrix[i][j + a] == 0 || matrix[i + a][j] == 0) {
                break;
            }
        }
        return a * a;
    }
}