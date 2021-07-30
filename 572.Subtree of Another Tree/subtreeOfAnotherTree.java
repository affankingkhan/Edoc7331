// https://leetcode.com/problems/subtree-of-another-tree/
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        return dfsOuter(s,t);
        
    }
    
    private boolean dfsOuter(TreeNode node, TreeNode sub){
        if(node == null) return false;
        
        boolean isEqual = false;
        
        if(node.val == sub.val){
            isEqual = dfsInner(node, sub);
        }
        
        if(isEqual) return true;
        
        return dfsOuter(node.left, sub) || dfsOuter(node.right,sub);
        
    }
    
    private boolean dfsInner(TreeNode node, TreeNode sub){
        if(node == null && sub == null) return true;
        if(node == null || sub == null) return false;
        
        if(node.val != sub.val) return false;
        
        return dfsInner(node.left, sub.left) && dfsInner(node.right, sub.right);
    }
}