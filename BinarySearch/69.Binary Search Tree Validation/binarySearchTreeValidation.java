// https://binarysearch.com/problems/Binary-Search-Tree-Validation
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
        return validate(root, -1_000_000_000_0L, 1_000_000_000_0L);
    }

    private boolean validate(Tree node, long lower, long upper) {
        if (node == null)
            return true;

        int currVal = node.val;

        if (currVal <= lower || currVal >= upper)
            return false;

        return validate(node.left, lower, (long) currVal)
            && validate(node.right, (long) currVal, upper);
    }
}