// https://binarysearch.com/problems/Invert-Tree
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public Tree solve(Tree root) {
        invert(root);
        return root;
    }

    private void invert(Tree node) {
        if (node == null)
            return;
        Tree temp = node.left;
        node.left = node.right;
        node.right = temp;
        invert(node.left);
        invert(node.right);
    }
}