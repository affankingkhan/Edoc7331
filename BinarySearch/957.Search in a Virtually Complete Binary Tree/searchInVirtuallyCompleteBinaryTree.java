// https://binarysearch.com/problems/Search-in-a-Virtually-Complete-Binary-Tree
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public boolean solve(Tree root, int target) {
        if (target < 1)
            return false;

        List<Integer> nodes = new ArrayList<>();

        int k = target;
        while (k > 1) {
            nodes.add(k);
            k /= 2;
        }

        int i = nodes.size() - 1;

        Tree node = root;

        while (node != null) {
            if (node.val == target)
                return true;
            if (node.left != null && node.left.val == nodes.get(i)) {
                node = node.left;
            } else if (node.right != null && node.right.val == nodes.get(i)) {
                node = node.right;
            } else {
                return false;
            }
            i--;
        }

        return false;
    }
}