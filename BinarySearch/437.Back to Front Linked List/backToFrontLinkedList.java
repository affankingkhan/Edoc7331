// https://binarysearch.com/problems/Back-to-Front-Linked-List
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

        LLNode slow = node;
        LLNode fast = node.next;
        if (fast == null)
            return node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LLNode right = reverseLL(null, slow.next);
        slow.next = null;

        LLNode left = node;

        LLNode dummy = new LLNode();
        dummy.next = right;

        recurse(right, left);
        return dummy.next;
    }

    private void recurse(LLNode curr, LLNode next) {
        if (curr == null || next == null)
            return;

        LLNode temp = curr.next;
        curr.next = next;

        recurse(next, temp);
    }

    private LLNode reverseLL(LLNode prev, LLNode node) {
        if (node == null)
            return prev;

        LLNode next = node.next;
        node.next = prev;
        return reverseLL(node, next);
    }
}