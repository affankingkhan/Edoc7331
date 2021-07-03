// https://binarysearch.com/problems/Paint-Bucket
import java.util.*;

class Solution {
    int[][] moves = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public String[][] solve(String[][] matrix, int r, int c, String target) {
        int m = matrix.length;
        int n = matrix[0].length;

        String original = matrix[r][c];
        if (original.equals(target))
            return matrix;

        // recursion stack leads to a TLE so we are using a stack DS
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] {r, c});
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int i = curr[0];
            int j = curr[1];
            matrix[i][j] = target;

            for (int[] move : moves) {
                int newI = i + move[0];
                int newJ = j + move[1];
                if (newI < 0 || newI >= m || newJ < 0 || newJ >= n)
                    continue;
                if (matrix[newI][newJ].equals(original))
                    stack.push(new int[] {newI, newJ});
            }
        }

        return matrix;
    }
}