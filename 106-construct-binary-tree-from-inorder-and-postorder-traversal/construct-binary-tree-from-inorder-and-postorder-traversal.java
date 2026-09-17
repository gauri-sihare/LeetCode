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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer , Integer> inorderidxmap = new HashMap<>();
        for(int i =0; i<inorder.length; i++){
            inorderidxmap.put(inorder[i] , i);
        }
        return splittree(inorderidxmap , postorder ,  inorder.length-1 , 0 , inorder.length-1 );
    }

    private TreeNode splittree(Map<Integer,Integer> inorderidxmap ,  int[] postorder , int rootidx , int left , int right ){
        TreeNode root = new TreeNode(postorder[rootidx]);
        //split
        int mid = inorderidxmap.get(root.val);

       
        if(mid < right){
            root.right = splittree(inorderidxmap , postorder , rootidx-1 , mid+1 , right );
        }

        if(mid> left){
            root.left = splittree(inorderidxmap , postorder , rootidx - (right- mid) -1 , left , mid-1);
        }
        return root;
    }
}