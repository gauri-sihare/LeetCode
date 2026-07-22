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
        TreeNode prev = null;
        int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        
        helper(root);
        return minDiff;
    }
    public void helper(TreeNode root){
        if(root == null ){
            return;
        }
        int diff =0;
        helper(root.left);
        if(prev != null){
            diff = Math.abs(root.val - prev.val);
            minDiff = Math.min(minDiff , diff);
        }
        prev = root;

        helper(root.right);

    }
}