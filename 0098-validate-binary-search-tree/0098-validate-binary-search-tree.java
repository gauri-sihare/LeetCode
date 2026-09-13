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
    public boolean isValidBST(TreeNode root) {
        List<Integer> ll = new LinkedList<>();
        helper(root , ll);

        boolean bst = true;
        int prev =  ll.get(0);
        for(int i =1; i< ll.size(); i++){
            if(prev >= ll.get(i)){
                bst = false;
            }
            prev = ll.get(i);
        }
        return bst;     
    }

    void helper(TreeNode rootNode , List<Integer> ll ){
        if(rootNode ==  null){
            return ;
        }
        helper(rootNode.left , ll );
        ll.add(rootNode.val);
        helper(rootNode.right , ll);        
    }
}