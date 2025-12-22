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
    int maxDepth(TreeNode root, int maxDiameter[]){
        if(root==null) return 0;

        int leftDepth = maxDepth(root.left, maxDiameter);
        int rightDepth = maxDepth(root.right, maxDiameter); 

        maxDiameter[0] = Math.max(maxDiameter[0], leftDepth+rightDepth);
        return Math.max(leftDepth, rightDepth)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        //your code goes here
        int maxDiameter[] = new int[1];
        maxDiameter[0] = 0;

        maxDepth(root, maxDiameter);
        return maxDiameter[0];
    }
}