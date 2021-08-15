// https://binarysearch.com/problems/Merging-Binary-Trees
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public Tree solve(Tree node0, Tree node1) {
        if (node0 == null)
            return node1;
        if (node1 == null)
            return node0;

        dfs(node0, node1, null, false);
        return node0;
    }

    private void dfs(Tree node0, Tree node1, Tree parent0, boolean isLeft) {
        if (node0 == null && node1 == null)
            return;

        if (node0 == null) {
            if (isLeft) {
                parent0.left = node1;
            } else {
                parent0.right = node1;
            }
            return;
        }
        if (node1 == null)
            return;

        node0.val += node1.val;

        dfs(node0.left, node1.left, node0, true);
        dfs(node0.right, node1.right, node0, false);
    }
}