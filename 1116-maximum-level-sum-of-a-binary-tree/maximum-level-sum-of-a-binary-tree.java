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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q =  new LinkedList<>();
        q.offer(root);
        
        
        int maxSum = Integer.MIN_VALUE;
        int level = 1;
        int maxSumLevel =  1;

        
        while(!q.isEmpty()){
            int sum=0;
            int size = q.size();

            for(int i =0; i< size ; i++){
                TreeNode node = q.remove();
                sum += node.val;

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }

            }
                if(sum > maxSum){
                    maxSum = sum;
                    maxSumLevel = level;
                }
                level++; // 0 1
        }
        
        return maxSumLevel;
    }
}