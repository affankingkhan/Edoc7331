// https://binarysearch.com/problems/Binary-Tree-Width
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    HashMap<Integer, Integer> map;
    int maxWidth;
    public int solve(Tree root) {
        map = new HashMap<>();
        maxWidth = 0;

        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(Tree node, int level, int pos) {
        if (node == null)
            return;

        if (!map.containsKey(level)) {
            map.put(level, pos);
        }

        maxWidth = Math.max(maxWidth, pos - map.get(level) + 1);
        dfs(node.left, level + 1, 2 * pos + 1);
        dfs(node.right, level + 1, 2 * pos + 2);
        return;
    }
}