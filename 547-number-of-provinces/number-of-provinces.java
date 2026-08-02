class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet dset = new DisjointSet(n);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1 ) dset.unionBySize(i+1, j+1);
            }
        }

        int count=0;
        for(int i=1; i<=n; i++){
            if(dset.getUParent(i) == i) count++;
        }

        return count;
    }
}

class DisjointSet{
    int[] parent;
    int[] size;

    public DisjointSet(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void unionBySize(int u, int v){
        int uParent_u = getUParent(u);
        int uParent_v = getUParent(v);

        if(uParent_u == uParent_v) return;

        if(size[uParent_u] < size[uParent_v]){
            parent[uParent_u] = uParent_v;
            size[uParent_v] += size[uParent_u];
        }
        else{
            parent[uParent_v] = uParent_u;
            size[uParent_u] += size[uParent_v];
        }
    }

    public int getUParent(int node){
        if(parent[node] == node) return node;

        parent[node] = getUParent(parent[node]);
        return parent[node];
    }
}