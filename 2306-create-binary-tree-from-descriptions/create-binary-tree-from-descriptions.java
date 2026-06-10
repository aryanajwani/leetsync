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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        List<Integer> children = new ArrayList<>();

        for(int[] arr : descriptions){
            int parent = arr[0], child = arr[1];
            int isLeft = arr[2];

            children.add(child);

            TreeNode parentNode=  map.computeIfAbsent(parent, k-> new TreeNode(parent));
            TreeNode childNode = map.computeIfAbsent(child, k-> new TreeNode(child));

            if(isLeft==1) parentNode.left = childNode;
            else parentNode.right = childNode; 
        }

        for(TreeNode node: map.values()){
            if(!children.contains(node.val)) return node;
        }

        return null;
    }
}