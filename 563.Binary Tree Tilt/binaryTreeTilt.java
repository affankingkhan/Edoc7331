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
    int ret;
    public int findTilt(TreeNode root) {
        ret = 0;
        dfs(root);
        return ret;
        
    }
    
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        ret += Math.abs(leftSum - rightSum);
        
        
        return root.val + leftSum + rightSum;
    }
}