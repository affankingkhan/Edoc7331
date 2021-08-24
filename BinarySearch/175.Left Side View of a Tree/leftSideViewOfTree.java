// https://binarysearch.com/problems/Left-Side-View-of-a-Tree
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int maxLevel;
    List<Integer> list;
    public int[] solve(Tree root) {
        maxLevel = -1;
        list = new ArrayList<>();

        dfs(root, 0);
        int n = list.size();

        int[] ret = new int[n];

        for (int i = 0; i < n; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    private void dfs(Tree node, int level) {
        if (node == null)
            return;

        if (level > maxLevel) {
            list.add(node.val);
            maxLevel = level;
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}