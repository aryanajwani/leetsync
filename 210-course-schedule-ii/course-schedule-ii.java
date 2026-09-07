class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int indegree[] = new int[n];
        for(int[] edge : prerequisites){
            indegree[edge[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<n; i++) if(indegree[i] ==0) queue.add(i);

        int[] result= new int[n];
        int index=0;

        while(!queue.isEmpty()){
            int node = queue.remove();

            result[index++] = node;

            for(int[] edge : prerequisites){
                if(edge[1]== node){
                    if (--indegree[edge[0]] ==0) queue.add(edge[0]);
                }
            }
        }

        if(index<n) return new int[0];

        return result;
    }
}