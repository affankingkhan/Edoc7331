//https://binarysearch.com/problems/Edges-that-Disconnect-the-Graph
import java.util.*;

class Solution {
    public int solve(int[][] graph) {
        int n = graph.length;
        // done[i][j] = 0 if we haven't tried to find a path from i to j
        int[][] done = new int[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] neighbors = graph[i];
            for (int j : neighbors) {
                // check if we have already tried to find a path from j to i which is the same 
                // as i to j
                if (done[j][i] == 1) {
                    done[i][j] = 1;
                    continue;
                }

                // remove this edge and find a path from i to j
                if (i != j && !pathExists(graph, i, j)) {
                    count++;
                }

                done[i][j] = 1;
            }
        }
        return count;
    }

    private boolean pathExists(int[][] graph, int i, int j) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(i);
        for (int n : graph[i]) {
            if (n != j)
                q.offer(n);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == j)
                return true;
            visited.add(curr);

            for (int next : graph[curr]) {
                if (!visited.contains(next))
                    q.offer(next);
            }
        }

        return false;
    }
}