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
    public int goodNodes(TreeNode root) {
        return good(root, root.val)+1;
    }
    private int good(TreeNode root, int value){
        int result = 0;
        if(root.left != null){
            if(value <= root.left.val) result += good(root.left, root.left.val)+1;
            else result += good(root.left, value);
        }
        if(root.right != null){
            if(value <= root.right.val) result += good(root.right, root.right.val)+1;
            else result += good(root.right, value);
        }
        return result;
    }
}