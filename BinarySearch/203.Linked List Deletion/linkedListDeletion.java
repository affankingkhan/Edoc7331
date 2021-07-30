// https://binarysearch.com/problems/Linked-List-Deletion
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node, int target) {
        LLNode dummy = new LLNode();
        dummy.next = node;
        LLNode prev = dummy;

        while (node != null) {
            if (node.val == target) {
                prev.next = node.next;
                node = node.next;

            } else {
                prev = node;
                node = node.next;
            }
        }

        return dummy.next;
    }
}