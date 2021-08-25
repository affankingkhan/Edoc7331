// https://binarysearch.com/problems/Sudoku-Solver
import java.util.*;

class Solution {
    List<int[]> list;
    public int[][] solve(int[][] matrix) {
        list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[] {i, j});
                }
            }
        }

        sudoku(matrix, 0);
        return matrix;
    }

    private boolean sudoku(int[][] matrix, int currentEmptyPtr) {
        if (currentEmptyPtr >= list.size())
            return true;

        int[] xy = list.get(currentEmptyPtr);
        int row = xy[0];
        int col = xy[1];

        for (int i = 1; i <= 9; i++) {
            matrix[row][col] = i;
            // validate the row and col
            if (isValid(matrix, row, col) && sudoku(matrix, currentEmptyPtr + 1)) {
                return true;
            } else {
                matrix[row][col] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int[][] mat, int i, int j) {
        // validate col
        int[] map = new int[10];
        for (int k = 0; k < 9; k++) {
            int val = mat[k][j];
            if (val == 0)
                continue;
            if (map[val] > 0)
                return false;
            map[val]++;
        }

        // validate row
        map = new int[10];

        for (int k = 0; k < 9; k++) {
            int val = mat[i][k];
            if (val == 0)
                continue;
            if (map[val] > 0)
                return false;
            map[val]++;
        }

        /// validate square

        HashSet<Integer> set = new HashSet<>();

        int row = 0;
        int col = 0;

        if (i > 6) {
            row = 6;
        } else if (i > 3) {
            row = 3;
        }

        if (j > 6) {
            col = 6;
        } else if (j > 3) {
            col = 3;
        }

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int val = mat[row + x][col + y];
                if (val == 0)
                    continue;
                if (set.contains(val))
                    return false;
                set.add(val);
            }
        }

        return true;
    }
}