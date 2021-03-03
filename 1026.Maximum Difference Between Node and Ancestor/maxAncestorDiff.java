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
    public int maxAncestorDiff(TreeNode root) {
        ret = 0;
        dfs(root, root.val,root.val);
        return ret;
        
    }
    
    private void dfs(TreeNode node, int max, int min){
        if(node == null){
            ret = Math.max(ret,max-min);
            return;
        }
        
        if(node.val > max){
            max = node.val;
        }
        else if(node.val < min){
            min = node.val;
        }
        
        dfs(node.left, max,min);
        dfs(node.right, max, min);
    }
}