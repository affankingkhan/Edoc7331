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

// inOrder      = Left Root Right
// postOrder    = Left Right Root

class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    int postIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i =0; i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        
        postIndex = postorder.length -1;
        return build(postorder,0,inorder.length -1 );
        
        
    }
    
    TreeNode build(int[] postorder, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postIndex--]);
        
        int idx = map.get(root.val);
        
        TreeNode right = build(postorder,idx +1,inEnd);
        TreeNode left = build(postorder,inStart,idx -1);
        root.left = left;
        root.right = right;
        return root;
        
        
        
    }
}