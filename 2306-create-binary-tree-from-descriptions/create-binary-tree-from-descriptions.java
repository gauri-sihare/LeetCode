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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> children = new HashSet<>();
        HashMap<Integer, TreeNode> hm = new HashMap<>();

        for(int[] node: descriptions){
            int parent = node[0];
            int child = node[1];
            int isLeft = node[2];

            children.add(child);

            if(!hm.containsKey(parent)){
                hm.put(parent,new TreeNode(parent));
            }
            TreeNode parentNode = hm.get(parent);

            if(!hm.containsKey(child)){
                hm.put(child, new TreeNode(child));
            }
            TreeNode childNode = hm.get(child);
            

            if(isLeft == 1){
                parentNode.left = childNode;
            }else{
                parentNode.right = childNode;
            }
        }



        for(int[] node: descriptions){
            if(!children.contains(node[0])){
                return hm.get(node[0]);
            }
        }
        return null;
    }
}