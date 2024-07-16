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
    public TreeNode LCA(TreeNode root,int v1, int v2){
        if(root == null || root.val == v1 || root.val == v2 ) return root;
        TreeNode left = LCA(root.left,v1,v2);
        TreeNode right = LCA(root.right,v1,v2);
        if(left!= null && right != null) return root;
        if(left != null) return left;
        return right;
    }
    public boolean DFS1(TreeNode node,int target, StringBuilder s){
        if(node == null) return false;
        if(node.val == target) return true;
        s.append("U");
        if(DFS1(node.left,target,s)) return true;
        if(DFS1(node.right,target,s)) return true;
        s.deleteCharAt(s.length()-1);
        return false;
    } 
    public boolean DFS2(TreeNode node,int target, StringBuilder s){
        if(node == null) return false;
        if(node.val == target) return true;

        s.append("R");
        if(DFS2(node.right,target,s)) return true;
        s.deleteCharAt(s.length()-1);
        s.append("L");
        if(DFS2(node.left,target,s)) return true;
        s.deleteCharAt(s.length()-1);
        return false;
    } 
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode commonAncestor = LCA(root,startValue,destValue);
        StringBuilder s = new StringBuilder();
        DFS1(commonAncestor, startValue, s);
        DFS2(commonAncestor, destValue, s);
        return new String(s);
    }
}