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
    TreeNode retNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        retNode = root;
        int ret = dfs(root,p,q,root);
        return retNode;
        
    }
    
    private int dfs(TreeNode curr, TreeNode p, TreeNode q, TreeNode root){
        if(curr == null) return 0;
        if(curr == p || curr == q){
            int ret = 1 + dfs(curr.left,p,q,root) + dfs(curr.right,p,q,root);
            if(ret == 2 && retNode == root){
                retNode = curr;
            }
            return ret;
        }
        
        int ret = 0 + dfs(curr.left,p,q, root) + dfs(curr.right,p,q,root);
        if(ret == 2 && retNode == root){
            retNode = curr;
        }
        return ret;
    }
}