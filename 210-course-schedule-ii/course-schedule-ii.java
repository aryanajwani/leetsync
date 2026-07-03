class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[n];
        int[] indegree = new int[n];

        for(int[] edge: prerequisites){
            int u = edge[1];
            int v = edge[0];

            if(adj[u] == null) adj[u] = new ArrayList<Integer>();

            adj[u].add(v);
            ++indegree[v];
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<n; i++) if(indegree[i] ==0) queue.add(i);

        return getTopoOrder(adj, indegree, queue, n);
    }

    int[] getTopoOrder(List<Integer>[] adj, int[] indegree, Queue<Integer> queue, int n){
        int ordering[]= new int[n];
        int index =0;

        while(!queue.isEmpty()){
            int node = queue.remove();

            ordering[index++] = node;

            if(adj[node] == null) continue;
            
            for(int neighbour: adj[node]){
                if(--indegree[neighbour] == 0) queue.add(neighbour);
            } 
        }

        if(index<n) return new int[0];

        return ordering;
    }
}