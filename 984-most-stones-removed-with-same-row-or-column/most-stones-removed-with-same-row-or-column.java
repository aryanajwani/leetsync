class Solution {
    public int removeStones(int[][] stones) {
        int maxX=0, maxY=0;
        for(int[] stone : stones){
            int x = stone[0];
            int y = stone[1];

            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }

        DisjointSet ds = new DisjointSet(maxX + maxY + 2);
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int[] stone : stones){
            int x = stone[0];
            int y = stone[1];

            int row = x;
            int column = maxX+1+y;

            ds.unionBySize(row, column);

            set.add(row);
            set.add(column);
        }

        for(int node : set){
            if(ds.parent[node] == node) count++;
        }

        return stones.length - count;
    }
}

class DisjointSet{
    int parent[];
    int size[];

    DisjointSet(int n){
        parent = new int[n+1];
        size= new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] = i;
            size[i] =1;
        }
    }
    void unionBySize(int u, int v){
        int parent_u = find(u);
        int parent_v = find(v);

        if(parent_u == parent_v) return;

        if(size[parent_u] < size[parent_v]){
            parent[parent_u] = parent[parent_v];
            size[parent_v] += size[parent_u];
        }
        else{
            parent[parent_v] = parent[u];
            size[parent_u] += size[parent_v];
        }
    }

    int find(int node){
        if(parent[node] == node) return node;

        parent[node] = find(parent[node]);
        return parent[node];
    }
}