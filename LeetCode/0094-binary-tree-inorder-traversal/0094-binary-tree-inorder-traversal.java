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
    List<Integer> rtn = new ArrayList<>();;

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return rtn;
    }

    public void inorder(TreeNode cur){
        if(cur != null){
            if(cur.left != null) inorder(cur.left);
            rtn.add(cur.val);
            if(cur.right != null) inorder(cur.right);
        }
    }
}