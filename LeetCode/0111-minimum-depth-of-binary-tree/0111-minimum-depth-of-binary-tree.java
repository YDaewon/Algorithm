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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return depth(root, 1);
    }

    int depth(TreeNode root, int d){
        if(root.left != null && root.right != null){
            int left = depth(root.left, d + 1);
            int right = depth(root.right, d + 1);
            return Math.min(left, right);
        }
        else if(root.left == null && root.right != null){
            return depth(root.right, d+1);
        }
        else if(root.left != null && root.right == null){
            return depth(root.left, d+1);
        }
        else{
            return d;
        }
    }
}