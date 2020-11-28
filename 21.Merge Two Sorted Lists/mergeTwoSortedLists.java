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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        
        //make sure primary is l1
        if(l1.val > l2.val){
            ListNode temp = l2;
            l2 = l1;
            l1 = temp;
        }
        ListNode head = l1;
        //l1 is smallest in current returning list, l2 is pointer to other list
        
        while(l1 != null && l2 != null){
            if(l1.next == null){
                l1.next = l2;
                break;
            }
            else if (l1.next.val <= l2.val){
                l1 = l1.next;
            }else{
                ListNode t = l1.next;
                l1.next = l2;
                l2 = t;
            }
        }
        return head;
    }
}