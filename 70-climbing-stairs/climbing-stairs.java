class Solution {
    public int climbStairs(int n) {
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);

        int prev_ = 1;
        int prev = 1;

        for(int i=2; i<=n; i++){
            int curr = prev+prev_;
            prev_ = prev;
            prev = curr;
        }

        return prev;

        // return ways(n, dp);
    }

    // int ways(int i, int[] dp){
    //     if(i==1 || i==0) return 1;

    //     if(dp[i]!=-1) return dp[i];

    //     return dp[i] = ways(i-1, dp) + ways(i-2, dp);
    // }
}