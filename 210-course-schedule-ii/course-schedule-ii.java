class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();

        for(int[] edge : prerequisites){
            int u = edge[1];
            int v = edge[0];

            adj[u].add(v);
        }

        boolean[] visited=new boolean[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(!visited[i]){
                if(!dfs(i, visited, adj, stack, new HashSet<>())) return new int[0];            
            }
        }

        int result[] = new int[n];
        int index=0;
        while(!stack.isEmpty()) result[index++]= stack.pop();

        return result;
    }

    //return false if contains cycle
    boolean dfs(int node, boolean[] visited, List<Integer>[] adj, Deque<Integer> stack, Set<Integer> currpath){
        currpath.add(node);

        for(int n : adj[node]){
            if(!visited[n]){
                if(currpath.contains(n)) return false;
                if(!dfs(n, visited, adj, stack, currpath)) return false;
            }
        }

        currpath.remove(node);
        visited[node]= true;
        stack.push(node);

        return true;
    }
}