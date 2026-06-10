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

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            TreeNode parentNode = map.get(parent);
            TreeNode childNode = map.get(child);

            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            children.add(child);
        }

        for (int val : map.keySet()) {
            if (!children.contains(val)) {
                return map.get(val);
            }
        }

        return null;
    }
}

// [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
//   i

// [20, 15, 1] create node if its not created prior, if created update the children 
// [50, 20, 1] if 50 is present update children else create node check if the child node is created and update the link with existing node 
// [50, 80, 0] create right child of 50 
// [80, 19, 1] check if 80 node is there yes then update the children of the 80 node