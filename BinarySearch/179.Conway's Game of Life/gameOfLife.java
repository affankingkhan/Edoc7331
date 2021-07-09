// https://binarysearch.com/problems/Conway's-Game-of-Life
import java.util.*;

class Solution {
    int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public int[][] solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = matrix[i][j];
                int liveCount = 0;
                for (int[] move : moves) {
                    int newI = i + move[0];
                    int newJ = j + move[1];
                    if (newI < 0 || newI >= m || newJ < 0 || newJ >= n)
                        continue;
                    if (matrix[newI][newJ] == 1 || matrix[newI][newJ] == -1)
                        liveCount++;
                }
                if (curr == 1 && (liveCount == 2 || liveCount == 3)) {
                    matrix[i][j] = 1;
                } else if (curr == 0 && liveCount == 3) {
                    matrix[i][j] = 2;
                } else {
                    if (curr == 1)
                        matrix[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 2) {
                    matrix[i][j] = 1;
                }
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }
}