// https://binarysearch.com/problems/Add-Linked-Lists
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode l0, LLNode l1) {
        if (l0 == null)
            return l1;
        if (l1 == null)
            return l0;

        int carry = 0;
        LLNode prev = new LLNode();
        LLNode dummy = new LLNode();
        dummy.next = prev;

        while (l0 != null || l1 != null) {
            int val = carry;
            if (l0 != null) {
                val += l0.val;
                l0 = l0.next;
            }
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            if (val > 9) {
                val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            LLNode temp = new LLNode();
            temp.val = val;
            temp.next = null;
            prev.next = temp;
            prev = temp;
        }

        if (carry == 1) {
            LLNode t = new LLNode();
            t.val = 1;
            t.next = null;
            prev.next = t;
        }

        return dummy.next.next;
    }
}