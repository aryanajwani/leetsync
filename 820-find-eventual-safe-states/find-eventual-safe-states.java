class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        Set<Integer> notSafe = new HashSet<>();
        List<Integer> safe = new ArrayList<>();

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                Set<Integer> set = dfs(i, graph, visited, new HashSet<>(), notSafe);
                if(set!=null) notSafe.addAll(set);
                else safe.add(i);
            }
            else if(!notSafe.contains(i)) safe.add(i);
        }

        return safe;
    }

    //dfs method to detect cycle and return the path if found
    Set<Integer> dfs(int node, int[][] graph, boolean[] visited, Set<Integer> pathVisited, Set<Integer> notSafe){
        visited[node] = true;
        pathVisited.add(node);

        for(int neighbour : graph[node]){
            if(!visited[neighbour]){
                Set<Integer> result = dfs(neighbour, graph, visited, pathVisited, notSafe);;

                if(result != null) return result;
            } 

            else if(pathVisited.contains(neighbour)) return pathVisited;

            else if (notSafe.contains(neighbour)) return pathVisited;
        }

        pathVisited.remove(node);
        return null;
    }
}
