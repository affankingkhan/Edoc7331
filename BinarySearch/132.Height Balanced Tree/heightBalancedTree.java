// https://binarysearch.com/problems/Height-Balanced-Tree
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    boolean isBalanced;
    public boolean solve(Tree root) {
        isBalanced = true;

        dfs(root);
        return isBalanced;
    }

    private int dfs(Tree node) {
        if (node == null)
            return 0;
        if (!isBalanced)
            return 1;

        int left = dfs(node.left);
        int right = dfs(node.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;

        return Math.max(left, right) + 1;
    }
}