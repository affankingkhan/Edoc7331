// https://binarysearch.com/problems/Subtree
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public boolean solve(Tree root, Tree target) {
        return dfs(root, target);
    }

    private boolean dfs(Tree node, Tree target) {
        if (node == null)
            return false;

        if (node.val == target.val) {
            return dfs2(node, target) || (dfs(node.left, target) || dfs(node.right, target));
        }

        return dfs(node.left, target) || dfs(node.right, target);
    }

    private boolean dfs2(Tree node1, Tree node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;

        if (node1.val != node2.val)
            return false;

        return dfs2(node1.left, node2.left) && dfs2(node1.right, node2.right);
    }
}