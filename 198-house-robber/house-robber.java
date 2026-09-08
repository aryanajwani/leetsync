class Solution {
    public int rob(int[] arr) {
        int n = arr.length;

        int[] dp = new int[n];
        dp[n-1] = arr[n-1];

        for(int i=n-2; i>=0; i--){
            int skip = dp[i+1];

            int take = (i+2 < arr.length)? 
                            arr[i]+dp[i+2] : arr[i];

            dp[i] = Math.max(skip, take);
        }

        return dp[0];
    }
}