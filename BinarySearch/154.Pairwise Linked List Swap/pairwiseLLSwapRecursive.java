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

        LLNode dummy = new LLNode();
        dummy.next = node;

        swap(dummy, node);
        return dummy.next;
    }
    private void swap(LLNode prev, LLNode left) {
        if (left == null || left.next == null)
            return;
        LLNode right = left.next;

        LLNode next = right.next;

        prev.next = right;
        right.next = left;
        left.next = next;

        swap(left, next);
    }
}