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
    int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        preIndex = 0;
        map = new HashMap<>();
        for(int i = 0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return build(preorder,0,inorder.length - 1);
        
        
    }
    
    private TreeNode build(int[] preorder, int start, int end){
        if(start > end){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preIndex++]);
        int inIndex = map.get(node.val);
        
        TreeNode left = build(preorder, start, inIndex -1);
        TreeNode right = build(preorder, inIndex + 1, end);
        
        node.left = left;
        node.right = right;
        
        return node;
        
    }
}