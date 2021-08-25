// https://binarysearch.com/problems/Tree-Coloring
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int even = 0, odd = 0;
    int cnt = 0;
    int val;
    public boolean solve(Tree root) {
        if (root == null)
            return true;
        val = root.val;
        dfs(root, 0);

        if (cnt == odd || cnt == even)
            return true;
        return false;
    }

    public void dfs(Tree root, int level) {
        if (root == null)
            return;
        if (level % 2 == 0) {
            even++;
        } else {
            odd++;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
        if (root.val == val)
            cnt++;
    }
}