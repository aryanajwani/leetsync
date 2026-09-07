class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int indegree[] = new int[n];

        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();

        for(int[] edge : prerequisites){
            int u = edge[1];
            int v = edge[0];

            adj[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<n; i++) if(indegree[i] ==0) queue.add(i);

        int[] result= new int[n];
        int index=0;

        while(!queue.isEmpty()){
            int node = queue.remove();
            result[index++] = node;

            for(int v : adj[node]){
                if(--indegree[v] ==0) queue.add(v);
            }
        }

        if(index<n) return new int[0];

        return result;
    }
}