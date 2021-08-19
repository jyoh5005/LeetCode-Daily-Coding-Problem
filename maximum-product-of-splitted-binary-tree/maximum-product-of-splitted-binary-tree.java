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
    private int total_sum;
    public int maxProduct(TreeNode root) {
        total_sum = totalSum(root);
        int subtree_sum;
        if(root.left != null){
            if(root.right !=null){
                int left = subtreeSum(root.left);
                int right = subtreeSum(root.right);
                System.out.println(left);
                System.out.println(right);
                subtree_sum = (Math.abs(total_sum-(left<<1)) < Math.abs(total_sum-(right<<1))) ? left : right;
            }
            else subtree_sum = subtreeSum(root.left);
        }
        else subtree_sum = subtreeSum(root.right);
        return (int)(((long)(total_sum-subtree_sum) * (long)subtree_sum) % 1000000007) ;
    }
    private int totalSum(TreeNode node){
        if(node == null) return 0;
        node.val += totalSum(node.left) + totalSum(node.right);
        return node.val;
    }
    private int subtreeSum(TreeNode node){
        int result = node.val;
        if(node.left != null){
            int temp = subtreeSum(node.left);
            if(Math.abs(total_sum-(result<<1)) > Math.abs(total_sum-(temp<<1))) result = temp;
        }
        if(node.right != null){
            int temp = subtreeSum(node.right);
            if(Math.abs(total_sum-(result<<1)) > Math.abs(total_sum-(temp<<1))) result = temp;
        }
        return result;
    }
}