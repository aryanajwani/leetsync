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

        TreeNode replacement;
        if(node.right!=null && node.left!=null){
            //has both the subtrees

            findLargestInTree(node.left).right = node.right;
            replacement = node.left;
        }
         //leaf node
        else if(node.right == null && node.left==null) replacement = null;
         //has only right subtree
        else if(node.right !=null) replacement = node.right;
        //has only left subtree
        else  replacement = node.left;


        // node to be deleted was root itself
        if(parent == null) return replacement;
        
        else if(parent.left == node) parent.left = replacement;
        else parent.right= replacement;

        return root;
    }

    TreeNode findLargestInTree(TreeNode root){
        TreeNode node =root;

        while(node.right !=null) node= node.right;

        return node;
    }
}