/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = countLLSize(headA);
        int countB = countLLSize(headB);
        
        if(countA > countB){
            int diff = countA - countB;
            for(int i = 0; i<diff; i++){
                headA = headA.next;
            }
        }
        else if(countB > countA){
            int diff = countB - countA;
            for(int i = 0; i<diff; i++){
                headB = headB.next;
            }
        }
        while(headA != null && headB != null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
            
        }
        return null;
        
        
    }
    
    private int countLLSize(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}