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
    public int amountOfTime(TreeNode root, int start) {
        //your code goes here
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        Map<TreeNode, TreeNode> map = new HashMap<>();
        //child-> parent

        TreeNode startNode =null;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode node = queue.remove();

                if(node.val == start) startNode = node;
                if(node.left!=null){
                    queue.add(node.left);
                    map.put(node.left, node);
                }
                if(node.right!=null){
                    queue.add(node.right);
                    map.put(node.right, node);
                }
            }
        }

        queue.add(startNode);
        Set<TreeNode> visited = new HashSet<>();

        int time =0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode node = queue.remove();
                visited.add(node);

                if(node.left!=null && !visited.contains(node.left)){
                    queue.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    queue.add(node.right);
                }
                if(map.get(node)!=null && !visited.contains(map.get(node))){
                    queue.add(map.get(node));
                }
            }
            ++time;
        }

        return time-1;
    }
}