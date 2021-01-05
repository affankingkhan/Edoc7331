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
    List<String> ret;
    public List<String> binaryTreePaths(TreeNode root) {
        ret = new ArrayList<>();
        dfs(root,"");
        return ret;
        
    }
    
    private void dfs(TreeNode root, String curr){
        if(root == null){
            return;
        }
        String dig = Integer.toString(root.val);
        String newCurr = curr + dig;
        if(root.left == null && root.right == null){
            ret.add(newCurr);
        }
        dfs(root.left,newCurr + "->");
        dfs(root.right,newCurr + "->");
        
        
        
    }
}