class Solution {
    public int findCircleNum(int[][] adj) {
         int V = adj.length;
        int visited[] = new int[V+1]; 
        int count=0;

        for(int i=1; i<=V; i++){
            if(visited[i]!=1){
                count++;
                dfs(i, visited, adj);
            }
        }

        return count;
    }

    void dfs(int node, int visited[], int adj[][]){
        visited[node] = 1;

        int neighbours[] = adj[node-1];

        for(int i=0; i<neighbours.length; i++){
            if(neighbours[i]==1 && visited[i+1]==0){
                dfs(i+1, visited, adj);
            }
        }
    }
}