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

    public TreeNode deserialize(String data) {
        if(data.equals("#")) return null;

        String arr[] = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int i=1;
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();

            if(!arr[i].equals("#")){
                node.left = new TreeNode(Integer.valueOf(arr[i]));
                queue.add(node.left);
            }
            i++;

            if(!arr[i].equals("#")){
                node.right = new TreeNode(Integer.valueOf(arr[i]));
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));