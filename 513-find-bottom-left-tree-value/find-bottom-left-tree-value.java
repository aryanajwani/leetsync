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
    public int findBottomLeftValue(TreeNode root) {
        int maxDepth[]= new int[1];
        maxDepth[0] = -1;

        int leftMostValue[] = new int[1];
        leftMostValue[0] = -1;
        
        func(root, 0, maxDepth, leftMostValue);
        return leftMostValue[0];
    }

    void func(TreeNode root, int currentDepth, int[] maxDepth, int[] leftMostValue){
        if(root==null) return;

        if(currentDepth> maxDepth[0]){
            maxDepth[0] = currentDepth;
            leftMostValue[0] = root.val;
        }

        func(root.left, currentDepth+1, maxDepth, leftMostValue);
        func(root.right, currentDepth+1,  maxDepth, leftMostValue);
    }
}