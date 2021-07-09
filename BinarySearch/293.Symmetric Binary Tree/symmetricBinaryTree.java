// https://binarysearch.com/problems/Symmetric-Binary-Tree
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public boolean solve(Tree root) {
        if (root == null)
            return true;

        return dfs(root.left, root.right);
    }

    private boolean dfs(Tree leftNode, Tree rightNode) {
        if (leftNode == null && rightNode == null)
            return true;
        if (leftNode == null || rightNode == null)
            return false;
        if (leftNode.val != rightNode.val)
            return false;

        return dfs(leftNode.left, rightNode.right) && dfs(leftNode.right, rightNode.left);
    }
}