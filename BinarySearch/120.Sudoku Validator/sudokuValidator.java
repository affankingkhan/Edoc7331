// https://binarysearch.com/problems/Sudoku-Validator
import java.util.*;

class Solution {
    public boolean solve(int[][] matrix) {
        int n = matrix.length;

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 9 || matrix[i][j] < 1)
                    return false;
                String box = (i / 3) + "-" + (j / 3);
                if (!set.add(matrix[i][j] + " row " + i) || !set.add(matrix[i][j] + " col " + j)
                    || !set.add(matrix[i][j] + " box " + box)) {
                    return false;
                }
            }
        }
        return true;
    }
}