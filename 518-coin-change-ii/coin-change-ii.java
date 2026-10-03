class Solution {
    public int change(int k, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][k+1];

        for(int i=0; i<n; i++) dp[i][0] = 1;

        for(int amount=0; amount<=k; amount++) if(amount%coins[0]==0) dp[0][amount] =1;

        for(int i=1; i<n; i++){
            for(int amount =0; amount<=k; amount++){
    
                int nottake = dp[i-1][amount];

                int take = 0;
                if(amount>= coins[i])
                    take = dp[i][amount-coins[i]];

                dp[i][amount] = (nottake+take);
            }
        }


        return dp[n-1][k];
    }
}