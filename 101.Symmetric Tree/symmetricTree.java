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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left,root.right);
    }
    
    private boolean dfs(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        }
        else if (a == null || b == null){
            return false;
        }
        else if (a.val != b.val){
            return false;
        }else{
            return dfs(a.left, b.right) && dfs(a.right,b.left);
        }
    }
    
}