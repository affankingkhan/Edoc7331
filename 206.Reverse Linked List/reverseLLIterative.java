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
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode ahead = head.next;
        head.next = null;
        while(ahead != null){
            if(ahead.next != null){
                ListNode temp = ahead.next;
                ahead.next = head;
                head = ahead;
                ahead = temp;
            }else{
                ahead.next = head;
                break;
            }
            
        }
        return ahead;
    }
}