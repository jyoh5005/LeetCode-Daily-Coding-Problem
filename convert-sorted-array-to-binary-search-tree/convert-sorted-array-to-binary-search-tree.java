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
    public TreeNode sortedArrayToBST(int[] nums) {
        return BuildTree(nums, 0, nums.length-1);
    }
    private TreeNode BuildTree(int[] nums, int first, int last){
        if(first > last) return null;
        TreeNode subTree = new TreeNode(nums[(first+last)/2]);
        subTree.left = BuildTree(nums, first, (first+last)/2-1);
        subTree.right = BuildTree(nums, (first+last)/2+1, last);
        return subTree;
    }
}