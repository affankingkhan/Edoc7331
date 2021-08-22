// https://binarysearch.com/problems/Linked-List-Intersection
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode l0, LLNode l1) {
        LLNode dummy = new LLNode();

        LLNode curr = dummy;

        while (l0 != null && l1 != null) {
            if (l0.val == l1.val) {
                LLNode temp = l0;
                curr.next = l0;
                curr = curr.next;
                l0 = l0.next;
                l1 = l1.next;
                curr.next = null;
            } else if (l0.val < l1.val) {
                l0 = l0.next;
            } else {
                l1 = l1.next;
            }
        }

        return dummy.next;
    }
}