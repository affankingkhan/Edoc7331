// https://binarysearch.com/problems/Insert-Into-Linked-List
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode head, int pos, int val) {
        if (pos == 0) {
            LLNode node = new LLNode();
            node.val = val;
            node.next = head;
            return node;
        }

        LLNode prev = null;
        LLNode ahead = head;

        while (pos > 0) {
            prev = ahead;
            ahead = ahead.next;
            pos--;
        }

        LLNode node = new LLNode();
        node.val = val;

        prev.next = node;
        node.next = ahead;
        return head;
    }
}