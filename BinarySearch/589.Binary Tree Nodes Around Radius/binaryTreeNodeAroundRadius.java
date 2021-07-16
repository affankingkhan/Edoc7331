// https://binarysearch.com/problems/Binary-Tree-Nodes-Around-Radius
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    TreeNode start;
    public int[] solve(Tree root, int target, int radius) {
        List<Integer> list = new ArrayList<>();
        dfs(root, null, target);

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();

        q.offer(start);
        for (int i = 0; i < radius; i++) {
            int n = q.size();
            while (n > 0) {
                TreeNode curr = q.poll();
                visited.add(curr.val);
                if (curr.parent != null && !visited.contains(curr.parent.val)) {
                    q.offer(curr.parent);
                }
                if (curr.left != null && !visited.contains(curr.left.val)) {
                    q.offer(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right.val)) {
                    q.offer(curr.right);
                }

                n--;
            }
        }

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            list.add(curr.val);
        }

        int[] ret = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }

        Arrays.sort(ret);
        return ret;
    }

    private TreeNode dfs(Tree node, TreeNode parent, int target) {
        if (node == null)
            return null;

        TreeNode curr = new TreeNode(node.val);

        TreeNode left = dfs(node.left, curr, target);
        TreeNode right = dfs(node.right, curr, target);

        curr.left = left;
        curr.right = right;

        curr.parent = parent;

        if (target == node.val)
            start = curr;

        return curr;
    }

    // private int dfs(Tree node, int target, int radius, int distance) {
    //     if (node == null)
    //         return 0;
    //     if (node.val == target) {
    //         if (radius == 0) {
    //             list.add(node.val);
    //         } else {
    //             dfs(node.left, target, radius, distance + 1);
    //             dfs(node.right, target, radius, distance + 1);
    //         }
    //         return 1;
    //     }

    //     if (distance == radius && radius != 0) {
    //         list.add(node.val);
    //         return distance + 1;
    //     }

    //     if (distance < radius){
    //         int leftDistance = dfs(node.left, target,radius, distance > 1 ? distance + 1 :
    //         distance); if(leftDistance == radius && radius != 0){
    //             list.add(node.val);
    //             return leftDistance + 1;
    //         }
    //         int rightDistance = dfs(node.right, target, radius, leftDistance > 0 ? leftDistance :
    //         distance); if(rightDistance == radius && radius != 0){
    //             list.add(node.val);
    //             return rightDistance + 1;
    //         }
    //         if(rightDistance > 0 && rightDistance < )
    //         distance += dfs(node.left, target,radius, distance);

    //     }else{
    //         return distance +1;
    //     }
    // }
}