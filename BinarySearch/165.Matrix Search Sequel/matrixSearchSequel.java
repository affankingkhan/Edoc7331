// https://binarysearch.com/problems/Matrix-Search-Sequel
import java.util.*;

class Solution {
    public boolean solve(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0) {
            if (matrix[i][j] == target)
                return true;

            if (target < matrix[i][j])
                j--;
            else if (target > matrix[i][j])
                i++;
        }

        return false;
    }
}