// https://binarysearch.com/problems/Tree-Shifting
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
        ArrayDeque<Tree> q = new ArrayDeque<>();
        if (root != null) {
            q.offer(root);
        }

        while (!q.isEmpty()) {
            int n = q.size();

            ArrayDeque<Tree> children = new ArrayDeque<>();
            ArrayDeque<Tree> parent = new ArrayDeque<>();

            while (n > 0) {
                Tree curr = q.poll();
                Tree right = curr.right;
                Tree left = curr.left;
                if (right != null) {
                    children.offer(right);
                    q.offer(right);
                }
                if (left != null) {
                    children.offer(left);
                    q.offer(left);
                }
                parent.offer(curr);
                n--;
            }

            while (!parent.isEmpty()) {
                Tree curr = parent.poll();
                curr.right = children.isEmpty() ? null : children.poll();
                curr.left = children.isEmpty() ? null : children.poll();
            }
        }

        return root;
    }
}