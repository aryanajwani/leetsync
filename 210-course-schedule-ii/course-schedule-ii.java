class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();

        for(int[] edge : prerequisites){
            int u = edge[1];
            int v = edge[0];

            adj[u].add(v);
        }

        int[] visited=new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(visited[i]==0){
                if(!dfs(i, visited, adj, stack)) return new int[0];            
            }
        }

        int result[] = new int[n];
        int index=0;
        while(!stack.isEmpty()) result[index++]= stack.pop();

        return result;
    }

    //return false if contains cycle
    boolean dfs(int node, int[] visited, List<Integer>[] adj, Deque<Integer> stack){
        visited[node] = 1;

        for(int n : adj[node]){
            if(visited[n]!=2){
                if(visited[n]==1) return false;
                if(!dfs(n, visited, adj, stack)) return false;
            }
        }

        visited[node] = 2;
        stack.push(node);

        return true;
    }
}