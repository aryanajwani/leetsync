class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = 100000;

        int[][] adj = new int[n][n];
        generateAdjMatrix(edges, adj, n);

        for(int via=0; via<n; via++){
            for(int i=0; i<n; i++){  
                for(int j=0; j<n; j++){
                    if(adj[i][via]==INF || adj[via][j]==INF) continue;

                    adj[i][j] = Math.min(adj[i][j], adj[i][via] + adj[via][j]);
                }
            }
        }


        int node = -1;
        int minCount = INF;

        for(int i=0; i<n; i++){
            int count =0;

            for(int j=0; j<n; j++){
                if(i!=j && adj[i][j]<=distanceThreshold) count++;
            }

            if(count < minCount || count == minCount){
                node = i;
                minCount = count;
            }
        }

        return node;
    }

    void generateAdjMatrix(int[][] edges, int[][] adj, int n){
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj[u][v] = w;
            adj[v][u] = w;
        }

        for(int i=0; i<n; i++) for(int j=0; j<n; j++) if(i!=j && adj[i][j]==0) adj[i][j] = 100000;
    }
}
//    0  1  2  3
// 0  0  3  4  5
// 1  3  0  1  2
// 2  4  1  0  1
// 3  5  2  1  0