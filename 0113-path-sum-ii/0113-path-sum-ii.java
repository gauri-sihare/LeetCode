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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> al = new ArrayList<>();
        helper(root , al , targetSum , new ArrayList<>());
        return al;
    }
    public void helper(TreeNode root ,  List<List<Integer>> al  , int targetSum ,ArrayList<Integer>current ){
        if(root ==  null){
            return ;
        }
        current.add(root.val);

        if(root.left == null && root.right == null && targetSum - root.val == 0){
            al.add(new ArrayList(current));
        }

        helper(root.left , al , targetSum-root.val , current);
        helper(root.right , al , targetSum-root.val , current);

        current.remove(current.size() -1);
    }
}