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
            return helper(root);
        }

        public int helper(TreeNode root){
            if(root == null){
                return 0;
            }
            
            int lh = helper(root.left);
            int rh =  helper(root.right);
            if(lh == 0){
                return rh+1;
            }
            if(rh == 0){
                return lh+1;
            }
            int height = Math.min(lh , rh) +1 ;
            return height;
    }
}