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
    public TreeNode makeTree(int parent, HashMap<Integer, int[]> graph){
        if(parent == -1) return null;
        TreeNode node = new TreeNode(parent);
        node.left = makeTree(graph.get(parent)[0], graph);
        node.right = makeTree(graph.get(parent)[1],graph);
        return node;
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, int[]> graph = new HashMap<>();
        HashMap<Integer,Integer> inNodes = new HashMap<>();
        int n = descriptions.length;
        for(int[] edge:descriptions){
            int parent = edge[0];
            int child = edge[1];
            int isLeft = edge[2];
            if(!inNodes.containsKey(parent)) inNodes.put(parent,0);
            if(graph.containsKey(parent)){
                if(isLeft == 1) graph.get(parent)[0] = child;
                else graph.get(parent)[1] = child;
            }
            else{
                if(isLeft == 1) graph.put(parent,new int[]{child,-1});
                else graph.put(parent,new int[]{-1,child});
            }
            if(!graph.containsKey(child)) graph.put(child, new int[]{-1,-1});
            inNodes.put(child,inNodes.getOrDefault(child,0)+1);
        }
        int parentNode = -1;
        for(int node:inNodes.keySet()){
            if(inNodes.get(node) == 0){
                parentNode = node;
                break;
            }
        }
        return makeTree(parentNode, graph);
    }
}