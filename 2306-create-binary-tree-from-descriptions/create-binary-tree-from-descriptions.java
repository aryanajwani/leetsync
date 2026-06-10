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
        boolean isChild[] = new boolean[100001];

        for(int[] arr : descriptions){
            int parent = arr[0], child = arr[1];
            int isLeft = arr[2];

            isChild[child] = true;

            TreeNode parentNode=  map.computeIfAbsent(parent, k-> new TreeNode(parent));
            TreeNode childNode = map.computeIfAbsent(child, k-> new TreeNode(child));

            if(isLeft==1) parentNode.left = childNode;
            else parentNode.right = childNode; 
        }

        for(int i=0; i<isChild.length; i++){
            if(map.containsKey(i) && isChild[i]==false) return map.get(i);
        }

        return null;
    }
}