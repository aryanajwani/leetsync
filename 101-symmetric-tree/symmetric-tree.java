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
    boolean compareTraversals(TreeNode p, TreeNode q){
        if(p==null || q==null) return p==q;

        return p.val==q.val && compareTraversals(p.left, q.right)
               &&compareTraversals(p.right, q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        //your code goes here
        return compareTraversals(root.left, root.right);
    }
}