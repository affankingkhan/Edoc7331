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
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        curr = dummy;
        dfs(root);
        return dummy.right;
        
    }
    
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        //we need to physically set the left pointer to null after
        //dfsing through it
        root.left = null;
        curr.right = root;
        curr = curr.right;
        dfs(root.right);
    }
}