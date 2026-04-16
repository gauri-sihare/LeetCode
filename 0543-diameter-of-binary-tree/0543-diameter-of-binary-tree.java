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
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> hm = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        int dia = 0;

        if(root != null){
            stack.push(root);
        }

        while(!stack.isEmpty()){
            TreeNode node = stack.peek();

            if(node.left != null && !hm.containsKey(node.left)){
                stack.push(node.left);
            }
            else if( node.right != null && !hm.containsKey(node.right)){
                stack.push(node.right);
            }else{
                stack.pop();

                int leftDepth = hm.getOrDefault(node.left , 0);
                int rightDepth = hm.getOrDefault(node.right , 0);

                hm.put(node , 1+ Math.max(leftDepth, rightDepth));

                dia = Math.max(dia , leftDepth+rightDepth);
            }
        }
        return dia;
    }
}