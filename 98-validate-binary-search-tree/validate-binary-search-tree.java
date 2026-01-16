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
    public boolean isValidBST(TreeNode root) {
        //your code goes here
        long[] prev = new long[]{Long.MIN_VALUE};

        return performInorder(root, prev);
    }

    boolean performInorder(TreeNode root, long prev[]){
        if(root== null) return true;


        if (!(performInorder(root.left, prev) && root.val>prev[0])) return false;

        prev[0] = root.val;
        
        return performInorder(root.right, prev);
    }
}