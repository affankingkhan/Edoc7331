//https://binarysearch.com/problems/A-Strictly-Increasing-Linked-List
/**
 * class LLNode {
 *     val: number;
 *     next: LLNode | null;
 * 
 *     constructor(val: number, next: LLNode | null) {
 *         this.val = val
 *         this.next = next
 *     }
 * }
 */
class Solution {
    solve(head: LLNode): boolean {

        let prev = null;

        let curr = head;

        while(curr != null){
            if(!prev || curr.val > prev.val){
                prev = curr;
                curr = curr.next;
            }else{
                return false
            }
        }

        return true;
        
    }
}