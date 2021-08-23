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
    public int[] solve(Tree root) {
        List<Integer> list = new ArrayList<>();

        ArrayDeque<Tree> stack = new ArrayDeque<>();

        Tree curr = root;

        while (curr != null || !stack.isEmpty()) {
            // go as far left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // pop off the stack to get the left most element
            curr = stack.pop();
            // addd the element to the list
            list.add(curr.val);
            // go right
            curr = curr.right;
        }

        // convert list to array
        int n = list.size();

        int[] ret = new int[n];

        for (int i = 0; i < n; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}