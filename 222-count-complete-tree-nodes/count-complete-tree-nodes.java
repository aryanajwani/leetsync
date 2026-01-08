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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int left = getHeightLeft(root);
        int right= getHeightRight(root);

        if(left==right){
            return (int)Math.pow(2, left)-1;
        }

        return 1+ countNodes(root.left) + countNodes(root.right);
    }

    int getHeightLeft(TreeNode root){
        if(root==null) return 0;

        return 1+ getHeightLeft(root.left);
    }    

    int getHeightRight(TreeNode root){
        if(root==null) return 0;

        return 1+ getHeightRight(root.right);
    }
}