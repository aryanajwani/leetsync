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
    public int kthSmallest(TreeNode root, int k) {
        int counter[] = new int[]{0};
        int result[] = new int[]{-1};

        getKSmallest(root, k, counter, result);

        return result[0];
    }

    void getKSmallest(TreeNode root, int k, int counter[], int[] result){
        if(root == null) return;

        getKSmallest(root.left, k, counter, result);

        if(counter[0] == k-1) result[0] = root.val;
        counter[0]++;

        if(result[0] != -1) return;

        getKSmallest(root.right, k, counter, result);
    }
}