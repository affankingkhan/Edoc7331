/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    TreeNode ret, targ;
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.targ = target;
        dfs(original,cloned);
        return ret;
    }
    
    private void dfs(TreeNode original, TreeNode cloned){
        if(original == null){
            return;
        }
        dfs(original.left, cloned.left);
        
        if(original == targ){
            ret = cloned;
            return;
        }
        dfs(original.right,cloned.right);
        
    }
    
    
}