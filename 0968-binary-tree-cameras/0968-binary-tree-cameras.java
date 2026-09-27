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
    static int cam;
    public int minCameraCover(TreeNode root) {
        cam =0;
        // -1 cam is req , 0 = node have cam , 1 = node is covered .
        if(minCamReq(root) == -1){
            cam++;
        }
        return cam;
    }

    public static int minCamReq(TreeNode root){
        if(root == null){
            return 1;
        }

        int leftCh =  minCamReq(root.left);
        int rightCh = minCamReq(root.right);

        if(leftCh == -1 || rightCh == -1){
            cam++;
            return 0;
        }
        if(leftCh == 0 || rightCh == 0){
            return 1;
        }
        // if(leftCh == 1 || rightCh == 1){
        //     return -1;
        // }
        return -1;

    }
}