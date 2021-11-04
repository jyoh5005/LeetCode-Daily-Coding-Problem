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
    public int sumOfLeftLeaves(TreeNode root) {
        return Inner(root, false);
    }
    private int Inner(TreeNode node, boolean isLeft){
        if(node.left == null){
            if(node.right == null){
                if(isLeft){
                    return node.val;
                }
                else{
                    return 0;
                }
            }
            else{
                return Inner(node.right, false);
            }
        }
        else{
            if(node.right == null){
                return Inner(node.left, true);
            }
            else{
                return Inner(node.left, true) + Inner(node.right, false);
            }
        }
    }
}