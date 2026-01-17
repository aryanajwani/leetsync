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
    public TreeNode bstFromPreorder(int[] preorder) {
        //your code goes here
        return build(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    TreeNode build(int preorder[], int upperbound, int[] index){
        if(index[0]>= preorder.length || preorder[index[0]] > upperbound) return null;


        TreeNode root = new TreeNode(preorder[index[0]]);
        ++index[0];

        root.left = build(preorder, root.val, index);
        root.right = build(preorder, upperbound, index);

        return root;
    }
}