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
    public TreeNode deleteNode(TreeNode root, int key) {
        //your code goes here
        if(root == null) return null;

        TreeNode node = root;
        TreeNode parent = null;

        while(node!=null  && node.val!=key){
            parent = node;

            if(key < node.val) node = node.left;
            else node = node.right;
        }

        // didn't find the value
        if(node==null) return root;

        if(node.right!=null && node.left!=null){
            //has both the subtrees
            if(parent!= null){
                if(parent.left == node) parent.left = node.left;
                else parent.right = node.left;
            }
            else root = root.left;

            findLargestInTree(node.left).right = node.right;
        }

        else if(node.right == null && node.left==null){
            //leaf node
            if(parent !=null){
                if(parent.left == node) parent.left = null;
                else parent.right = null;
            }
            else return null;
        }

        else if(node.right !=null){
            //has only right subtree
            if(parent !=null){
                if(parent.left == node) parent.left = node.right;
                else parent.right = node.right;
            }
            else return root.right;
        }
        else{
            //has only left subtree
            if(parent !=null){
                if(parent.left == node) parent.left = node.left;
                else parent.right = node.left;
            }
            else return root.left;
        }

        return root;
    }

    TreeNode findLargestInTree(TreeNode root){
        TreeNode node =root;

        while(node.right !=null) node= node.right;

        return node;
    }
}