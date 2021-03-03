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
    int count;
    public int goodNodes(TreeNode root) {
        count = 0 ;
        dfs(root, root.val);
        return count;
        
    }
    
    private void dfs(TreeNode node, int m){
        if(node == null) return;
        
        if(node.val >= m){
            count++;
        }
        
        int max = Math.max(m, node.val);
        dfs(node.left, max);
        dfs(node.right, max);
    }
}