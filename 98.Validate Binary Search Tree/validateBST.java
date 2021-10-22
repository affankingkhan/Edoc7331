// https://leetcode.com/problems/validate-binary-search-tree/
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
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);

    }
    
    private boolean helper(TreeNode node, Integer lower, Integer upper){
        if(node == null) return true;
        
        int val = node.val;
        
        if(lower != null && val <= lower) return false;
        if(upper != null && val >= upper) return false;

        
        return helper(node.left, lower,val) && helper(node.right, val,upper);
        
    }
}