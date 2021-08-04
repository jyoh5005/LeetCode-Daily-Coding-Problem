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
    List<List<Integer>> result;
    List<Integer> arr;
    int ts;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<List<Integer>>();
        arr = new ArrayList<Integer>();
        ts = targetSum;
        if(root != null) pathSum_Inner(root);
        return result;
    }
    private void pathSum_Inner(TreeNode node){
        arr.add(node.val);
        ts -= node.val;
        if(node.left != null) pathSum_Inner(node.left);
        if(node.right != null) pathSum_Inner(node.right);
        else if(node.left == null && ts == 0) result.add(new ArrayList<Integer>(arr));
        arr.remove(arr.size()-1);
        ts += node.val;
        return;
    }
}