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
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        search(root, "");
        return result;
    }

    public void search(TreeNode root, String str){
        if(root.left == null && root.right == null){
            str += root.val;
            result.add(str);
            return;
        }
        str += root.val + "->";

        if(root.left != null) search(root.left, str);
        if(root.right != null) search(root.right, str);
    }
}