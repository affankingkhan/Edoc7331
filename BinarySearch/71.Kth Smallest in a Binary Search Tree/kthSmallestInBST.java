// https://binarysearch.com/problems/Kth-Smallest-in-a-Binary-Search-Tree
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int curr;
    int ans;
    public int solve(Tree root, int k) {
        curr = 0;
        ans = 0;

        dfs(root, k);
        return ans;
    }

    private void dfs(Tree node, int k) {
        if (node == null)
            return;

        dfs(node.left, k);
        curr++;
        if (curr == k + 1) {
            ans = node.val;
            return;
        }
        dfs(node.right, k);
    }
}