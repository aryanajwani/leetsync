class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return ways(n, dp);
    }

    int ways(int i, int[] dp){
        if(i==1 || i==0) return 1;

        if(dp[i]!=-1) return dp[i];

        return dp[i] = ways(i-1, dp) + ways(i-2, dp);
    }
}