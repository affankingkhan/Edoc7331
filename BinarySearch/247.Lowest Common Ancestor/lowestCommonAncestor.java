// https://binarysearch.com/problems/Lowest-Common-Ancestor
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public int solve(Tree root, int a, int b) {
        return dfs(root, a, b).val;
    }

    private Tree dfs(Tree node, int a, int b) {
        if (node == null || node.val == a || node.val == b)
            return node;

        Tree left = dfs(node.left, a, b);
        Tree right = dfs(node.right, a, b);
        if (left != null && right != null)
            return node;
        if (left != null && right == null)
            return left;
        if (left == null && right != null)
            return right;
        return null;
    }
}