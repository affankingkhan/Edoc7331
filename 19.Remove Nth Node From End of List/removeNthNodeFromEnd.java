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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ahead = head;
        int count = 0;
        for(int i = 0; i<n; i++){
            count++;
            ahead = ahead.next;
        }
        if (ahead == null){
            if(n == count){
                head = head.next;
                return head;
            }
        }
        
        ListNode behind = head;
        while(ahead.next != null){
            behind = behind.next;
            ahead = ahead.next;
        }
        behind.next = behind.next.next;
        return head;
    }
}