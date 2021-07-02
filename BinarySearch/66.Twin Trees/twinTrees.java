// https://binarysearch.com/problems/Twin-Trees
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public boolean solve(Tree root0, Tree root1) {
        return dfs(root0, root1);
    }

    private boolean dfs(Tree n1, Tree n2) {
        if ((n1 == null && n2 != null) || (n2 == null && n1 != null))
            return false;
        if (n1 == null && n2 == null)
            return true;

        if (n1.val == n2.val) {
            return dfs(n1.left, n2.left) && dfs(n1.right, n2.right);
        }

        return false;
    }
}