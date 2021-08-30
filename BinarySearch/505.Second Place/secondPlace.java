// https://binarysearch.com/problems/Second-Place
import java.util.*;
/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int max;
    int prevMax;
    public int solve(Tree root) {
        max = -1;
        prevMax = -1;
        dfs(root, 0);

        return prevMax;
    }
    private void dfs(Tree node, int depth) {
        if (node == null)
            return;

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);

        if (node.left == null && node.right == null) {
            if (depth == max)
                return;
            else if (depth > max) {
                prevMax = max;
                max = depth;
            } else if (depth > prevMax)
                prevMax = depth;
        }
    }
}