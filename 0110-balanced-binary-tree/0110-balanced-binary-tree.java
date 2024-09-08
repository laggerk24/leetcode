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
    int maxDifference = -1;
    public int isBalancedUtil(TreeNode root){
        if(root == null) return 0;
        int left = 1+isBalancedUtil(root.left);
        int right = 1+isBalancedUtil(root.right);
        maxDifference = Math.max(maxDifference, Math.max(left,right)-Math.min(left,right));
        return Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        isBalancedUtil(root);
        return maxDifference < 2;
    }
}