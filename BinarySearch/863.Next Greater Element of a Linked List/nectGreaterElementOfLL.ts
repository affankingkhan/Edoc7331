//https://binarysearch.com/problems/Next-Greater-Element-of-a-Linked-List
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
    solve(node: LLNode): LLNode {

        // stack to store the nodes that haven't found their new values
        const stack = [];

        let curr = node;
        // loop through all the elements

        while (curr != null) {
            /** if node at top of stack has a value less than the current,
             * pop off the stack and set the value of the popped to the curr val
            */
            while (stack.length > 0 && stack[stack.length - 1].val < curr.val) {
                stack[stack.length - 1].val = curr.val;
                stack.pop();
            }
            // add current node to stack and increment curr
            stack.push(curr);
            curr = curr.next;
        }

        // all the ones that are still on the stack should get a value of 0
        while (stack.length > 0) {
            let curr = stack[stack.length - 1];
            curr.val = 0;
            stack.pop();
        }


        return node;

    }
}