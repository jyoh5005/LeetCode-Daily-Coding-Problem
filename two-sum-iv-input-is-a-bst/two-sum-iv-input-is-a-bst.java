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
    private HashSet<Integer> hashset;
    private int target;
    public boolean findTarget(TreeNode root, int k) {
        hashset = new HashSet<Integer>();
        target = k;
        return dfsFindTarget(root);
    }
    public boolean dfsFindTarget(TreeNode node){
        if(hashset.contains(target-node.val)) return true;
        hashset.add(node.val);
        if(node.left != null && dfsFindTarget(node.left)) return true;
        if(node.right != null && dfsFindTarget(node.right)) return true;
        return false;
    }
}