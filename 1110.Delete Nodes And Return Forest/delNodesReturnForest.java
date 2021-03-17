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
    Set<Integer> set;
    Set<TreeNode> lis;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        for(int i : to_delete){
            set.add(i);
        }
        lis = new HashSet<>();
        lis.add(root);
        dfs(root);
        return new ArrayList<>(lis);
        
        
    }
    
    private boolean dfs(TreeNode node){
        if(node == null){
            return false;
        }
        boolean toDelete = false;
        // if we want to delete the current node
        if(set.contains(node.val)){
            toDelete = true;
            //remove it from the list if it was added before
            lis.remove(node);
            if(node.left != null){
                lis.add(node.left);
            }
            if(node.right != null){
                lis.add(node.right);
            }
        }
        
        if(dfs(node.left)){
            node.left = null;
        }
        if(dfs(node.right)){
            node.right = null;
        }
        
        return toDelete;
        
    }
}