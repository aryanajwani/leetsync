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
    int maxPathDown(TreeNode root, int max[]){
        if(root ==null) return 0;

        int leftMax = maxPathDown(root.left, max);
        int rightMax = maxPathDown(root.right, max);
        
        int maxAcrossViaNode = root.val + leftMax + rightMax;

        max[0] = Math.max(max[0], maxAcrossViaNode);

        int maxDownViaNode = root.val + Math.max(leftMax, rightMax);
        
        return maxDownViaNode>0? maxDownViaNode : 0;
    }
    public int maxPathSum(TreeNode root) {
        //your code goes here
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathDown(root, max);
        return max[0];
    }
}