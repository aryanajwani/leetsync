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
    class Tuple{
        TreeNode node;
        int position;

        Tuple(TreeNode node, int position){
            this.node = node;
            this.position = position;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        //your code goes here

        Queue<Tuple> queue = new ArrayDeque<>();
        queue.add(new Tuple(root, 0));

        int maxWidth = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            int size = queue.size();

            int left=0, right=0;
            for(int i=0; i<size; i++){
                Tuple tuple = queue.remove();
                TreeNode node = tuple.node;
                
                if(i==0) left=tuple.position;
                if(i==size-1) right = tuple.position;

                if(node==root){
                    if(root.left!=null) queue.add(new Tuple(root.left, 1));

                    if(root.right!=null) queue.add(new Tuple(root.right, 2));

                    continue;
                }
                if(node.left!=null) queue.add(new Tuple(node.left, 2*(tuple.position-1)+1));

                if(node.right!=null) queue.add(new Tuple(node.right, 2*(tuple.position-1)+2));
            }

            maxWidth = Math.max(maxWidth, right-left+1);
        }

        return maxWidth;
    }
}