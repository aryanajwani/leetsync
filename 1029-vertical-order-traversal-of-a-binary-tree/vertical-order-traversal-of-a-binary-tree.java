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
    class Tupple{
        TreeNode node;
        int X, Y;

        Tupple(TreeNode node, int X, int Y){
            this.node = node;
            this.X = X;
            this.Y = Y;
        }
    }

    void addNewLevel(TreeMap<Integer, PriorityQueue<Integer>> yMap, Tupple tupple){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(tupple.node.val);
        yMap.put(tupple.Y, pq);
    }

    void addNewVertical(TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> xMap, Tupple tupple){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        TreeMap<Integer, PriorityQueue<Integer>> yMap = new TreeMap<>();

        pq.add(tupple.node.val);
        yMap.put(tupple.Y, pq);
        xMap.put(tupple.X, yMap);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //your code goes here
        Queue<Tupple> queue = new ArrayDeque<>();
        queue.add(new Tupple(root, 0, 0));

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> xMap = new TreeMap<>();

        List<List<Integer>> traversal = new ArrayList<>();

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                Tupple tupple= queue.remove();
                TreeNode node = tupple.node;

                if(xMap.containsKey(tupple.X)){
                    TreeMap<Integer, PriorityQueue<Integer>> yMap = xMap.get(tupple.X);

                    if(yMap.containsKey(tupple.Y)){
                        PriorityQueue<Integer> pq = yMap.get(tupple.Y);
                        pq.add(node.val);
                    }
                    else{
                        //yMap doesnt contain priority queue
                        addNewLevel(yMap, tupple);
                    }
                }
                else{
                    //xMap doesnt contain tupple's X cord
                    addNewVertical(xMap, tupple);
                }

                if(node.left!=null) queue.add(new Tupple(node.left, tupple.X-1, tupple.Y+1));
                if(node.right!=null) queue.add(new Tupple(node.right, tupple.X+1, tupple.Y+1));
            }  
        }

        for(int X : xMap.keySet()){
            List<Integer> veritcal = new ArrayList<>();

            TreeMap<Integer, PriorityQueue < Integer>> yMap =  xMap.get(X);
            for(int Y : yMap.keySet()){

                PriorityQueue<Integer> pq = yMap.get(Y);
                while(!pq.isEmpty()){
                    veritcal.add(pq.poll());
                }
            }
            traversal.add(veritcal);
        }
        return traversal;
    }
}