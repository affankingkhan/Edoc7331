// https://binarysearch.com/problems/Inorder-Traversal
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    List<Integer> list;
    public int[] solve(Tree root) {
        list = new ArrayList<>();
        dfs(root);

        int[] ret = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    private void dfs(Tree node) {
        if (node == null)
            return;

        dfs(node.left);

        list.add(node.val);

        dfs(node.right);
    }
}