class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1]= nums[n-1];

        for(int i=n-2; i>=0; i--){
            int pick= nums[i];
            if(i+2<n) pick += dp[i+2];

            int notpick = dp[i+1];

            dp[i] = Math.max(pick, notpick);
        }

        return dp[0];
    }
}