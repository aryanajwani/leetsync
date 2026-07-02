class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] adjacent = new ArrayList[numCourses];

        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> ordering = new ArrayList<>();

        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];

            ++indegree[v];

            if(adjacent[u]==null) adjacent[u] = new ArrayList<>();

            adjacent[u].add(v);
        }

        for(int i=0; i<indegree.length; i++){
            if(indegree[i] ==0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int node = queue.remove();

            ordering.add(node);

            if(adjacent[node]==null) continue;
            
            for(int neighbour: adjacent[node]){
                if(--indegree[neighbour] == 0) queue.add(neighbour);
            }
        }

        if(ordering.size() == numCourses) return true;

        return false;
    }
}