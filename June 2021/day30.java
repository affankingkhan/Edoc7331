//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
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
    
    TreeNode ret;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ret;
        
    }
    
    private int dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return 0;
        
        int count = 0;
        if(node == p || node == q){
            count = 1;
        }
        
        int leftCount = dfs(node.left, p ,q);
        int rightCount = dfs(node.right, p ,q);
        
        if(count + leftCount + rightCount == 2 && ret == null){
            ret = node;
        }
        return count + leftCount + rightCount;
        
        
    }
    

}