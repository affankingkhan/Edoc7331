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
        if (node == null || node.next == null)
            return node;
        LLNode cursor = node;
        int n = 1;
        while (cursor.next != null && n < k) {
            cursor = cursor.next;
            n++;
        }
        LLNode tmp = cursor.next;
        cursor.next = null;
        LLNode rev = reverse(null,node);
        LLNode right = solve(tmp, k);
        node.next = right;
        return rev;
    }

    public LLNode reverse(LLNode prev, LLNode curr) {
        if(curr == null) return prev;

        LLNode temp = curr.next;
        curr.next = prev;
        return reverse(curr,temp);
    }
}