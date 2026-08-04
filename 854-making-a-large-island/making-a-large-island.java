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
        int uParent_u = find(u);
        int uParent_v = find(v);

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

    public int find(int node){
        if(parent[node] == node) return node;

        parent[node] = find(parent[node]);
        return parent[node];
    }
}

class Solution {
    boolean isValid(int i, int j, int n, int m){
        return i>=0 && i<n && j>=0 && j<m;
    }

    public int largestIsland(int[][] arr) {
        int n = arr.length;

        DisjointSet dset = new DisjointSet(n*n);
        int directions[][] = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        boolean isVisited[][] = new boolean[n][n];
        int maxSize=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 0) continue;

                isVisited[i][j] = true;
                int node = n*i + j;

                for(int dir[] : directions){
                    int ni = i+dir[0];
                    int nj = j+dir[1];

                    if(isValid(ni, nj, n, n)){
                        int neighbour  = n*ni + nj;

                        if(isVisited[ni][nj]){
                            dset.unionBySize(neighbour, node);
                        }
                    }
                }

                maxSize = Math.max(maxSize, dset.size[dset.find(node)]);
            }
        }

        for(int i=0; i<n*n; i++) if(dset.parent[i] == i) System.out.print(i +" "+dset.size[i]+" ");
        System.out.println();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(arr[i][j] == 0){
                    int size = 1;

                    //left right up down
                    int[] parents = new int[]{-1, -1, -1, -1};

                    for(int k=0; k<directions.length; k++){
                        int ni = i+directions[k][0];
                        int nj = j+directions[k][1];
                        int neighbour  = n*ni + nj;

                        if(isValid(ni, nj, n, n) && arr[ni][nj]==1){
                            int ultimateParent = dset.find(neighbour);

                            boolean alreadyAdded=false;
                            for(int parent : parents){
                                if(parent==ultimateParent) alreadyAdded=true;
                            }

                            parents[k] = ultimateParent;
                            if(!alreadyAdded) size+= dset.size[ultimateParent];
                        }
                    }

                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        return maxSize;
    }
}