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
class Solution {
    int distance, prev;
    public int getMinimumDifference(TreeNode root) {
        distance = Integer.MAX_VALUE;
        prev = -1;
        dfs(root);
        return distance;
    }
    
    private void dfs(TreeNode node){
        if(node == null) return;
        
        dfs(node.left);
        if(prev != -1){
            distance = Math.min(distance, node.val - prev);
        }
        prev = node.val;
        dfs(node.right);
        
    }
}