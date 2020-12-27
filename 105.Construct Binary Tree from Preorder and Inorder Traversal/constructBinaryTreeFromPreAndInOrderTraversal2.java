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
    Map<Integer,Integer> map = new HashMap<>();
    int preIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        for(int i = 0; i <inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return build(preorder,0,preorder.length -1);
    }
    
    private TreeNode build(int[] preorder, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preIndex++]);
        
        int inIndex = map.get(root.val);
        
        TreeNode left = build(preorder,inStart, inIndex - 1);
        TreeNode right = build(preorder,inIndex +1, inEnd);
    
        root.left = left;
        root.right = right;
        
        return root;
        
        
    }
}