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
        Set<Integer> children = new HashSet<>();

        for(int[] arr : descriptions){
            int parent = arr[0], child = arr[1];
            int isLeft = arr[2];

            children.add(child);

            TreeNode parentNode=  map.computeIfAbsent(parent, k-> new TreeNode(parent));
            TreeNode childNode = map.computeIfAbsent(child, k-> new TreeNode(child));

            if(isLeft==1) parentNode.left = childNode;
            else parentNode.right = childNode; 
        }

        for(Integer node: map.keySet()){
            if(!children.contains(node)) return map.get(node);
        }

        return null;
    }
}