//https://binarysearch.com/problems/Reverse-an-Inner-Linked-List
/**
 * class LLNode {
 *   constructor(val, next=null) {
 *     this.val = val
 *     this.next = next
 *   }
 * }
 */
class Solution {
    solve(node, i, j) {
        if (i == j) return node;
        let dummy = new LLNode(0, node);

        let curr = node;
        let prev = dummy;
        let k = i;
        while (k > 0) {
            curr = curr.next;
            prev = prev.next;
            k--;
        }

        let left = curr;
        let prevLeft = null;

        let n = j - i;

        while (n > 0) {
            let next = left.next;
            left.next = prevLeft;
            prevLeft = left
            left = next;
            n--;

        }

        let right = left.next;
        left.next = prevLeft;

        curr.next = right;
        prev.next = left;
        return dummy.next;

    }
}