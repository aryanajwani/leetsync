class Solution {
    public int rob(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return maxSumFrom(0, arr, dp);
    }

    int maxSumFrom(int i, int[] arr, int[] dp){
        if(i==arr.length-1) return arr[i];

        if(dp[i] !=-1) return dp[i];

        int skip = maxSumFrom(i+1, arr, dp);

        int take = (i+2 < arr.length)? 
            arr[i]+maxSumFrom(i+2, arr, dp) : arr[i];

        return dp[i] = Math.max(skip, take);
    }
}