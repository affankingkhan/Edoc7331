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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        
        boolean goingRight = true;
        ArrayDeque<TreeNode> s1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> s2 = new ArrayDeque<>();
        s1.push(root);
        
        while(s1.size() != 0 || s2.size() != 0){
            List<Integer> sub = new ArrayList<>();
            if(goingRight){
                while(s1.size() > 0){
                    TreeNode node = s1.pop();
                    sub.add(node.val);
                    if(node.left != null){
                        s2.push(node.left);
                    }
                    if(node.right != null){
                        s2.push(node.right);
                    }
                }
                ret.add(sub);
                goingRight = false;
                
            }else{
                while(s2.size() > 0){
                    TreeNode node = s2.pop();
                    sub.add(node.val);
                    if(node.right != null){
                        s1.push(node.right);
                    }
                    if(node.left != null){
                        s1.push(node.left);
                    }
                }
                ret.add(sub);
                goingRight = true;
                
                
            }
        }
        
        return ret;
        
        
        
    }
}