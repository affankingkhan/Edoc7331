// prestocard.ca/en-US/Pages/ContentPages/FaresTravel.aspx#TTC
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */

// preorder ==> root, left, right
// inorder ==> left, root, right
class Solution {
    public Tree solve(int[] preorder, int[] inorder) {
        return recurse(0, 0, inorder.length - 1, preorder, inorder);
    }

    private Tree recurse(int pStart, int iStart, int iEnd, int[] preorder, int[] inorder) {
        if (pStart > preorder.length - 1 || iStart > iEnd)
            return null;
        Tree node = new Tree(preorder[pStart]);

        int inIndex = 0;

        for (int i = iStart; i <= iEnd; i++) {
            if (node.val == inorder[i]) {
                inIndex = i;
                break;
            }
        }

        node.left = recurse(pStart + 1, iStart, inIndex - 1, preorder, inorder);
        node.right = recurse(pStart + inIndex - iStart + 1, inIndex + 1, iEnd, preorder, inorder);
        return node;
    }
}