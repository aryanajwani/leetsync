class Solution {
    public int rob(int[] money) {
        int n= money.length;
        if(n==1) return money[0];

        int[] dp = new int[n];
        int[] dp_ = new int[n];

        dp[1] = money[1];
        for(int i=2; i<n; i++){
            int rob = money[i];
            if(i>2) rob += dp[i-2];

            int notrob = dp[i-1];

            dp[i] = Math.max(rob, notrob);
        }
        int case1 = dp[n-1];

        dp_[0] = money[0];
        for(int i=1; i<n-1; i++){
            int rob = money[i];
            if(i>1) rob += dp_[i-2];

            int notrob = dp_[i-1];
            dp_[i] = Math.max(rob, notrob);
        }
        int case2 = dp_[n-2];

        return Math.max(case1, case2);
    }
}


