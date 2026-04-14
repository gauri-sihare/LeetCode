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
    public int maxDepth(TreeNode root) {

        if( root == null ){
            return 0;
        }
        Queue<TreeNode> eleQue = new LinkedList<>();
        eleQue.add(root);
        int levelNum = 0;

        while(!eleQue.isEmpty()){
            int nodesAtALevel = eleQue.size();
            while(nodesAtALevel > 0){

                TreeNode ele = eleQue.poll();

                if(ele.left != null){
                    eleQue.add(ele.left);
                }
                if(ele.right != null){
                    eleQue.add(ele.right);
                }
                nodesAtALevel--;
            }
             levelNum++;
        }
        return levelNum;
    }
}