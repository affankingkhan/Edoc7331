//https://leetcode.com/problems/reverse-linked-list-ii/
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode curr = head;
        
        // make curr == left
        for(int i = 1; i<left; i++){
            prev = curr;
            curr = curr.next;
        }
        
        // store curr and prev in a variable as we will need them later
        ListNode leftPrev = prev;
        ListNode leftCurr = curr;
        
        prev = curr;
        curr = curr.next;
        
        int len = right - left;
        
        // reverse the linked list until prev becomes right
        while(len > 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            len--;
        }
        
        //set the pointers
        leftPrev.next = prev;
        leftCurr.next = curr;
        
        // if we were reversing including the head, prev would become the head
        if(left == 1) return prev;
        //otherwise head doesn't change
        return head;
    }
}