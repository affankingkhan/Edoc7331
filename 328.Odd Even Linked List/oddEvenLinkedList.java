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
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode curr = head.next;
        if(curr == null){
            return head;
        }
        curr = curr.next;
        int count = 3;
        
        ListNode headO = head;
        ListNode tailO = head;
        ListNode headE = head.next;
        ListNode tailE = head.next;
        tailO.next = null;
        tailE.next = null;
        while(curr != null){
            if(count % 2 == 1){
                tailO.next = curr;
                tailO = tailO.next;
                curr = curr.next;
                count++;
                tailO.next = null;
            }else{
                tailE.next = curr;
                tailE = tailE.next;
                curr = curr.next;
                count++;
                tailE.next = null;
            }
        }
        tailO.next = headE;
        return headO;
        
        
        
    }
}