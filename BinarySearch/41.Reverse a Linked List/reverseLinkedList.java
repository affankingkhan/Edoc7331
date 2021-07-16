// https://binarysearch.com/problems/Reverse-a-Linked-List
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node) {
        return reverse(node, null);
    }

    private LLNode reverse(LLNode node, LLNode prev) {
        if (node == null)
            return prev;

        LLNode next = node.next;
        node.next = prev;
        return reverse(next, node);
    }
}