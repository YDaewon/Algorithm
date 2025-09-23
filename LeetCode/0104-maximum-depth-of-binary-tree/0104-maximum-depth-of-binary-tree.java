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
    int dep = 1;
    // public int maxDepth(TreeNode root) {
    //     if(root == null) return 0;
    //     calc(root, 1);
    //     return dep;
    // }

    // void calc(TreeNode root, int depth){
    //     if(root == null) return;
    //     dep = Math.max(depth, dep);
    //     calc(root.left, depth+1);
    //     calc(root.right, depth+1);
    // }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int l_depth = maxDepth(root.left);
        int r_depth = maxDepth(root.right);

        return Math.max(l_depth, r_depth) + 1;
    }
}