// https://binarysearch.com/problems/Sort-a-Linked-List
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node) {
        return mergeSort(node);
    }

    private LLNode mergeSort(LLNode start) {
        if (start == null || start.next == null)
            return start;

        LLNode temp = start;
        LLNode slow = start;
        LLNode fast = start;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;

        LLNode left = mergeSort(start);
        LLNode right = mergeSort(slow);

        return join(left, right);
    }

    private LLNode join(LLNode p, LLNode q) {
        LLNode dummy = new LLNode();

        LLNode curr = dummy;

        while (p != null && q != null) {
            if (p.val <= q.val) {
                curr.next = p;
                p = p.next;

            } else {
                curr.next = q;
                q = q.next;
            }
            curr = curr.next;
        }

        if (p != null) {
            curr.next = p;
        }

        if (q != null) {
            curr.next = q;
        }

        return dummy.next;
    }
}