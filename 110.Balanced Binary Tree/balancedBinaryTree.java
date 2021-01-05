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
    boolean ret;
    public boolean isBalanced(TreeNode root) {
        ret= true;
        dfs(root);
        return ret;
    }
    
    private int  dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        
        int heightLeft = dfs(root.left);
        int heightRight = dfs(root.right);
        if(Math.abs(heightLeft - heightRight) > 1){
            ret = false;
        }
        
        return Math.max(heightLeft, heightRight) + 1;
    }
}