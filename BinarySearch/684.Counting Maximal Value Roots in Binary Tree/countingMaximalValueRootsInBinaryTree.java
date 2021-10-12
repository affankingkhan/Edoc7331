// https://binarysearch.com/problems/Counting-Maximal-Value-Roots-in-Binary-Tree
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int count;
    public int solve(Tree root) {
        count = 0;
        dfs(root);
        return count;
    }

    private int dfs(Tree node) {
        if (node == null)
            return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int max = Math.max(left, right);
        if (node.val >= max)
            count++;
        return Math.max(node.val, max);
    }
}