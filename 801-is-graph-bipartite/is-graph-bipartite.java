class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        int visited[] = new int[graph.length];

        Arrays.fill(visited, -1);

        for(int i=0; i<graph.length; i++){
            if(visited[i] ==-1){
                queue.add(i);
                visited[i] = 0;

                if(!bfs(visited, graph, queue)) return false;;
            }
        }

        return true;
    }

    boolean bfs(int visited[], int[][] graph, Queue<Integer> queue){

        while(!queue.isEmpty()){
            int node = queue.remove();

            int[] neighbours = graph[node];
            for(int neighbour : neighbours){
                if(visited[neighbour] ==-1){
                    queue.add(neighbour);
                    visited[neighbour] = (visited[node] == 0)? 1: 0;
                }
                if(visited[neighbour] == visited[node]) return false;
            }
        }

        return true;
    }
}