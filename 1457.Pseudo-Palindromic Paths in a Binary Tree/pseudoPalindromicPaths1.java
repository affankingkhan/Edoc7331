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
    int count;
    public int pseudoPalindromicPaths (TreeNode root) {
        count = 0;
        dfs(root,"");
        return count;
    }
    
    private void dfs(TreeNode node, String str){
        if(node == null){
            return;
        }
        
        String currString = str + Integer.toString(node.val);
        dfs(node.left, currString);
        dfs(node.right, currString);
        if(node.left == null && node.right == null){
            if(isPalindromic(currString)) count++;
        } 
        
    }
    
    private boolean isPalindromic(String str){
        int length = str.length();
        boolean isEven = length % 2 == 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        
        for(char c : arr){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        Set<Character> set = map.keySet();
        int counter = 0;
        for(char s : set){
            if(map.get(s) % 2 == 1) counter++;
            if(counter > 1){
                return false;
            }
        }
        
        return (isEven && counter == 0) || (!isEven && counter == 1);
    }
}