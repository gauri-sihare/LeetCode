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
    int maxsum;
    public int maxPathSum(TreeNode root) {
        maxsum = Integer.MIN_VALUE;
        solve(root);
        return maxsum;
    }
    public int solve(TreeNode root){
        if(root == null ){
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);
        //one of the left/right is -ve
        int leftorright = Math.max(left , right) + root.val;
        //root is just positve
        int rootIsPositive = root.val;

        int gotAnsAtBottom = left+ right + root.val ;
        
        maxsum = Math.max(maxsum , 
                Math.max(leftorright , 
                    Math.max(rootIsPositive , gotAnsAtBottom)));

        return Math.max(rootIsPositive , leftorright);
    }
}