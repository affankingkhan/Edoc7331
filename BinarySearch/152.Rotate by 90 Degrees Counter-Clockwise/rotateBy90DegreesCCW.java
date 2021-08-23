// https://binarysearch.com/problems/Rotate-by-90-Degrees-Counter-Clockwise
import java.util.*;

class Solution {
    public int[][] solve(int[][] matrix) {
        int m = matrix.length;

        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int j = 0; j < m; j++) {
            int i = 0;
            int k = m - 1;
            while (i < k) {
                swap(matrix, i, j, k, j);
                i++;
                k--;
            }
        }
        return matrix;
    }

    private void swap(int[][] matrix, int i, int j, int x, int y) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
}