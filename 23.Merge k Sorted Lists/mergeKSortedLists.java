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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode n : lists){
            if(n != null){
                minHeap.add(n);
            }
        }
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(minHeap.peek() != null){
            curr.next = minHeap.poll();
            curr = curr.next;
            if(curr.next != null){
                minHeap.add(curr.next);
            }
        }
        // curr.next = null;
        
        
        return dummy.next;
        
        
    }
}