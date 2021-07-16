// https://binarysearch.com/problems/Matrix-Nearest-Zero
import java.util.*;

class Solution {
    int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        ArrayDeque<int[]> q1 = new ArrayDeque<>();
        ArrayDeque<int[]> q2 = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q1.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int prev = 0;

        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q2.isEmpty()) {
                bfs(matrix, q1, q2, prev, m, n);

            } else {
                bfs(matrix, q2, q1, prev, m, n);
            }

            prev++;
        }

        return matrix;
    }

    private void bfs(
        int[][] matrix, ArrayDeque<int[]> q1, ArrayDeque<int[]> q2, int prev, int m, int n) {
        while (!q1.isEmpty()) {
            int[] curr = q1.poll();
            int i = curr[0];
            int j = curr[1];

            for (int[] move : moves) {
                int newI = i + move[0];
                int newJ = j + move[1];
                if (newI < 0 || newJ < 0 || newI >= m || newJ >= n || matrix[newI][newJ] == 0)
                    continue;
                if (matrix[newI][newJ] > prev + 1 || matrix[newI][newJ] == -1) {
                    matrix[newI][newJ] = prev + 1;
                    q2.offer(new int[] {newI, newJ});
                }
            }
        }
    }
}