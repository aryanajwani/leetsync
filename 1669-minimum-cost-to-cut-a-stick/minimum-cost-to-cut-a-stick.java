record Pair(int i, int j){}

class Solution {
    
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        Map<Pair, Integer> map = new HashMap<>();

        return minBetween(0, n, cuts, map);
    }

    int minBetween(int i, int j, int[] cuts, Map<Pair, Integer> map){
        Pair pair = new Pair(i, j);

        if(map.containsKey(pair)) return map.get(pair);
        
        int min = Integer.MAX_VALUE;
        for(int k=0; k<cuts.length; k++){
            if(cuts[k]> i && cuts[k]<j){
                int right = minBetween(i, cuts[k], cuts, map);
                int left = minBetween(cuts[k], j, cuts, map);

                min = Math.min(min, right+left);
            }
        }

        int result;

        if(min==Integer.MAX_VALUE) result = 0;
        else result =  j-i +min;

        map.put(pair, result);
        return result;
    }
}

//         0, 7
// 0, 1            1, 7
//              1, 3  3, 7    

// 5 -> 0 + 2
// 4 -> 0+3

// 3+0   4+2  


// 7 + 9


// 0,1 1,7         0,3 3,7       0,4 4,7       0,5  5,7

