//https://leetcode.com/problems/maximum-width-of-binary-tree/submissions/
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

    int maxWidth;
    HashMap<Integer,Integer> map;
    
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        map = new HashMap();
        dfs(root,0,0);
        return maxWidth;
    }
    
    private void dfs(TreeNode node,int pos,int level){
        if(node == null) return;
        
        if(!map.containsKey(level)){
            map.put(level, pos);
            
        }
        maxWidth = Math.max(maxWidth, pos - map.get(level) +1);
        dfs(node.left, pos*2, level + 1);
        dfs(node.right, pos*2+1, level + 1);
        
    }
}