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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int i = 0;
        int j = nums.length - 1;
        return buildTree(nums, i, j); 
    }
    
    private TreeNode buildTree(int[] nums, int i, int j){
        if(i > j){
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode head = new TreeNode(nums[mid]);
        TreeNode left = buildTree(nums, i, mid - 1);
        TreeNode right = buildTree(nums, mid + 1, j);
        head.left = left;
        head.right = right;
        return head;
        
        
    }
}