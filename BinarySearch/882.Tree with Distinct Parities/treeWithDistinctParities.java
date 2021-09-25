// https://binarysearch.com/problems/Tree-with-Distinct-Parities
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
        if (node.left != null && node.right != null) {
            boolean hasOdd = false;
            boolean hasEven = false;
            if (left % 2 == 0 || right % 2 == 0) {
                hasEven = true;
            }
            if (left % 2 == 1 || right % 2 == 1) {
                hasOdd = true;
            }
            if (hasEven && hasOdd)
                count++;
        }
        return left + right + node.val;
    }
}