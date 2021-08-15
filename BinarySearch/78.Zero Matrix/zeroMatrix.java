// https://binarysearch.com/problems/Zero-Matrix
import java.util.*;

class Solution {
    public int[][] solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (row[i] > 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (col[i] > 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        return matrix;
    }
}