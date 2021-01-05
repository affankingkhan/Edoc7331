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
    public int minDepth(TreeNode root) {
        return dfs(root);
    }
    
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int countLeft = dfs(root.left);
        
        int countRight = dfs(root.right);
        if(countLeft == 0 && countRight == 0){
            return 1;
        }
        else if (countLeft == 0 || countRight == 0){
            return 1 + Math.max(countLeft,countRight);
        }
        
        return 1 + Math.min(countLeft,countRight);
        
    }
}