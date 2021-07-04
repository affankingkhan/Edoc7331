// https://binarysearch.com/problems/Longest-Tree-Path
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int max;
    public int solve(Tree root) {
        max = 0;
        dfs(root);
        return max;
    }

    private int dfs(Tree curr) {
        if (curr == null)
            return 0;
        int left = dfs(curr.left);
        int right = dfs(curr.right);
        int now = left + right + 1;
        max = Math.max(max, now);
        return Math.max(left, right) + 1;
    }
}