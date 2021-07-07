// https://binarysearch.com/problems/Wildfire
import java.util.*;

class Solution {
    int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int solve(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;

        ArrayDeque<int[]> q1 = new ArrayDeque<>();
        ArrayDeque<int[]> q2 = new ArrayDeque<>();

        int fireCount = 0;
        int treeCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 2) {
                    q1.offer(new int[] {i, j});
                    fireCount++;

                } else if (matrix[i][j] == 1) {
                    treeCount++;
                }
            }
        }
        if (fireCount == 0 && treeCount > 0)
            return -1;

        int count = 0;

        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q2.isEmpty()) {
                while (!q1.isEmpty()) {
                    int[] curr = q1.poll();
                    populate(matrix, curr, q2, m, n);
                }
                // if other queue was populated with trees on fire, that means we took an extra
                // day to put trees on fire
                if (q2.size() > 0) {
                    fireCount += q2.size();
                    treeCount -= q2.size();
                    count++;
                }

            } else {
                while (!q2.isEmpty()) {
                    int[] curr = q2.poll();
                    populate(matrix, curr, q1, m, n);
                }
                if (q1.size() > 0) {
                    fireCount += q1.size();
                    treeCount -= q1.size();
                    count++;
                }
            }
        }

        return treeCount == 0 ? count : -1;
    }

    private void populate(int[][] matrix, int[] curr, ArrayDeque<int[]> q, int m, int n) {
        int i = curr[0];
        int j = curr[1];

        for (int[] move : moves) {
            int newI = i + move[0];
            int newJ = j + move[1];
            if (newI < 0 || newI >= m || newJ < 0 || newJ >= n)
                continue;
            if (matrix[newI][newJ] == 0 || matrix[newI][newJ] == 2)
                continue;
            // set the tree to aflame
            matrix[newI][newJ] = 2;
            // add the tree on fire to the queue
            q.offer(new int[] {newI, newJ});
        }
        return;
    }
}