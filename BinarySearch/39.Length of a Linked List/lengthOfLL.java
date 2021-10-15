// https://binarysearch.com/problems/Length-of-a-Linked-List
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public int solve(LLNode node) {
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}