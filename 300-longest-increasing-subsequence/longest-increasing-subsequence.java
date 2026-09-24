class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        return find(0, -1, nums, dp);
    }

    //find longest LIS from index i onwards given prev index taken
    int find(int index, int prev, int[] nums, int[][] dp){
        if(index== nums.length) return 0;

        if(dp[index][prev+1] !=-1) return dp[index][prev+1];

        int nottake= find(index+1, prev, nums, dp);

        int take= Integer.MIN_VALUE;
        if(prev==-1 || nums[index]> nums[prev]){
            take = 1+ find(index+1, index, nums, dp);
        }

        return dp[index][prev+1] = Math.max(take, nottake);
    }
}