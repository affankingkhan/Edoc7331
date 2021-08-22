// https://binarysearch.com/problems/Matrix-Search
import java.util.*;

class Solution {
    public int solve(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > k + 1) {
                    pq.poll();
                }
            }
        }

        return pq.poll();
    }
}