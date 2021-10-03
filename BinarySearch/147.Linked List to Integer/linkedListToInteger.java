// https://binarysearch.com/problems/Linked-List-to-Integer
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public int solve(LLNode node) {
        LLNode curr = reverse(null, node);
        int val = 0;
        int exp = 0;

        while (curr != null) {
            if (curr.val == 1) {
                val += ((int) (Math.pow(2, exp)));
            }
            exp++;
            curr = curr.next;
        }
        return val;
    }

    private LLNode reverse(LLNode prev, LLNode curr) {
        if (curr == null)
            return prev;

        LLNode temp = curr.next;
        curr.next = prev;
        return reverse(curr, temp);
    }
}