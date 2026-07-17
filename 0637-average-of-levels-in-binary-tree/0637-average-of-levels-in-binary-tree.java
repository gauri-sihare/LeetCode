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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> avrg = new ArrayList<>();

        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            double sum=0;
            double avg =0.0;
            for(int i =0; i< size ; i++){
                TreeNode node = q.remove();
                sum += node.val;
                avg = sum/size ;

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
             avrg.add(avg);
        }
        return avrg;
    }
}