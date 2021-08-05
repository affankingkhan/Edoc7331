// https://binarysearch.com/problems/Vertical-Lines-in-Binary-Tree
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int min;
    int max;
    public int solve(Tree root) {
        if (root == null)
            return 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(root, 0);
        return Math.abs(min) + max + 1;
    }

    private void dfs(Tree node, int num) {
        if (node == null)
            return;

        min = Math.min(min, num);
        max = Math.max(max, num);

        dfs(node.left, num - 1);
        dfs(node.right, num + 1);
    }
}