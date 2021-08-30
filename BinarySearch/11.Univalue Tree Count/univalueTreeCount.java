// https://binarysearch.com/problems/Univalue-Tree-Count
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
        if (root == null)
            return 0;
        dfs(root, root.val);
        return count;
    }

    private boolean dfs(Tree node, int parent) {
        if (node == null) {
            return true;
        }

        boolean left = dfs(node.left, node.val);
        boolean right = dfs(node.right, node.val);
        if (left && right)
            count++;

        return left && right && node.val == parent;
    }
}