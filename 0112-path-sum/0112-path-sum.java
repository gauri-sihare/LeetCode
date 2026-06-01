class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // leaf node check
        if (root.left == null && root.right == null) {
            if(targetSum == root.val){
                return true;
            }
        }

        int remainSum = targetSum - root.val;

        return hasPathSum(root.left, remainSum) ||
               hasPathSum(root.right, remainSum);
    }
}