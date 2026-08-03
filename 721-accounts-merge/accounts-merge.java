class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet dset = new DisjointSet(n);

        //email -> node
        Map<String, Integer> map = new LinkedHashMap<>();

        for(int i=0; i<n; i++){
            List<String> account = accounts.get(i);

            for(int j=1; j<account.size(); j++){
                String email = account.get(j);

                if(map.containsKey(email)){
                    dset.union(map.get(email), i);
                } 
                else{
                    map.put(email, i);
                }
            }
        }

        Map<Integer, List<String>>  finalMap= new HashMap<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String email = entry.getKey();
            int node = entry.getValue();

            int ultimateParent = dset.get(node);

            List<String> list = finalMap.get(ultimateParent);

            if(list!=null){
                list.add(email);
            }
            else{
                finalMap.put(ultimateParent, new ArrayList<>());
                list = finalMap.get(ultimateParent);

                String name = accounts.get(node).get(0);

                list.add(name);
                list.add(email);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(List<String> list: finalMap.values()) {
            Collections.sort(list.subList(1, list.size()));
            result.add(list);
        }

        return result;
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

    public void union(int u, int v){
        int uParent_u = get(u);
        int uParent_v = get(v);

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

    public int get(int node){
        if(parent[node] == node) return node;

        parent[node] = get(parent[node]);
        return parent[node];
    }
}