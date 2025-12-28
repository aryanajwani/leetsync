/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //your code goes here
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        findPathToNode(root, p, pathP);
        findPathToNode(root, q, pathQ);

        int i=0, j=0;
        while(i<pathP.size() && j<pathQ.size()){
            if(pathP.get(i)!= pathQ.get(j)) break;

            i++;
            j++;
        }

        return pathP.get(i-1);
    }

    boolean findPathToNode(TreeNode root, TreeNode p, List<TreeNode> path){
        if(root==null) return false;

        path.add(root);
        if(root == p) return true;

        if(findPathToNode(root.left, p, path) || findPathToNode(root.right, p, path)) return true;

        path.remove(path.size()-1);
        return false;
    }
}