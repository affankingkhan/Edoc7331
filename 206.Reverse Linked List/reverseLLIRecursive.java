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
class Solution {
    public ListNode reverseList(ListNode head) {
        return recurse(null,head);
    }
    
    private ListNode recurse(ListNode behind, ListNode ahead){
        if(ahead == null){
            return behind;
        }
        ListNode temp = ahead.next;
        ahead.next = behind;
        return recurse(ahead,temp);
    }
        
}