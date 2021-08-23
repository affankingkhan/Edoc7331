// https://binarysearch.com/problems/Palindrome-Linked-List
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public boolean solve(LLNode node) {
        LLNode slow = node;
        LLNode fast = node;
        LLNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }

        LLNode l1 = node;
        LLNode l2 = reverseLL(null, slow);

        while (l1 != null && l2 != null) {
            if (l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }

    private LLNode reverseLL(LLNode prev, LLNode curr) {
        if (curr == null)
            return prev;

        LLNode next = curr.next;
        curr.next = prev;
        return reverseLL(curr, next);
    }
}