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
    HashMap<TreeNode , int[]> dp = new HashMap<>();
    public int rob(TreeNode root) {
        return sol(root , false);
    }
    public int sol(TreeNode root , boolean parentRob){
        if(root == null){
            return 0;
        }

        int idx;
        if(parentRob == true){
            idx =1;
        }else{
            idx= 0;
        }

        if(dp.containsKey(root) && dp.get(root)[idx]!= -1){
            return dp.get(root)[idx];
        }


        int one =0;
        if(parentRob == false){
            one = root.val + sol(root.left , true) + sol(root.right , true);
        }
        int two = sol(root.left , false)+ sol(root.right , false);

        if(!dp.containsKey(root)){
            dp.put(root , new int[]{-1, -1});
        }
        int ans  = Math.max(one, two);
        dp.get(root)[idx]  = ans ;
        return ans;

    }
}