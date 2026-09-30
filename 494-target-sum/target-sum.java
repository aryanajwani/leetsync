class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int[][] dp = new int[arr.length][40001];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);

        return countWaysFrom(0, target, arr, dp);
    }

    //no of ways that contain from i onwards, this target 
    int countWaysFrom(int i, int target, int[] arr, int[][] dp){
        if(i==arr.length) {
            if(target==0) return 1;
            return 0;
        }

        if(dp[i][target+20000] !=-1) return dp[i][target+20000];

        int plus = countWaysFrom(i+1, target-arr[i], arr, dp); // plus
        int minus = countWaysFrom(i+1, target+arr[i], arr, dp); // minus

        return dp[i][target+20000] = plus+minus; 
    }
}
