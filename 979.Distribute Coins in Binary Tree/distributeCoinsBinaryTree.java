/**
    You are given the root of a binary tree with n nodes where each node in the tree has node.val coins and there are n coins total.

In one move, we may choose two adjacent nodes and move one coin from one node to another. (A move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.
*/

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
    int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }
    
    private int dfs(TreeNode node){
        if(node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        moves += Math.abs(left) + Math.abs(right);
        
        return node.val + left + right - 1;
        
        
        
        
    }
}