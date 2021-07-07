// https://binarysearch.com/problems/Friend-Groups
import java.util.*;

class Solution {
    HashSet<Integer> seen;
    public int solve(int[][] friends) {
        seen = new HashSet<>();
        int n = friends.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!seen.contains(i)) {
                dfs(i, friends);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, int[][] friends) {
        if (seen.contains(i))
            return;

        seen.add(i);

        for (int j : friends[i]) {
            dfs(j, friends);
        }
        return;
    }
}