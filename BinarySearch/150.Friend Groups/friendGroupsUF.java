// https://binarysearch.com/problems/Friend-Groups
import java.util.*;

class Solution {
    public int solve(int[][] friends) {
        int n = friends.length;
        if (n == 0)
            return 0;
        int[] parent = new int[n];
        int[] rank = new int[n];
        Arrays.fill(rank, 1);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j : friends[i]) {
                union(i, j, parent, rank);
            }
        }

        // find the number of unique candidates

        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int curr = find(i, parent);
            seen.add(curr);
        }
        return seen.size();
    }

    private int find(int i, int[] parent) {
        int j = i;
        int p = parent[j];
        while (p != j) {
            j = parent[p];
            p = parent[j];
        }

        return p;
    }

    private void union(int i, int j, int[] parent, int[] rank) {
        int candidateI = find(i, parent);
        int candidateJ = find(j, parent);

        if (candidateI != candidateJ) {
            if (rank[i] >= rank[j]) {
                parent[candidateJ] = candidateI;
                rank[candidateI] += rank[candidateJ];
            } else {
                parent[candidateI] = candidateJ;
                rank[candidateJ] += rank[candidateI];
            }
        }
    }
}