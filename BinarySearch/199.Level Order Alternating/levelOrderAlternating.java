// https://binarysearch.com/problems/Level-Order-Alternating
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */

// Two stack approach
class Solution {
    public int[] solve(Tree root) {
        // going left to right
        ArrayDeque<Tree> s1 = new ArrayDeque<>();
        //going right to left
        ArrayDeque<Tree> s2 = new ArrayDeque<>();

        s1.push(root);

        ArrayList<Integer> list = new ArrayList<>();

        while (!s1.isEmpty() || !s2.isEmpty()) {
            /// going left to right
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    Tree curr = s1.pop();
                    list.add(curr.val);
                    if (curr.left != null) {
                        s2.push(curr.left);
                    }
                    if (curr.right != null) {
                        s2.push(curr.right);
                    }
                }

            }
            // going right to left
            else {
                while (!s2.isEmpty()) {
                    Tree curr = s2.pop();
                    list.add(curr.val);
                    if (curr.right != null) {
                        s1.push(curr.right);
                    }
                    if (curr.left != null) {
                        s1.push(curr.left);
                    }
                }
            }
        }

        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}