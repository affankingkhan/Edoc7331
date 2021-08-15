// https://binarysearch.com/problems/Central-Linked-List
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public int solve(LLNode node) {
        LLNode slow = node;
        LLNode fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            return slow.next.val;
        }

        return slow.val;
    }
}