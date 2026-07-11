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
    int res =0 ;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root );
        return res;
    }
    public int helper(TreeNode root ){
         int height ;
        if(root == null){
            return 0;
        }
        int lh = helper(root.left);
        int rh = helper(root.right);
        
        res = Math.max(res , lh+rh );
        height = (1+ Math.max(lh , rh));

        
        return height;   //issi function k liye height needed h .
    }
}
