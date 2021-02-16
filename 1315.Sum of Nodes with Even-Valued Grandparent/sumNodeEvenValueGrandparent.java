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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root,null);
        return sum;
    }
    
    private void dfs(TreeNode node, TreeNode p){
        if(node == null){
            return;
        }
        
        dfs(node.left, node);
        if(p != null && p.val % 2 == 0){
            sum += node.left != null ? node.left.val : 0;
            sum += node.right != null ? node.right.val : 0;
        }
        dfs(node.right, node);
        
        
    }
}