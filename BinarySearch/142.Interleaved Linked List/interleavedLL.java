//https://binarysearch.com/problems/Interleaved-Linked-List
import java.util.*;
/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode l0, LLNode l1) {
        if(l0 == null) return l1;

        LLNode curr = l0;
        LLNode other = l1;

        while(other != null){
            LLNode temp = curr.next;
            curr.next = other;
            curr = other;
            other = temp;
        }
        return l0;
    }
}