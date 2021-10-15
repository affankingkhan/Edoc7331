// https://binarysearch.com/problems/Linked-List-Jumps
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node) {
        LLNode curr = node;

        while (curr != null) {
            LLNode temp = curr;
            int val = curr.val;
            while (val > 0 && temp != null) {
                val--;
                temp = temp.next;
            }

            curr.next = temp;
            curr = curr.next;
        }

        return node;
    }
}