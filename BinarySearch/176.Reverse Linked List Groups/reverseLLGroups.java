// https://binarysearch.com/problems/Reverse-Linked-List-Groups
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node, int k) {
        LLNode dummy = new LLNode();

        LLNode prev = dummy;

        ArrayDeque<LLNode> stack = new ArrayDeque<>();

        LLNode curr = node;

        while (curr != null) {
            int i = 0;
            while (i < k && curr != null) {
                stack.push(curr);
                curr = curr.next;
                i++;
            }

            while (!stack.isEmpty()) {
                LLNode p = stack.pop();
                prev.next = p;
                prev = prev.next;
                prev.next = null;
            }
        }

        return dummy.next;
    }
}