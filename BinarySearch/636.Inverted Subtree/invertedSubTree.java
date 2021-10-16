// https://binarysearch.com/problems/Inverted-Subtree
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public boolean solve(Tree source, Tree target) {
        return dfs1(target, source);
    }

    private boolean dfs1(Tree node, Tree source) {
        if (node == null)
            return false;

        if (node.val == source.val) {
            if (isInversion(node, source))
                return true;
        }

        return dfs1(node.left, source) || dfs1(node.right, source);
    }

    private boolean isInversion(Tree node, Tree source) {
        if (node == null && source == null)
            return true;
        if (node == null || source == null)
            return false;

        if (node.val != source.val)
            return false;

        boolean res = (isInversion(node.left, source.left) && isInversion(node.right, source.right))
            || (isInversion(node.left, source.right) && isInversion(node.right, source.left));

        return res;
    }
}