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
    int maxDepth(TreeNode root){
        if(root ==null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(leftDepth==-1 || rightDepth==-1) return -1;

        if(Math.abs(leftDepth-rightDepth)>=2) return -1;
        return Math.max(leftDepth, rightDepth)+1;
    }
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)==-1? false : true;
    }
}