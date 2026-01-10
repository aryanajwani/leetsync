/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serialize(TreeNode root) {
        if(root ==null) return "#";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder str = new StringBuilder();

        while(!queue.isEmpty()){
            TreeNode node = queue.remove();

            if(node==null){
                str.append("#").append(",");
                continue;
            }

            str.append(node.val).append(",");

            queue.add(node.left);
            queue.add(node.right);
        }

        return str.toString();
    }

    public TreeNode deserialize(String str) {
        if(str.equals("#")) return null;
        
        int i = str.indexOf(",");
        TreeNode root = new TreeNode(Integer.valueOf(str.substring(0, i)));
        i++;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();

            int j = str.indexOf(",", i);
            String sub = str.substring(i, j);

            if(sub.equals("#")) node.left=null;
            else{
                node.left = new TreeNode(Integer.valueOf(sub));
                queue.add(node.left);
            }

            i=j+1;
            j = str.indexOf(",", i);
            sub = str.substring(i, j);

            if(sub.equals("#"))node.right=null;
            else{
                node.right = new TreeNode(Integer.valueOf(sub));
                queue.add(node.right);
            }
            
            i=j+1;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));