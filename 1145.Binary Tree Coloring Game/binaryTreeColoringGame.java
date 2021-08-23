//https://leetcode.com/problems/binary-tree-coloring-game/submissions/
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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        TreeNode first = dfs(root,x);
        
        int left = dfsCount(first.left);
        int right = dfsCount(first.right);
        int parentPath = n - left - right -1;
        
        int totalSum = left + right + parentPath;
        
        int yCount = Math.max(Math.max(left,right),parentPath);
        int xCount = 1 + totalSum - yCount;
        return yCount > xCount;
        
    }
    
    private TreeNode dfs(TreeNode node, int x){
        if(node == null || node.val == x) return node;
        
        TreeNode left = dfs(node.left, x);
        TreeNode right = dfs(node.right, x);
        
        return left == null ? right : left;
        
    }
    
    private int dfsCount(TreeNode node){
        if(node == null) return 0;
        
        return 1 + dfsCount(node.left) + dfsCount(node.right);
        
    }
}