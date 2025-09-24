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
        return makeTree(nums, 0, nums.length-1);
    }

    TreeNode makeTree(int [] nums, int s, int e){
        if(s > e) return null;

        int mid = (s+e) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeTree(nums, s, mid-1);
        root.right = makeTree(nums, mid+1, e);

        return root;
    }
}