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
    HashMap<Integer,Integer> map;
    int max = 1;
    public int deepestLeavesSum(TreeNode root) {
        map = new HashMap<>();
        dfs(root, 1);
        return map.get(max);
        
    }
    
    private void dfs(TreeNode node, int level){
        if(node == null){
            return;
        }
        dfs(node.left, level+1);
        map.put(level, map.getOrDefault(level,0) + node.val);
        max = Math.max(max, level);
        dfs(node.right,level+1);
    }
}