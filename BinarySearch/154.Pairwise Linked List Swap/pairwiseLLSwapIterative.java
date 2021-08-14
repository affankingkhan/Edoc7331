// https://binarysearch.com/problems/Pairwise-Linked-List-Swap
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node) {
        if (node == null)
            return node;

        LLNode prev = new LLNode();
        prev.next = node;

        LLNode dummy = prev;
        LLNode left = node;
        LLNode right = node.next;

        while (left != null && right != null) {
            LLNode next = right.next;

            prev.next = right;
            right.next = left;
            left.next = next;

            prev = left;
            left = left.next;
            if (left != null) {
                right = left.next;
            } else {
                right = null;
            }
        }
        return dummy.next;
    }
}