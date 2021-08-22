// https://binarysearch.com/problems/Complete-Binary-Tree
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */

class TreeNode {
    Tree tree;
    int pos;

    TreeNode(Tree t, int p) {
        this.tree = t;
        this.pos = p;
    }
}
class Solution {
    public boolean solve(Tree root) {
        if (root == null)
            return true;

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        TreeNode first = new TreeNode(root, 0);
        q.offer(first);

        TreeNode prev = null;
        while (q.size() > 0) {
            int n = q.size();

            while (n > 0) {
                TreeNode curr = q.poll();
                if (prev != null) {
                    if (curr.pos - prev.pos != 1)
                        return false;
                }

                if (curr.tree.left != null)
                    q.offer(new TreeNode(curr.tree.left, 2 * curr.pos + 1));
                if (curr.tree.right != null)
                    q.offer(new TreeNode(curr.tree.right, 2 * curr.pos + 2));
                n--;
                prev = curr;
            }
        }

        return true;
    }
}