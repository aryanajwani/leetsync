class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        buildAdj(adj, flights);

        // node - distance
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{src, 0});

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        int level=0;
        while(!queue.isEmpty()){
            if(level== k+1) break;
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                int[] pair = queue.remove();
                int u = pair[0];
                int dist = pair[1];

                for(int[] npair : adj[u]){
                    int v = npair[0];
                    int w = npair[1];

                    int ndist = dist + w;

                    if(ndist < distance[v]){
                        distance[v] = ndist;
                        queue.add(new int[]{v, ndist});
                    }
                }
            }

            ++level;
        }

        return distance[dst] == Integer.MAX_VALUE? -1: distance[dst];
    }

    void buildAdj(List<int[]>[] adj, int[][] edges){
        for(int[] edge :edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj[u].add(new int[]{v, w});
        }
    }
}