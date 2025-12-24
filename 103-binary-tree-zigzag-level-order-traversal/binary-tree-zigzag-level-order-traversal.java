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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //your code goes here
        List<List<Integer>> traversal = new ArrayList<>();
        if(root ==null) return traversal;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean isLeftToRight= true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new LinkedList<>();

            for(int i=0; i<size; i++){
                TreeNode node = queue.remove();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);

                if(isLeftToRight) level.addLast(node.val);
                else level.addFirst(node.val);
            }

            traversal.add(level);
            isLeftToRight = !isLeftToRight;
        }

        return traversal;
    }
}