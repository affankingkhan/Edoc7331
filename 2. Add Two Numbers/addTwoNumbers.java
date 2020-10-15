/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.*;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummy;
        
        while(p != null || q != null){
            int val = carry;
            if(p != null){
                val += p.val;
                p = p.next;
            }
            if(q != null){
                val += q.val;
                q = q.next;
            }
            
            if(val > 9){
                val = val - 10;
                carry = 1;
            }else{
                carry = 0;
            }
            
            // create the node
            
            curr.next = new ListNode(val);
            curr = curr.next;
            
        }
        
        if(carry == 1){
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        return dummy.next;
    }
}