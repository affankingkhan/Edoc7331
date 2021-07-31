// https://binarysearch.com/problems/Transpose-of-a-Matrix
import java.util.*;

class Solution {
    public int[][] solve(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return matrix;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }
}