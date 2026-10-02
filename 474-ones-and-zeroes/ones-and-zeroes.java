class Solution {
    public int findMaxForm(String[] strs, int zeroes, int ones) {
        int n = strs.length;

        int dp[][][] = new int[n][zeroes+1][ones+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return maxFrom(n-1, zeroes, ones, strs, dp);
    }

    int maxFrom(int i, int zeroes, int ones, String[] strs, int[][][] dp){
        if(i==0){
            int[] count = count(strs[i]);

            if(count[0]<=zeroes && count[1]<=ones) return 1;
            else return 0;
        }

        if(dp[i][zeroes][ones] !=-1) return dp[i][zeroes][ones];

        int nottake = maxFrom(i-1, zeroes, ones, strs, dp);

        int[] count = count(strs[i]);
        int take = Integer.MIN_VALUE;

        if(count[0]<=zeroes && count[1]<=ones)
            take = 1 + maxFrom(i-1, zeroes-count[0], ones-count[1], strs, dp);

        return dp[i][zeroes][ones] = Math.max(take, nottake);
    }

    int[] count(String str){
        int n = str.length();

        int result[] = new int[2];

        for(int i=0; i<n; i++){
            if(str.charAt(i)=='0') result[0]++;
            else result[1]++; 
        }

        return result;
    }    
}