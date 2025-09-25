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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return depth(root) != -1;
    }

    int depth(TreeNode node){
        if(node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        if(left < 0 || right < 0 || Math.abs(left-right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}