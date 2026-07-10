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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode left = root.left ;
        TreeNode right= root.right ;
        return helper(left , right);

        
    }
    public boolean helper(TreeNode left , TreeNode right){
        // if(root.right == null && root.left == null){
        //     return true;
        // }
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(right.val != left.val){
            return false;
        }

        return helper(left.left  ,  right .right) && helper(left.right , right.left);
    }
}