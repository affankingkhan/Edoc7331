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
//USING IN ORDER TRAVERSAL

class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list,k);
        return(list.get(k-1));
    }
    
    private void traverse(TreeNode node, List<Integer> list,int k){
        if(node == null){
            return;
        }
        
        if(list.size() == k){
            return;
        }
        
        if(node.left != null){
            traverse(node.left, list, k);
        }
        
        if(list.size() == k){
            return;
        }

        
        list.add(node.val);
        
        if(list.size() == k){
            return;
        }
        
        if(node.right != null){
            traverse(node.right, list, k);
        }
        
    }
}