//https://leetcode.com/problems/linked-list-cycle/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.HashMap;


public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        
        ListNode fast = head.next;
        
        while(slow != null && fast != null && fast.next != null){
            if(slow == fast) return true;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
        
    }
}