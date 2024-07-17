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
    private int[] deleteMap = new int[1001];
    List<TreeNode> ans = new ArrayList<>();

    public void helper(TreeNode root,TreeNode parent,boolean isLeft){
        if(root == null ) return;
        if(deleteMap[root.val] > 0 ){
            if(parent != null){
                if(isLeft) parent.left = null;
                else parent.right = null;
            }
            helper(root.left,null,true);      // see here we are passing null as parent
            helper(root.right,null,false);    // see here we are passing null as parent
        }
        else{
            if(parent==null) ans.add(root);
            helper(root.left,root,true);      
            helper(root.right,root,false);
        }   
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int num:to_delete){
            deleteMap[num]++;
        }
        helper(root,null,false);
        return ans;
    }
}