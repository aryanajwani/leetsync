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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        // inorder element-> index

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
    }

    TreeNode build(int postorder[], int postStart, int postEnd, int inorder[], int inStart, int inEnd, Map<Integer, Integer> map){
        if(postStart>postEnd || inStart>inEnd){
            return null;
        }

        TreeNode root= new TreeNode(postorder[postEnd]);

        int rootIndex = map.get(root.val);
        int numRight= inEnd-rootIndex;

        root.right = build(postorder, postEnd-numRight, postEnd-1, inorder, rootIndex+1, inEnd, map);

        root.left = build(postorder, postStart,  postEnd-numRight-1, inorder, inStart, rootIndex-1, map);

        return root;
    }
}