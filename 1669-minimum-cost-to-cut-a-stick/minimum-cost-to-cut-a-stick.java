class Solution {
    public int minCost(int n, int[] c) {
        int[] cuts  = new int[c.length+2];
        cuts[0] = 0;
        System.arraycopy(c, 0, cuts, 1, c.length);
        cuts[c.length+1] = n;
        Arrays.sort(cuts);

        int[][] dp = new int[cuts.length-1][cuts.length];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);

        return minCostBetween(0, cuts.length-1, cuts, dp);
    }

    int minCostBetween(int i, int j, int[] cuts, int[][] dp){
        if(cuts[i+1] == cuts[j]) return 0;

        if(dp[i][j] !=-1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;
        for(int k=i+1; k<j; k++){
            int right  = minCostBetween(i, k, cuts, dp);
            int left = minCostBetween(k, j, cuts, dp);

            int cost = right+left;
            minCost = Math.min(minCost, cost);
        }

        return dp[i][j] = cuts[j]-cuts[i] + minCost;
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

