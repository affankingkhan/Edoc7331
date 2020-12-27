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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,0,inorder.length -1);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int preStart, int startIn, int endIn){
        if(startIn > endIn || preStart > preorder.length){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int i;
        for(i = startIn; i<=endIn; i++){
            if(inorder[i] == root.val){
                break;
            }
        }
        
        TreeNode left = build(preorder,inorder,preStart+1,startIn,i-1);
        TreeNode right = build(preorder,inorder,preStart+i-startIn+1, i+1,endIn);
            
        
        root.left = left;
        root.right = right;
        
        return root;
        
        
    }
}