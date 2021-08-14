// https://binarysearch.com/problems/Swap-Kth-Node-Values
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node, int k) {
        LLNode ahead = node;
        while (k > 0 && ahead != null) {
            ahead = ahead.next;
            k--;
        }
        LLNode left = ahead;

        LLNode behind = node;

        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }

        int temp = left.val;
        left.val = behind.val;
        behind.val = temp;
        return node;
    }
}