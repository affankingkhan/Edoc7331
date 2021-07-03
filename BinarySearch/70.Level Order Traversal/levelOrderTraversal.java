// https://binarysearch.com/problems/Level-Order-Traversal
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
        ArrayDeque<Tree> q = new ArrayDeque<>();

        q.offer(root);

        List<Integer> store = new ArrayList<>();

        while (!q.isEmpty()) {
            Tree curr = q.poll();
            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
            store.add(curr.val);
        }

        int[] ret = new int[store.size()];

        for (int i = 0; i < store.size(); i++) {
            ret[i] = store.get(i);
        }

        return ret;
    }
}