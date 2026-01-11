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
    public void flatten(TreeNode root) {

        flattenTree(root);
    }

    TreeNode flattenTree(TreeNode root){
        if(root==null) return null;
        if(root.left==null && root.right==null) return root;

        TreeNode leftEnd = flattenTree(root.left); 
        TreeNode rightEnd = flattenTree(root.right);

        TreeNode right = root.right;
        if(root.left!=null) root.right= root.left;
        root.left=null;
        if(leftEnd!=null) leftEnd.right = right;

        return rightEnd!=null ? rightEnd : leftEnd;
    }
}