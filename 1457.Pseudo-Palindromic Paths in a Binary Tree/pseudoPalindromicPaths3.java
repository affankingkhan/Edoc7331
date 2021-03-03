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
    int count = 0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, new int[10]);
        return count;
    }
        
    private void dfs(TreeNode node, int[] freq) {
        if(node == null) return;
        
        freq[node.val]++;
        
        if(node.left == null && node.right == null){
            int oddCount = 0;
            for(int n : freq){
                if(n%2 == 1){
                    oddCount++;
                    if(oddCount > 1){
                        return;
                    }
                }
            }
            count++;
        }
        if(node.left != null){
            dfs(node.left,freq);
            freq[node.left.val]--;
        }
        if(node.right != null){
            dfs(node.right,freq);
            freq[node.right.val]--;
        }
    }
}