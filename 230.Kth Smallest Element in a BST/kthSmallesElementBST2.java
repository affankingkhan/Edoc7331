/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// USING HEAP

class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a );
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return maxHeap.poll();
    }
    
    private void traverse(TreeNode node, int k){
        if(node == null) return;
        
        maxHeap.offer(node.val);
        
        if(maxHeap.size() > k){
            maxHeap.poll();
        }
        
        traverse(node.left,k);
        traverse(node.right,k);
    }
}