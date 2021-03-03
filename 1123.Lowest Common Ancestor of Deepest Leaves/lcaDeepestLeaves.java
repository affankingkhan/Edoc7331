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
    TreeNode ret;
    Map<Integer,Integer> map;
    int max;
    int count;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        ret = null;
        max = 0;
        map = new HashMap<>();
        dfs1(root, 0);
        
        count = 0;
        Set<Integer> keySet = map.keySet();
        for(int key : keySet){
            if(map.get(key) == max) count++;
        }
        
        dfs2(root);
        return ret;
    }
    
    // recursive dfs function that determines 
    private int dfs2(TreeNode node){
        if(node == null) return 0;
        // check if node is max depth
        if(map.get(node.val) == max){
            // if there is only 1 node at max depth, then it is its own LCA
            if(count == 1 && ret == null){
                ret = node;
            }
            return 1;
        }
        
        // count max depth nodes in left sub tree
        int left = dfs2(node.left);
        // count max depth nodes in right sub tree
        int right = dfs2(node.right);
        //update ret if left and right add up to count and ret hasn't been chnaged
        // this is because we are building up soo as soon as it is not null, the LCA is found
        if((left + right == count ) && ret == null){
            ret = node;
        }
        
        return left + right;
        
    }
    
    // recursive function to build the hashmap and find the max depth
    private void dfs1(TreeNode node, int depth){
        if(node == null) return;
        map.put(node.val, depth);
        max = Math.max(max, depth);
        dfs1(node.left, depth + 1);
        dfs1(node.right, depth + 1);
    }
}