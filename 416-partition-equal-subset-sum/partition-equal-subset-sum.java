class Solution {
    public boolean canPartition(int[] nums) {
        int total =0;
        for(int i=0; i<nums.length; i++) total += nums[i];

        if(total%2 !=0) return false;
        int target = total/2;

        Boolean[][] dp = new Boolean[nums.length][target+1];

        return contains(0, target, nums, 0, dp);
    }

    //contains subsequence with remsum from this index onwads ?
    boolean contains(int i, int remsum, int[] nums, int count, Boolean[][] dp){
        if(remsum==0) return true;

        if(i == nums.length) return false;
        if(remsum<0) return false;

        if(dp[i][remsum] != null) return dp[i][remsum];

        boolean pick = contains(i+1, remsum- nums[i], nums, count+1, dp);
        boolean notpick = contains(i+1, remsum, nums, count, dp);

        return dp[i][remsum] = pick || notpick;
    }
}
