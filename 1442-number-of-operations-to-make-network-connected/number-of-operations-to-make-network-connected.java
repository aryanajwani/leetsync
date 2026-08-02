class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet dset = new DisjointSet(n);

        int extraEdges = 0;
        for(int[] connection : connections){
            int u = connection[0]; 
            int v = connection[1];

            if(dset.getUParent(u) == dset.getUParent(v)) extraEdges++;
            else{
                dset.unionBySize(u, v);
            } 
        }

        int components=0;
        for(int i=0; i<n; i++) if(dset.parent[i] == i) components++;

        if(extraEdges >= components-1) return components-1;

        return -1;
    }
}

//count the extra edges
//count the no of components 
// if(extra edges>= no of components-1) true
// else false

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